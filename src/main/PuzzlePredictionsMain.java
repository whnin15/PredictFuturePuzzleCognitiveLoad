/*******************************************************************************
 * Copyright (c) 2008, 2018, Washington University in St. Louis.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Products derived from the software may not be called "Looking Glass", nor
 *    may "Looking Glass" appear in their name, without prior written permission
 *    of Washington University in St. Louis.
 *
 * 4. All advertising materials mentioning features or use of this software must
 *    display the following acknowledgement: "This product includes software
 *    developed by Washington University in St. Louis"
 *
 * 5. The gallery of art assets and animations provided with this software is
 *    contributed by Electronic Arts Inc. and may be used for personal,
 *    non-commercial, and academic use only. Redistributions of any program
 *    source code that utilizes The Sims 2 Assets must also retain the copyright
 *    notice, list of conditions and the disclaimer contained in
 *    The Alice 3.0 Art Gallery License.
 *
 * DISCLAIMER:
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.  ANY AND ALL
 * EXPRESS, STATUTORY OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY,  FITNESS FOR A PARTICULAR PURPOSE,
 * TITLE, AND NON-INFRINGEMENT ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHORS,
 * COPYRIGHT OWNERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING FROM OR OTHERWISE RELATING TO
 * THE USE OF OR OTHER DEALINGS WITH THE SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author Wint Hnin
 */
public class PuzzlePredictionsMain {
	private HashMap<String, PathwayPuzzle> puzzleFeaturesMap = new HashMap<>();
	private HashMap<String, HashMap<String, PathwayUser>> user_puzzle_historyMap = new HashMap<>();

	public PuzzlePredictionsMain(  ) throws Exception {
		readPuzzleFeatures();
		readPerformanceHistory();
	}
	
	public void readPuzzleFeatures() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/data/puzzleAvgs.csv")));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.contains("index")) {
				continue;
			}
			String[] row = line.split(",");
			if (row.length > 1) {
				PathwayPuzzle puzzle = new PathwayPuzzle(line);
				puzzleFeaturesMap.put(row[2], puzzle);
			}
		}
		reader.close();
	}
	
	public void readPerformanceHistory() throws IOException {
		String[] structures = {"C", "CbCe", "CbTe", "T", "TbCe", "TbCObTee", "TbCOe", "TbObCee", "TbObTee", "TbOe"};
		
		for (String struct: structures) {
			BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/data/clean_data/userPuzzleHistory" + struct + ".csv")));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains("index")) {
					continue;
				}
				String[] row = line.split(",");
				if (row.length > 1) {
					String puzzleName = row[2];
					String puzzleStructure = puzzleFeaturesMap.get(puzzleName).getStructure();
					if (puzzleStructure.equals(struct) || puzzleStructure.equals("CbTe/TbCe")) {

						PathwayUser user = new PathwayUser(line);
						HashMap<String, PathwayUser> puzzle_historyMap = new HashMap<String, PathwayUser>();
						if (user_puzzle_historyMap.containsKey(row[1])){
							puzzle_historyMap = user_puzzle_historyMap.get(row[1]);
						}
						puzzle_historyMap.put(row[2], user);
						user_puzzle_historyMap.put(row[1], puzzle_historyMap);
					}
				}
			}
			reader.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		PuzzlePredictionsMain predictionsReq  = new PuzzlePredictionsMain();
		
		File directory = new File("src/main/data/pathwaysByUsers");
		
		BufferedWriter writerPred = new BufferedWriter(new FileWriter(new File("src/main/data/" + args[0] + ".csv")));

		writerPred.write("user,puzzle,model,cogLoad,predicted\n");

		for (File user: directory.listFiles()) {
			if (user.getName().startsWith(".")) {
				continue;
			}
			ArrayList<String> completed = new ArrayList<String>();
			String lastModel = "";
			float lastPred = -10f;
			int lastCogL = -10;
			float last_lastPred = -10f;
			int last_lastCogL = -10;
			float third_lastPred = -10f;
			int third_lastCogL = -10;

			System.out.println(user.getName().substring(0,user.getName().length()-4 ) );
			String userName = user.getName().substring(0,user.getName().length()-4 );

			BufferedReader reader = new BufferedReader(new FileReader(new File(directory + "/" + user.getName())));
//			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/data/nextPuzzlePredicted/" + user.getName()))); 	// run python/combineFiles.py to get allPuzPred.csv from individual files

			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains("puzzle")) {
					continue;
				}
				String[] values = line.split(",");
				completed.add("sequential-c.lgp");
				completed.add("sequential-d.lgp");
				completed.add("sequential-g.lgp");
				
				String puzzleNameToPredict = values[0];
				PathwayPuzzle puzToPredict = predictionsReq.puzzleFeaturesMap.get(puzzleNameToPredict);
				writerPred.write(userName + "," + values[0] + "," + values[1] + "," + values[2] + "," + values[3] + ",");
				
				HashMap<String, Float> puzzle_prediction_map = new HashMap<>();
				HashMap<String, String> puzzle_model_map = new HashMap<>();
				for (String puzzleName: predictionsReq.puzzleFeaturesMap.keySet()) {
					if (completed.contains(puzzleName)) {
						continue;
					}
					PathwayPuzzle puz = predictionsReq.puzzleFeaturesMap.get(puzzleName);

					// we want to predict for all puzzles in the same pathway and compare with the puzzle user did
					if (puz.getPathwayName().equals(puzToPredict.getPathwayName()) ) {
						PathwayUser u = (predictionsReq.user_puzzle_historyMap.get(userName)).get(puzzleNameToPredict);
						
						float prediction = new PredictionCalculation().getPrediction(u, puz);
						puzzle_prediction_map.put(puzzleName, prediction);
						puzzle_model_map.put(puzzleName, puz.getStructure());
					}
				}
				if (Integer.parseInt(values[2]) < 5) {
					completed.add(puzzleNameToPredict);
				}
				
				HashMap<String, Float> sortedByValue = puzzle_prediction_map
											.entrySet()
											.stream()
											.sorted(Entry.comparingByValue())
											.collect(
													Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
													LinkedHashMap::new));
				Policy maxEfficiencyPolicy;
				if (args[0].equals("baseline_pred")) {
					maxEfficiencyPolicy = new MaxLE_Baseline_pred(sortedByValue, lastPred, lastCogL);
				} else if (args[0].equals("baseline_auc")){
					maxEfficiencyPolicy = new MaxLE_Baseline_auc(sortedByValue, lastPred, lastCogL);
				} else if (args[0].equals("modelCompare_sameOrNew")){
					maxEfficiencyPolicy = new MaxLE_ModelComp_sameOrNew_auc(sortedByValue, lastPred, lastCogL, lastModel, puzzle_model_map);
				} else if (args[0].equals("modelCompare_linearEq")){
					maxEfficiencyPolicy = new MaxLE_ModelComp_linearEq_auc(sortedByValue, lastPred, lastCogL, lastModel, puzzle_model_map);
				} else if (args[0].equals("noise_sameOrNew")){
					boolean isNoise = false;
					if (last_lastCogL != -10){
						if( ((last_lastCogL - lastCogL) * (last_lastPred - lastPred)) < 0) {
							if (third_lastCogL == -10 || ((third_lastCogL-last_lastCogL) * (third_lastPred-last_lastPred)) >= 0) {
								isNoise = true;
							}
						}
					}
					maxEfficiencyPolicy = new MaxLE_Noise_sameOrNew_auc(sortedByValue, lastPred, lastCogL, isNoise);
				} else if (args[0].equals("noise_linearEq")){
					boolean isNoise = false;
					if (last_lastCogL != -10){
						if( ((last_lastCogL - lastCogL) * (last_lastPred - lastPred)) < 0) {
							if (third_lastCogL == -10 || ((third_lastCogL-last_lastCogL) * (third_lastPred-last_lastPred)) >= 0) {
								isNoise = true;
							} 
						}
					}
					maxEfficiencyPolicy = new MaxLE_Noise_linearEq_auc(sortedByValue, lastPred, lastCogL, puzzle_model_map, isNoise);
				} else if (args[0].equals("modelAndNoise_linearEq")){
					boolean isNoise = false;
					if (last_lastCogL != -10){
						if( ((last_lastCogL - lastCogL) * (last_lastPred - lastPred)) < 0) {
							if (third_lastCogL == -10 || ((third_lastCogL-last_lastCogL) * (third_lastPred-last_lastPred)) >= 0) {
								isNoise = true;
							} 
						}
					}
					maxEfficiencyPolicy = new MaxLE_ModelAndNoise_linearEq_auc(sortedByValue, lastPred, lastCogL, lastModel, puzzle_model_map, isNoise);
				} else {
					maxEfficiencyPolicy = new MaxLearningEfficiencyPolicy(sortedByValue, lastPred, lastCogL);
				}
				
				ArrayList<Float> prefPredSet = maxEfficiencyPolicy.getSuitablePredictions();
				
				if (prefPredSet.size() > 0) {
					writerPred.write(",1stChoice");
				}else {
					prefPredSet = maxEfficiencyPolicy.getSecondChoicePred();
					if (prefPredSet.size() > 0) {
						writerPred.write(",2ndChoice");
					}
					else {
						prefPredSet = maxEfficiencyPolicy.getThirdChoicePred();
						if (prefPredSet.size() > 0) {
							writerPred.write(",3rdChoice");
						}else {
							prefPredSet = maxEfficiencyPolicy.getUndesiredChoicePred();
							if (prefPredSet.size() > 0) {
								writerPred.write(",undesired");
							}else {
								writerPred.write(",");
							}
						}
					}
				}
//				HashMap<Float, Integer> pred_cogL = maxEfficiencyPolicy.getExpectedCogLs(prefPredSet);
				
				int count = 0;
				for (Float pred: prefPredSet) {
					writerPred.write("," + pred );
					count+=1;
				}
				while (count < 9) {
					writerPred.write( ",");
					count++;
				}
				
				for (String puzzle: sortedByValue.keySet()) {
					writerPred.write("," + puzzle + "," + sortedByValue.get(puzzle));
				}
				writerPred.write( "\n");
				
				lastModel = values[1];
				third_lastPred = last_lastPred;
				third_lastCogL = last_lastCogL;
				last_lastPred = lastPred;
				last_lastCogL = lastCogL;
				lastPred = Float.parseFloat( values[3] );
				lastCogL = Integer.parseInt( values[2] );
			}
			reader.close();			
		}
		writerPred.close();
	}
}
