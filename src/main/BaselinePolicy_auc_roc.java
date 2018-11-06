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
public class BaselinePolicy_auc_roc {
	
	private HashMap<String, Float> sortedAllPuzzle_PredMap;
	private PathwayPuzzle lastPuzzle;
	private float lastPred;
	private int lastCogL;

	private ArrayList<Float> predToSuggest = new ArrayList<>();
	private ArrayList<Float> secondChoicePred = new ArrayList<>();
	private ArrayList<Float> thirdChoicePred = new ArrayList<>();
	private ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	private HashMap<Float, Integer> pred_cogLMap = new HashMap<>();

	public BaselinePolicy_auc_roc(HashMap<String,Float> sortedAllPuzzle_PredMap, PathwayPuzzle lastPuzzle, float lastPred, int lastCogL) {
		this.sortedAllPuzzle_PredMap = sortedAllPuzzle_PredMap;
		this.lastPuzzle = lastPuzzle;
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
		// give -1 and 1 all the time or as close to that as possible
		if (Math.round(prediction) >= -1 && Math.round(prediction) <= 1) {
			addToArray(predToSuggest, prediction);
		}else if (Math.round(prediction) == -2 && Math.round(prediction) == 2) {
			addToArray(secondChoicePred, prediction);
		}else if (Math.round(prediction) < -2) {
			addToArray(thirdChoicePred, prediction);
		}else {
			addToArray(undesiredChoicePred, prediction);
		}
//		if (lastCogL < -1) {
//
//			// we want to increase by 2
//			int cognitiveLoadWanted = lastCogL +2;
//			if (Math.round(prediction) == cognitiveLoadWanted) {
//				addToArray(predToSuggest, prediction);
//			} else if (prediction > (cognitiveLoadWanted-1) && prediction <(cognitiveLoadWanted+1) ){
//				addToArray(secondChoicePred, prediction);
//			} else if (prediction >= lastCogL && prediction < 2) {
//				addToArray(thirdChoicePred, prediction);
//			} else {
//				if (undesiredChoicePred.isEmpty()) {
//					addToArray(undesiredChoicePred, prediction);
//				}else {
//					float diff1 = Math.abs(undesiredChoicePred.get(0) - lastCogL );
//					float diff2 = Math.abs(prediction - lastCogL );
//					if (diff2 < diff1) {
//						undesiredChoicePred.remove(0);
//						addToArray(undesiredChoicePred, prediction);
//					}
//				}
//			}
//		} else if (lastCogL > 1) {
//			
//			// we want to give next puzzle < 0
//			if (prediction < 0) {
//				addToArray(predToSuggest, prediction);
//			} else if (prediction <= 1) {
//				addToArray(secondChoicePred, prediction);
//			} else {
//				if (undesiredChoicePred.isEmpty()) {
//					addToArray(undesiredChoicePred, prediction);
//				}else {
//					float diff1 = Math.abs(undesiredChoicePred.get(0) - lastCogL );
//					float diff2 = Math.abs(prediction - lastCogL );
//					if (diff2 > diff1) {
//						undesiredChoicePred.remove(0);
//						addToArray(undesiredChoicePred, prediction);
//					}
//				}
//			}
//		}else {
//			if ( (prediction >= -1) && (prediction <= 1)) {
//				addToArray(predToSuggest, prediction);
//			} else if (prediction == -2) {
//				addToArray(secondChoicePred, prediction);
//			} else if (prediction == 2) {
//				addToArray(thirdChoicePred, prediction);
//			} else {
//				if (undesiredChoicePred.isEmpty()) {
//					addToArray(undesiredChoicePred, prediction);
//				}else {
//					float diff1 = Math.abs(undesiredChoicePred.get(0) - lastCogL );
//					float diff2 = Math.abs(prediction - lastCogL );
//					if (diff2 < diff1) {
//						undesiredChoicePred.remove(0);
//						addToArray(undesiredChoicePred, prediction);
//					}
//				}
//			}			
//		}
	}
	
	public void addToArray(ArrayList<Float> array, float prediction) {
		if (!array.contains(prediction)) {
			array.add(prediction);
		}
	}
}
