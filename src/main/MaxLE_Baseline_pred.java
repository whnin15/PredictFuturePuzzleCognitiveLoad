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
public class MaxLE_Baseline_pred implements Policy{
	
	private HashMap<String, Float> sortedAllPuzzle_PredMap;
	private float lastPred;
	private int lastCogL;

	private ArrayList<Float> predToSuggest = new ArrayList<>();
	private ArrayList<Float> secondChoicePred = new ArrayList<>();
	private ArrayList<Float> thirdChoicePred = new ArrayList<>();
	private ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	private HashMap<Float, Integer> pred_cogLMap = new HashMap<>();

	public MaxLE_Baseline_pred(HashMap<String,Float> sortedAllPuzzle_PredMap, float lastPred, int lastCogL) {
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
		for (String puzzle : sortedAllPuzzle_PredMap.keySet()) {
			assignPredictionLevel(sortedAllPuzzle_PredMap.get(puzzle));
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
	
	public void assignPredictionLevel(float prediction) {
		// give -1 and 1 all the time or as close to that as possible, or if the lastCogL > 1, give < 0.
		if (lastCogL > 1) {
			if (Math.round(prediction) < 0) {
				addToArray(predToSuggest, prediction);
			}else {
				addToArray(undesiredChoicePred, prediction);
			}
		}else {
			if (Math.round(prediction) >= -1 && Math.round(prediction) <= 1) {
				addToArray(predToSuggest, prediction);
			}else if (Math.round(prediction) == -2 || Math.round(prediction) == 2) {
				addToArray(secondChoicePred, prediction);
			}else if (Math.round(prediction) < -2) {
				addToArray(thirdChoicePred, prediction);
			}else {
				addToArray(undesiredChoicePred, prediction);
			}
		}
	}
	
	public void addToArray(ArrayList<Float> array, float prediction) {
		if (!array.contains(prediction)) {
			array.add(prediction);
		}
	}
}
