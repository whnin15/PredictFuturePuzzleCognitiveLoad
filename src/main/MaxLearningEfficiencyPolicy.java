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
	
	public MaxLearningEfficiencyPolicy(HashMap<String,Float> sortedAllPuzzle_PredMap, PathwayPuzzle lastPuzzle, float lastPred, int lastCogL) {
		this.sortedAllPuzzle_PredMap = sortedAllPuzzle_PredMap;
		this.lastPuzzle = lastPuzzle;
		this.lastPred = lastPred;
		this.lastCogL = lastCogL;
	}
	
	public ArrayList<String> choosePuzzleSet() {
		ArrayList<Float> predToSuggest = getSuitablePredictions();
		ArrayList<String> puzzleSet = new ArrayList<String>();
		for (String puzzleName : sortedAllPuzzle_PredMap.keySet()) {
			if (predToSuggest.contains(sortedAllPuzzle_PredMap.get(puzzleName))) {
				puzzleSet.add(puzzleName);
			}
		}
		return puzzleSet;
	}
	
	public ArrayList<Float>  getSuitablePredictions() {

		int numCogLClass;
		int start;
		String order;
		ArrayList<Float> predToSuggest = new ArrayList<>();
		
		if (lastPuzzle == null) {
			System.out.println("lastPuzzle is null");
			
			// if last puzzle is null, this is the first puzzle after sequential. Use the predictions and compare with each other
			ArrayList<Float> uniquePred = getUniquePredValues();
			System.out.println("uniquePred: " + Arrays.toString(uniquePred.toArray()));
			
			if (Collections.min(uniquePred) > lastPred) {
				start = lastCogL;
			} else {
				start = -4;
			}
			numCogLClass = 5 - start + 1;

			System.out.println("nullPuz:" + start + ", " + "ascending" + ", " + numCogLClass + ", " + Collections.max(uniquePred) + ", " + Collections.min(uniquePred));

			HashMap<Float, Integer> pred_cogLMap = predictCognitiveLoadFromPredictions(uniquePred, start, numCogLClass, "ascending");
			for (Float pred: pred_cogLMap.keySet()) {
				System.out.println(pred + ": " + pred_cogLMap.get(pred) + ", ");
			}
			System.out.println();

			predToSuggest = getPreferredPredictions(pred_cogLMap, predToSuggest);

		}else {
			System.out.println("lastPuzzle: " + lastCogL);
			// if last puzzle is not null, use the last puzzle as guide to the possible cognitive loads
			ArrayList<Float> uniquePredLessThan = getUniquePredValuesLessThanPrevCogL();
			ArrayList<Float> uniquePredGreaterThan = getUniquePredValuesGreaterThanPrevCogL();
			
			System.out.println("uniquePredLessThan: " + Arrays.toString(uniquePredLessThan.toArray()));
			System.out.println("uniquePredGreaterThan: " + Arrays.toString(uniquePredGreaterThan.toArray()));	
			
			if (uniquePredGreaterThan.size() > 0 && lastCogL <= 1) {
				start = lastCogL+1;
				numCogLClass = 5 - start + 1;

				System.out.println("greater than:" + start + ", " + "ascending" + ", " + numCogLClass + ", " + Collections.max(uniquePredGreaterThan) + ", " + Collections.min(uniquePredGreaterThan));
				HashMap<Float, Integer> pred_cogLMap_greater = predictCognitiveLoadFromPredictions(uniquePredGreaterThan, start, numCogLClass, "ascending");
				predToSuggest = getPreferredPredictions(pred_cogLMap_greater, predToSuggest);
				
				for (Float pred: pred_cogLMap_greater.keySet()) {
					System.out.println(pred + ": " + pred_cogLMap_greater.get(pred) + ", ");
				}
				System.out.println();
			}
			if (uniquePredLessThan.size() > 0 && lastCogL >= -1) {
				start = lastCogL -1;
				numCogLClass = lastCogL - (-4) + 1;

				System.out.println("less than:" + start + ", " + "descending" + ", " + numCogLClass + ", " + Collections.max(uniquePredLessThan) + ", " + Collections.min(uniquePredLessThan));
				HashMap<Float, Integer> pred_cogLMap_lessThan = predictCognitiveLoadFromPredictions(uniquePredLessThan,  start, numCogLClass, "descending");
				predToSuggest = getPreferredPredictions(pred_cogLMap_lessThan, predToSuggest);
				
				for (Float pred: pred_cogLMap_lessThan.keySet()) {
					System.out.println(pred + ": " + pred_cogLMap_lessThan.get(pred) + ", ");
				}
				System.out.println();
			}
			
			// if last prediction is also included, we expect to have same cogL. So, include only if the cognitive load for that prediction is between -1 and 1.
			for (String puzzle : this.sortedAllPuzzle_PredMap.keySet()) {
				if ( (this.sortedAllPuzzle_PredMap.get(puzzle) == lastPred) && (lastCogL >= -1 && lastCogL <= 1) ) {
					predToSuggest.add(lastPred);
				}
			}
		}
System.out.println(Arrays.toString(predToSuggest.toArray()));
		return predToSuggest;
	}
	
	private ArrayList<Float> getPreferredPredictions(HashMap<Float, Integer> pred_cogLMap, ArrayList<Float> predToSuggest) {
		if (lastCogL < -1) {
			// we want to increase by 2
			for (Float pred: pred_cogLMap.keySet()) {
				if (pred_cogLMap.get(pred) == (lastCogL + 2) ) {
					predToSuggest.add(pred);
				}
			}
		} else if (lastCogL > 1) {
			// we want to give next puzzle < 0
			for (Float pred: pred_cogLMap.keySet()) {
				if (pred_cogLMap.get(pred) < 0) {
					predToSuggest.add(pred);
				}
			}
		}else {
			// give puzzles between -1 and 1
			for (Float pred: pred_cogLMap.keySet()) {
				if (pred_cogLMap.get(pred) >= -1 && (pred_cogLMap.get(pred) <= 1)) {
					predToSuggest.add(pred);
				}
			}
		}
		return predToSuggest;
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
		if (values.size() > numCogLClass) {
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
				if (pred >= boundary) {
					cogL++;
					boundary = boundary + interval;
				}
				pred_cogLMap.put(pred, cogL);
			}
		}else {
			float boundary = values.get(values.size()-1) - interval;
			int cogL = startCogL;
			
			for (int i = values.size()-1; i >=0; i--) {
				if(values.get(i) <= boundary) {
					cogL--;
					boundary = boundary - interval;
				}
				pred_cogLMap.put(values.get(i), cogL);
			}
		}
		return pred_cogLMap;
	}
}
