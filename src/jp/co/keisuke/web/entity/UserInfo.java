package jp.co.keisuke.web.entity;

import jp.co.keisuke.web.util.ParamUtil;

public class UserInfo {

	private Integer id;
	private String loginId;
	private String userName;
	private String pass;
	private Integer ageId;
	private String ageStr;

	public UserInfo() {}

	public UserInfo(Integer id, String loginId, String userName,String pass, Integer ageId) {
		this.id = id; this.loginId = loginId; this.userName = userName; this.pass = pass; this.ageId = ageId;
	}

	public UserInfo(Integer id, String loginId, String userName,String pass, Integer ageId,String ageStr) {
		this(id,loginId,userName,pass,ageId); this.ageStr = ageStr;
	}

	//get

	public Integer getId() {
		return id;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return pass;
	}

	public Integer getAgeId() {
		return ageId;
	}

	public String getAgeStr() {
		return ageStr;
	}

	//set

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setAgeId(Integer ageId) {
		this.ageId = ageId;
	}

	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}

	//elseMethod
    public boolean isEmptyCondition() {
        return id == null && ParamUtil.isNullOrEmpty(userName);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageId == null) ? 0 : ageId.hashCode());
		result = prime * result + ((ageStr == null) ? 0 : ageStr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (ageId == null) {
			if (other.ageId != null)
				return false;
		} else if (!ageId.equals(other.ageId))
			return false;
		if (ageStr == null) {
			if (other.ageStr != null)
				return false;
		} else if (!ageStr.equals(other.ageStr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}



}
