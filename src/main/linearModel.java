package main;

import java.util.HashMap;

public class linearModel {
	private HashMap<String, float[]> linearModelMap = new HashMap<>();

	public linearModel() {
		linearModelMap.put("T", new float[]{(float) 0.2605, (float) 0.8507});
		linearModelMap.put("C", new float[]{(float) 2.577, (float) 1.631});
		linearModelMap.put("CbCe", new float[]{(float) -0.2449, (float) 0.8603});
		linearModelMap.put("CbTe", new float[]{(float) 0.9401, (float) 1.2335});
		linearModelMap.put("TbCe", new float[]{(float) -0.1969, (float) 0.8128});
		linearModelMap.put("CbTe/TbCe", new float[]{(float) 1.325, (float) 1.167});
		linearModelMap.put("TbOe", new float[]{(float) 0.03394, (float) 1.07021});
		linearModelMap.put("TbObTee", new float[]{(float) -0.0284, (float) 0.9553});
		linearModelMap.put("TbObCee", new float[]{(float) -0.3333, (float) 0});
		linearModelMap.put("TbCOe", new float[]{(float) -1.667, (float) 0});
		linearModelMap.put("TbCObTee", new float[]{(float) 5, (float) 0});
	}
	
	public float getPredFromLM(String model, int cogL) {
		float[] linearModel = linearModelMap.get(model);
		return ((cogL - linearModel[0]) / linearModel[1]);
	}
}
