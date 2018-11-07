package main;

import java.util.ArrayList;
import java.util.HashMap;

public interface Policy {
	
	public ArrayList<String> choosePuzzleSet();
	
	public ArrayList<Float> getSuitablePredictions();
	
	public ArrayList<Float> getSecondChoicePred();	
	
	public ArrayList<Float> getThirdChoicePred();
	
	public ArrayList<Float> getUndesiredChoicePred();
}
