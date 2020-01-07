package jp.co.keisuke.web.entity;

import jp.co.keisuke.web.util.ParamUtil;

public class Review {

	private Integer reviewId;
	private Integer id;
	private String userName;
	private String softStr;
	private String modelStr;
	private String contents;
	private String dateTime;

	public Review() {}

	public Review(Integer reviewId ,Integer id, String userName, String softStr, String modelStr, String contents, String dateTime) {
		this.reviewId = reviewId;
		this.id = id;
		this.userName = userName;
		this.softStr = softStr;
		this.modelStr = modelStr;
		this.contents = contents;
		this.dateTime = dateTime;
	}

	public Integer getReviewId() {
		return reviewId;
	}


	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSoftStr() {
		return softStr;
	}


	public void setSoftStr(String softStr) {
		this.softStr = softStr;
	}


	public String getModelStr() {
		return modelStr;
	}


	public void setModelStr(String modelStr) {
		this.modelStr = modelStr;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	//elseMethod
    public boolean softNameisEmptyCondition() {
        return id == null && ParamUtil.isNullOrEmpty(softStr);
    }

}
