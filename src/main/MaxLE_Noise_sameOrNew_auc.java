package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Wint Hnin
 */
public class MaxLE_Noise_sameOrNew_auc implements Policy{
	
	private HashMap<String, Float> sortedAllPuzzle_PredMap;
	private float lastPred = 0.0f;
	private int lastCogL = 0;
	private boolean isNoise = false;

	private ArrayList<Float> predToSuggest = new ArrayList<>();
	private ArrayList<Float> secondChoicePred = new ArrayList<>();
	private ArrayList<Float> thirdChoicePred = new ArrayList<>();
	private ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	private HashMap<Float,Integer> pred_levelMap = new HashMap<>();

	public MaxLE_Noise_sameOrNew_auc (HashMap<String,Float> sortedAllPuzzle_PredMap, float lastPred, int lastCogL, boolean isNoise) {
		this.sortedAllPuzzle_PredMap = sortedAllPuzzle_PredMap;
		this.lastPred = lastPred;
		this.lastCogL = lastCogL;
		this.isNoise = isNoise;
		
		if (this.lastCogL == -10) { // begin
			this.lastPred = 0f;
			this.lastCogL = 0;
		}
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
			assignPredictionLevel(prediction, pred_levelMap.get(prediction), puzzleName);
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
	
	private void assignPredictionLevel(float pred, int level, String puzzleName) {
		if (!isNoise) {
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
			if (lastCogL > 1) {
				if (pred < 0) {
					addToArray(predToSuggest, pred);
				}else {
					addToArray(undesiredChoicePred, pred);
				}
			}else {
				if (pred >= -1 && pred <= 1) {
					addToArray(predToSuggest, pred);
				}else if (pred >= -2 && pred <= 2) {
					addToArray(secondChoicePred, pred);
				}else if (pred < -2) {
					addToArray(thirdChoicePred, pred);
				}else {
					addToArray(undesiredChoicePred, pred);
				}
			}
		}
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
