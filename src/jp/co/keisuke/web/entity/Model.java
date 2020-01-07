package jp.co.keisuke.web.entity;

public class Model {

	private Integer modelId;
	private String modelStr;

	public Model() {}

	public Model(Integer modelId, String modelStr) {

		this.modelId = modelId;
		this.modelStr = modelStr;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelStr() {
		return modelStr;
	}

	public void setModelStr(String modelStr) {
		this.modelStr = modelStr;
	}



}
