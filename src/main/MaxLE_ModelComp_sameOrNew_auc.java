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
public class MaxLE_ModelComp_sameOrNew_auc implements Policy{
	
	private HashMap<String, Float> sortedAllPuzzle_PredMap;
	private float lastPred = 0.0f;
	private int lastCogL = 0;

	private ArrayList<Float> predToSuggest = new ArrayList<>();
	private ArrayList<Float> secondChoicePred = new ArrayList<>();
	private ArrayList<Float> thirdChoicePred = new ArrayList<>();
	private ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	private HashMap<Integer, Float> level_predMap = new HashMap<>();

	public MaxLE_ModelComp_sameOrNew_auc (HashMap<String,Float> sortedAllPuzzle_PredMap, float lastPred, int lastCogL) {
		this.sortedAllPuzzle_PredMap = sortedAllPuzzle_PredMap;
		this.lastPred = lastPred;
		this.lastCogL = lastCogL;
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
		
		for (Integer level : level_predMap.keySet()) {
			assignPredictionLevel(level, level_predMap.get(level));
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
	
	private void assignPredictionLevel(int level, float pred) {
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
				level_predMap.put(0, pred);
			}
		}else if (direction.equals("greater")) {
			Collections.sort(predictions);	// sort by ascending order
			int level = 0;
			float lastLevel_pred = lastPred;
			for (Float pred : predictions) {
				if (lastLevel_pred != pred) {
					level += 1;
				}
				level_predMap.put(level, pred);
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
				level_predMap.put(level, pred);
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
