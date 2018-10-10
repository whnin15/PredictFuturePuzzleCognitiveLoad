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
public class MaxLearningEfficiencyPolicy {
	
	private HashMap<String, Float> sortedAllPuzzle_PredMap;
	private PathwayPuzzle lastPuzzle;
	private float lastPred;
	private int lastCogL;

	private ArrayList<Float> predToSuggest = new ArrayList<>();
	private ArrayList<Float> secondChoicePred = new ArrayList<>();
	private ArrayList<Float> thirdChoicePred = new ArrayList<>();
	private ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	private HashMap<Float, Integer> pred_cogLMap = new HashMap<>();

	public MaxLearningEfficiencyPolicy(HashMap<String,Float> sortedAllPuzzle_PredMap, PathwayPuzzle lastPuzzle, float lastPred, int lastCogL) {
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

		int numCogLClass;
		int start;
		
		predToSuggest = new ArrayList<>();
		secondChoicePred = new ArrayList<>();
		
		if (lastPuzzle == null) {
//			System.out.println("lastPuzzle is null");
			
			// if last puzzle is null, this is the first puzzle after sequential. Use the predictions and compare with each other
			ArrayList<Float> uniquePred = getUniquePredValues();
	
			if (Collections.min(uniquePred) > lastPred) {
				start = lastCogL;
			} else {
				start = -4;
			}
			numCogLClass = 5 - start + 1;
			pred_cogLMap = predictCognitiveLoadFromPredictions(uniquePred, start, numCogLClass, "ascending");
		}else {
//			System.out.println();
//			System.out.println("lastPuzzle: " + lastCogL + ", " + lastPred);
			
			// if last puzzle is not null, use the last puzzle as guide to the possible cognitive loads
			ArrayList<Float> uniquePredLessThan = getUniquePredValuesLessThanPrevCogL();
			ArrayList<Float> uniquePredGreaterThan = getUniquePredValuesGreaterThanPrevCogL();
			
			HashMap<Float, Integer> pred_cogLMap_greater = new HashMap<>();
			HashMap<Float, Integer> pred_cogLMap_lessThan = new HashMap<>();
			if (uniquePredGreaterThan.size() > 0) {
				start = lastCogL+1;
				numCogLClass = 5 - start + 1;
				pred_cogLMap_greater = predictCognitiveLoadFromPredictions(uniquePredGreaterThan, start, numCogLClass, "ascending");
			}

			if (uniquePredLessThan.size() > 0) {
				start = lastCogL -1;
				numCogLClass = start - (-4) + 1;
				pred_cogLMap_lessThan = predictCognitiveLoadFromPredictions(uniquePredLessThan,  start, numCogLClass, "descending");
			}
			
			// combine the two maps
			for (Float pred: pred_cogLMap_greater.keySet()) {
				pred_cogLMap.put(pred, pred_cogLMap_greater.get(pred));
			}
			for (Float pred: pred_cogLMap_lessThan.keySet()) {
				pred_cogLMap.put(pred, pred_cogLMap_lessThan.get(pred));
			}
			if (existsLastPredInPuzPredMap()) {
				pred_cogLMap.put(lastPred, lastCogL);
			}
		}
		getPreferredPredictions(pred_cogLMap);

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
	
	public HashMap<Float,Integer> getExpectedCogLs(ArrayList<Float> predList) {
		HashMap<Float, Integer> suggestedPred_cogLMap = new HashMap<>();
		for (Float pred : predList) {
			suggestedPred_cogLMap.put(pred, pred_cogLMap.get(pred));
		}
		return suggestedPred_cogLMap;
	}
	
	private void getPreferredPredictions(HashMap<Float, Integer> pred_cogLMap) {
		if (lastCogL < -1) {
			// we want to increase by 2
			int cognitiveLoadWanted = lastCogL +2;
			int bestload = -5;
			float bestload_pred = 100.0f;
			boolean addToUndesired = false;

			for (Float pred: pred_cogLMap.keySet()) {
				int expectedCogLForPred = pred_cogLMap.get(pred);
				if (expectedCogLForPred == cognitiveLoadWanted ) {
					predToSuggest.add(pred);
				} else if ( (expectedCogLForPred == (cognitiveLoadWanted -1)) || (expectedCogLForPred == (cognitiveLoadWanted + 1)) ) {
					secondChoicePred.add(pred);
				} else if ((expectedCogLForPred >= lastCogL) && expectedCogLForPred < 2) {
					thirdChoicePred.add(pred);
				}else {
					//choose the closest one. choose in the order of 2, -3, -4, 3, 4, 5. It will be better to work 2 (a bit hard) than very easy after easy puzzle.
					if (bestload < expectedCogLForPred && expectedCogLForPred < 3) {
						bestload = expectedCogLForPred;
						bestload_pred = pred;
					}else if (bestload == -5 && expectedCogLForPred >= 3) {
						bestload_pred = pred;
					}
					addToUndesired = true;
				}
			}		
			
			if (addToUndesired) {
				undesiredChoicePred.add(bestload_pred);
			}
			
		} else if (lastCogL > 1) {
			// we want to give next puzzle < 0
			for (Float pred: pred_cogLMap.keySet()) {
				int expectedCogLForPred = pred_cogLMap.get(pred);
				if (expectedCogLForPred < 0) {
					predToSuggest.add(pred);
				} else if ( expectedCogLForPred <= 1 ) {
					secondChoicePred.add(pred);
				} else {
					float min = Collections.min( pred_cogLMap.keySet() );
					undesiredChoicePred.add(min);
					break;
				}
			}
			
		}else {
			int bestload = -5;
			float bestload_pred = 100.0f;
			boolean addToUndesired = false;

			// give puzzles between -1 and 1
			for (Float pred: pred_cogLMap.keySet()) {
				int expectedCogLForPred = pred_cogLMap.get(pred);
				if ( (expectedCogLForPred >= -1) && (expectedCogLForPred <= 1)) {
					predToSuggest.add(pred);
				} else if (expectedCogLForPred == -2) {
					secondChoicePred.add(pred);
				} else if (expectedCogLForPred == 2) {
					thirdChoicePred.add(pred);
				} else {
					//choose the closest one. choose in the order of -3, -4, 3, 4, 5.
					if (bestload < expectedCogLForPred && expectedCogLForPred < 3) {
						bestload = expectedCogLForPred;
						bestload_pred = pred;
					}else if (bestload == -5 && expectedCogLForPred >= 3) {
						bestload_pred = pred;
					}
					addToUndesired = true;				}
			}

			if (addToUndesired) {
				undesiredChoicePred.add(bestload_pred);
			}
			
		}
	}

	private boolean existsLastPredInPuzPredMap() {
		for (String puzzle : this.sortedAllPuzzle_PredMap.keySet()) {
			if ( (this.sortedAllPuzzle_PredMap.get(puzzle) == lastPred) ) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<Float> getUniquePredValues() {
		ArrayList<Float> values = new ArrayList<>();
		for (String puzzle : this.sortedAllPuzzle_PredMap.keySet()) {
			float prediction = this.sortedAllPuzzle_PredMap.get(puzzle);
			if (!values.contains( prediction ) ) {
				values.add(prediction);
			}
		}
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
		return values;
	}
	
	private HashMap<Float, Integer> predictCognitiveLoadFromPredictions(ArrayList<Float> values, int startCogL, int numCogLClass, String order) {
		float interval;
		HashMap<Float, Integer> pred_CogLMap;
		if (values.size() < numCogLClass) {
			interval = 0;
		}
		else {
			interval = ( Collections.max(values) - Collections.min(values) ) /(float) numCogLClass;
		}
		pred_CogLMap = getCogLFromPred(values, interval, startCogL, numCogLClass, order);			

		return pred_CogLMap;
	}
	
	private HashMap<Float, Integer> getCogLFromPred( ArrayList<Float> values, float interval, int startCogL, int numCogLClass, String order) {
//		System.out.println(startCogL + ", " + interval + ", " + order + ", " + numCogLClass + ", " + Collections.max(values) + ", " + Collections.min(values));
		
		HashMap<Float, Integer> pred_cogLMap = new HashMap<>();
		if (order.equals("ascending")) {
			float boundary = values.get(0) + interval;	//to see when the cognitive load should be increased
			int cogL = startCogL;
			
			for (Float pred : values) {
				if (pred > boundary) {
					cogL++;
					boundary = boundary + interval;
				}
				if (cogL > 5) {
					cogL=5;
				}
				pred_cogLMap.put(pred, cogL);
			}
		}else {
			float boundary = values.get(values.size()-1) - interval;
			int cogL = startCogL;
			
			for (int i = values.size()-1; i >=0; i--) {
				if(values.get(i) < boundary) {
					cogL--;
					boundary = boundary - interval;
				}
				if (cogL < -4) {
					cogL = -4;
				}
				pred_cogLMap.put(values.get(i), cogL);
			}
		}
		return pred_cogLMap;
	}
}
