package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Wint Hnin
 */
public class MaxLE_ModelComp_linearEq_auc implements Policy{
	
	private HashMap<String, Float> sortedAllPuzzle_PredMap;
	private float lastPred = 0.0f;
	private int lastCogL = 0;
	private String lastModel = "";
	HashMap<String, String> puzzle_model_map;

	private ArrayList<Float> predToSuggest = new ArrayList<>();
	private ArrayList<Float> secondChoicePred = new ArrayList<>();
	private ArrayList<Float> thirdChoicePred = new ArrayList<>();
	private ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	private HashMap<Float,Integer> pred_levelMap = new HashMap<>();
	
	private HashMap<String, float[]> linearModelMap = new HashMap<>();

	public MaxLE_ModelComp_linearEq_auc (HashMap<String,Float> sortedAllPuzzle_PredMap, float lastPred, int lastCogL, String lastModel, HashMap<String, String> puzzle_model_map) {
		this.sortedAllPuzzle_PredMap = sortedAllPuzzle_PredMap;
		this.lastPred = lastPred;
		this.lastCogL = lastCogL;
		this.lastModel = lastModel;
		this.puzzle_model_map = puzzle_model_map;

		linearModelMap.put("T", new float[]{(float) 0.2605, (float) 0.8507});
		linearModelMap.put("C", new float[]{(float) 2.577, (float) 1.631});
		linearModelMap.put("CbCe", new float[]{(float) -0.2449, (float) 0.8603});
		linearModelMap.put("CbTe", new float[]{(float) 0.9401, (float) 1.2335});
		linearModelMap.put("TbCe", new float[]{(float) -0.1969, (float) 0.8128});
		linearModelMap.put("CbTe/TbCe", new float[]{(float) 1.325, (float) 1.167});
		linearModelMap.put("TbOe", new float[]{(float) 0.03394, (float) 1.07021});
		linearModelMap.put("TbObTee", new float[]{(float) -0.0284, (float) 0.9553});
		linearModelMap.put("TbObCee", new float[]{(float) -0.3333, (float) 0});
		linearModelMap.put("TbCOe", new float[]{(float) -1.667, (float) 0});
		linearModelMap.put("TbCObTee", new float[]{(float) 5, (float) 0});
	}
	
	public ArrayList<String> choosePuzzleSet() {
		getSuitablePredictions();
		ArrayList<String> puzzleSet = new ArrayList<String>();
		for (String puzzleName : sortedAllPuzzle_PredMap.keySet()) {
			if (predToSuggest.contains(sortedAllPuzzle_PredMap.get(puzzleName))) {
				puzzleSet.add(puzzleName);
			}
		}
		return puzzleSet;
	}
	
	public ArrayList<Float> getSuitablePredictions() {
		getUniquePredValuesSameAsPrevCogL();
		getUniquePredValuesLessThanPrevCogL();
		getUniquePredValuesGreaterThanPrevCogL();
		
		for (String puzzleName : sortedAllPuzzle_PredMap.keySet()) {
			float prediction = sortedAllPuzzle_PredMap.get(puzzleName);
			assignPredictionLevel(prediction, pred_levelMap.get(prediction), puzzleName, puzzle_model_map.get(puzzleName));
		}
		return predToSuggest;
	}
	
	public ArrayList<Float> getSecondChoicePred() {
		return secondChoicePred;
	}
	
	public ArrayList<Float> getThirdChoicePred() {
		return thirdChoicePred;
	}
	
	public ArrayList<Float> getUndesiredChoicePred() {
		return undesiredChoicePred;
	}
	
	private void assignPredictionLevel(float pred, int level, String puzzleName, String puzzleModel) {
		boolean isSameModel = false;
		if (puzzleModel.equals(lastModel)) {
			isSameModel = true;
		}
		if (isSameModel) {
			// give -1 and 1 all the time or as close to that as possible, or if the lastCogL > 1, give < 0.
			if (lastCogL > 1) {
				int targetLevel = -1 - lastCogL;
				if (level <= targetLevel) {
					addToArray(predToSuggest, pred);
				}else {
					addToArray(undesiredChoicePred, pred);
				}
			}else {
				if (level >= (-1-lastCogL) && level <= (1-lastCogL) ) {
					addToArray(predToSuggest, pred );
				} else if (level == (-2-lastCogL) || level == (2-lastCogL) ) {
					addToArray(secondChoicePred, pred );
				} else if (level < (-2-lastCogL) ) {
					addToArray(thirdChoicePred, pred );
				} else {
					addToArray(undesiredChoicePred, pred );
				}
			}
		}else {
			// use linear model
			float[] linearModel = linearModelMap.get(puzzleModel);
			if (lastCogL > 1) {
				if (pred < getPredFromLM(0, linearModel[0], linearModel[1])) {
					addToArray(predToSuggest, pred);
				}else {
					addToArray(undesiredChoicePred, pred);
				}
			}else {
				if (pred >= getPredFromLM(-1, linearModel[0], linearModel[1]) && pred <= getPredFromLM(1, linearModel[0], linearModel[1])) {
					addToArray(predToSuggest, pred);
				}else if (pred >= getPredFromLM(-2, linearModel[0], linearModel[1]) && pred <= getPredFromLM(2, linearModel[0], linearModel[1])) {
					addToArray(secondChoicePred, pred);
				}else if (pred < getPredFromLM(-2, linearModel[0], linearModel[1])) {
					addToArray(thirdChoicePred, pred);
				}else {
					addToArray(undesiredChoicePred, pred);
				}
			}
		}
	}
	
	private float getPredFromLM(float cogL, float intercept, float slope) {
		return ((cogL - intercept) / slope);
	}

	private ArrayList<Float> getUniquePredValuesSameAsPrevCogL() {
		ArrayList<Float> values = new ArrayList<>();
		for (String puzzle : this.sortedAllPuzzle_PredMap.keySet()) {
			float prediction = this.sortedAllPuzzle_PredMap.get(puzzle);
			if (!values.contains( prediction ) && (prediction == lastPred) ) {
				values.add(prediction);
			}
		}
		assignCogLLevels(values, "same");
		return values;
	}
	
	private ArrayList<Float> getUniquePredValuesLessThanPrevCogL() {
		ArrayList<Float> values = new ArrayList<>();
		for (String puzzle : this.sortedAllPuzzle_PredMap.keySet()) {
			float prediction = this.sortedAllPuzzle_PredMap.get(puzzle);
			if (!values.contains( prediction ) && (prediction < lastPred)) {
				values.add(prediction);
			}
		}
		assignCogLLevels(values, "lower");
		return values;
	}
	
	private ArrayList<Float> getUniquePredValuesGreaterThanPrevCogL() {
		ArrayList<Float> values = new ArrayList<>();
		for (String puzzle : this.sortedAllPuzzle_PredMap.keySet()) {
			float prediction = this.sortedAllPuzzle_PredMap.get(puzzle);
			if (!values.contains( prediction ) && (prediction > lastPred)) {
				values.add(prediction);
			}
		}
		assignCogLLevels(values, "greater");
		return values;
	}
	
	private void assignCogLLevels(ArrayList<Float> predictions, String direction) {
		if (direction.equals("same") ) {
			for (Float pred : predictions) {
				pred_levelMap.put(pred, 0);
			}
		}else if (direction.equals("greater")) {
			Collections.sort(predictions);	// sort by ascending order
			int level = 0;
			float lastLevel_pred = lastPred;
			for (Float pred : predictions) {
				if (lastLevel_pred != pred) {
					level += 1;
				}
				pred_levelMap.put(pred, level);
				lastLevel_pred = pred;
				
			}
		}else {
			Collections.sort(predictions, Collections.reverseOrder());	// sort by descending order
			int level = 0;
			float lastLevel_pred = lastPred;
			for (Float pred : predictions) {
				if (lastLevel_pred != pred) {
					level -= 1;
				}
				pred_levelMap.put(pred, level);
				lastLevel_pred = pred;
			}
		}
	}
	
	public void addToArray(ArrayList<Float> array, float prediction) {
		if (!array.contains(prediction)) {
			array.add(prediction);
		}
	}
}
