package main;

import java.util.ArrayList;

import main.PathwayPuzzle;
import main.PathwayUser;
import models.C;
import models.CbCe;
import models.CbTe;
import models.T;
import models.TbCObTee;
import models.TbCOe;
import models.TbCe;
import models.TbObCee;
import models.TbObTee;
import models.TbOe;

/**
 * @author Wint Hnin
 */
public class PredictionCalculation {
		public float getPrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			String structure = puzzle.getStructure();
			float predicted = 0;

			//TODO - how do we choose the predicted among different structures
			if( structure.equals( "C" ) ) {
				predicted = getCPrediction( user, puzzle );
			} else if( structure.equals( "CbCe" ) ) {
				predicted = getCbCePrediction( user, puzzle );
			} else if( structure.equals( "CbTe" ) ) {
				predicted = getCbTePrediction( user, puzzle );
			} else if( structure.equals( "T" ) ) {
					predicted = getTPrediction( user, puzzle );
			} else if( structure.equals( "TbCe" ) ) {
					predicted = getTbCePrediction( user, puzzle );
			} else if( structure.equals( "TbCObTee" ) ) {
				predicted = getTbCObTeePrediction( user, puzzle );
			} else if( structure.equals( "TbCOe" ) ) {
				predicted = getTbCOePrediction( user, puzzle );
			} else if( structure.equals( "TbObCee" ) ) {
				predicted = getTbObCeePrediction( user, puzzle );
			} else if( structure.equals( "TbObTee" ) ) {
				predicted = getTbObTeePrediction( user, puzzle );
			} else if( structure.equals( "TbOe" ) ) {
				predicted = getTbOePrediction( user, puzzle );
			} else if( structure.equals( "CbTe/TbCe" ) ) {
				predicted += getCbTePrediction( user, puzzle );
				predicted += getTbCePrediction( user, puzzle );
				predicted = predicted / (float)2;
			}
			return predicted;
		}

		private float getCPrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new C().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getCbCePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new CbCe().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getCbTePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new CbTe().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTPrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new T().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTbCePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new TbCe().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTbCObTeePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new TbCObTee().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTbCOePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new TbCOe().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTbObCeePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new TbObCee().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTbObTeePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new TbObTee().getProb( puzzle, user ) - 4;
			return prediction;
		}

		private float getTbOePrediction( PathwayUser user, PathwayPuzzle puzzle ) {
			float prediction = new TbOe().getProb( puzzle, user ) - 4;
			return prediction;
		}

	}