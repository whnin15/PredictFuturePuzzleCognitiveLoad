package main;

import java.util.ArrayList;
import java.util.HashMap;

public interface Policy {
	ArrayList<Float> predToSuggest = new ArrayList<>();
	ArrayList<Float> secondChoicePred = new ArrayList<>();
	ArrayList<Float> thirdChoicePred = new ArrayList<>();
	ArrayList<Float> undesiredChoicePred = new ArrayList<>();
	HashMap<Float, Integer> pred_cogLMap = new HashMap<>();
	
	public ArrayList<String> choosePuzzleSet();
	
	public ArrayList<Float> getSuitablePredictions();
	
	public ArrayList<Float> getSecondChoicePred();	
	
	public ArrayList<Float> getThirdChoicePred();
	
	public ArrayList<Float> getUndesiredChoicePred();
}
