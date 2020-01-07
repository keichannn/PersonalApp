package jp.co.keisuke.web.servlet;

import java.util.List;

import jp.co.keisuke.web.entity.Age;
import jp.co.keisuke.web.entity.Genre;
import jp.co.keisuke.web.entity.Model;
import jp.co.keisuke.web.entity.Review;
import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.entity.UserInfo;

public class SessionInfo {

    UserInfo loginUser;
    UserInfo registerUser;
    UserInfo prevUpdateUser;
    UserInfo updateUser;

    SoftInfo softInfo;
    SoftInfo registerSoft;
    SoftInfo prevUpdateSoft;
    SoftInfo updateSoft;
    SoftInfo softDelete;

    Review reviewInfo;

    List<Age> ageList;
    List<Genre> genreList;
    List<Model> modelList;
    List<Review> reviewList;

    //get

	public UserInfo getLoginUser() {
        return loginUser;
    }

	public UserInfo getRegisterUser() {
        return registerUser;
    }

    public UserInfo getPrevUpdateUser() {
        return prevUpdateUser;
    }

    public UserInfo getUpdateUser() {
        return updateUser;
    }

    public SoftInfo getSoftInfo() {
		return softInfo;
	}

    public List<Genre> getGenreList() {
        return genreList;
    }

    public List<Age> getAgeList() {
        return ageList;
    }

    public List<Model> getModelList() {
        return modelList;
    }

	public List<Review> getReviewList() {
		return reviewList;
	}

	public SoftInfo getRegisterSoft() {
		return registerSoft;
	}

    public SoftInfo getPrevUpdateSoft() {
		return prevUpdateSoft;
	}

	public SoftInfo getUpdateSoft() {
		return updateSoft;
	}

	public SoftInfo getSoftDelete() {
		return softDelete;
	}

    public Review getReviewInfo() {
		return reviewInfo;
	}


	//set

    public void setLoginUser(UserInfo _loginUser) {
        loginUser = _loginUser;
    }

    public void setRegisterUser(UserInfo _registerUser) {
        registerUser = _registerUser;
    }

    public void setPrevUpdateUser(UserInfo _prevUpdateUser) {
        prevUpdateUser = _prevUpdateUser;
    }

    public void setUpdateUser(UserInfo _updateUser) {
        updateUser = _updateUser;
    }

	public void setSoftInfo(SoftInfo softInfo) {
		this.softInfo = softInfo;
	}

    public void setGenreList(List<Genre> _genreList) {
        genreList = _genreList;
    }

    public void setAgeList(List<Age> _ageList) {
        ageList = _ageList;
    }

    public void setModelList(List<Model> _modelList) {
        modelList = _modelList;
    }

	public void setReviewInfo(Review reviewInfo) {
		this.reviewInfo = reviewInfo;
	}

	public void setRegisterSoft(SoftInfo registerSoft) {
		this.registerSoft = registerSoft;
	}

	public void setPrevUpdateSoft(SoftInfo prevUpdateSoft) {
		this.prevUpdateSoft = prevUpdateSoft;
	}

	public void setUpdateSoft(SoftInfo updateSoft) {
		this.updateSoft = updateSoft;
	}

	public void setSoftDelete(SoftInfo softDelete) {
		this.softDelete = softDelete;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
}
