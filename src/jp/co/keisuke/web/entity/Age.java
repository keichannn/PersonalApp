package jp.co.keisuke.web.entity;

public class Age {

	private Integer ageId;
	private String ageStr;

	public Age() {}

	public Age(Integer ageId, String ageStr) {
		this.ageId = ageId;
		this.ageStr = ageStr;
	}

	public Integer getAgeId() {
		return ageId;
	}

	public void setAgeId(Integer ageId) {
		this.ageId = ageId;
	}

	public String getAgeStr() {
		return ageStr;
	}

	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}



}
