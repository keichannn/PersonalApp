package jp.co.keisuke.web.entity;

import jp.co.keisuke.web.util.ParamUtil;

public class SoftInfo {

	private Integer softId;
	private Integer id;
	private String softName;
	private Integer genreId;
	private String genreStr;
	private Integer modelId;
	private String modelStr;
	private String releaseDate;
	private String price;
	private String url;

	public SoftInfo() {}

	public SoftInfo(Integer id, String softName, Integer genreId, String genreStr,
			Integer modelId, String modelStr, String releaseDate, String price, String url) {
		this.id = id;
		this.softName = softName;
		this.genreId = genreId;
		this.genreStr = genreStr;
		this.modelId = modelId;
		this.modelStr = modelStr;
		this.releaseDate = releaseDate;
		this.price = price;
		this.url = url;
	}

	public SoftInfo(Integer softId, Integer id, String softName, Integer genreId, String genreStr,
			Integer modelId, String modelStr, String releaseDate, String price, String url) {
		this(id,softName,genreId,genreStr,modelId,modelStr,releaseDate,price,url);
		this.softId = softId;
	}

	public Integer getSoftId() {
		return softId;
	}

	public void setSoftId(Integer softId) {
		this.softId = softId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSoftName() {
		return softName;
	}

	public void setSoftName(String softName) {
		this.softName = softName;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreStr() {
		return genreStr;
	}

	public void setGenreStr(String genreStr) {
		this.genreStr = genreStr;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//elseMethod
    public boolean softNameisEmptyCondition() {
        return id == null && ParamUtil.isNullOrEmpty(softName);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((genreStr == null) ? 0 : genreStr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
		result = prime * result + ((modelStr == null) ? 0 : modelStr.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((softName == null) ? 0 : softName.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		SoftInfo other = (SoftInfo) obj;

		if (genreId == null) {

			if (other.genreId != null)
				return false;

		} else if (!genreId.equals(other.genreId))
			return false;

		if (genreStr == null) {

			if (other.genreStr != null)
				return false;

		} else if (!genreStr.equals(other.genreStr))
			return false;

		if (id == null) {

			if (other.id != null)
				return false;

		} else if (!id.equals(other.id))
			return false;

		if (modelId == null) {

			if (other.modelId != null)
				return false;

		} else if (!modelId.equals(other.modelId))
			return false;

		if (modelStr == null) {

			if (other.modelStr != null)
				return false;

		} else if (!modelStr.equals(other.modelStr))
			return false;

		if (price == null) {

			if (other.price != null)
				return false;

		} else if (!price.equals(other.price))
			return false;

		if (releaseDate == null) {

			if (other.releaseDate != null)
				return false;

		} else if (!releaseDate.equals(other.releaseDate))
			return false;

		if (softName == null) {

			if (other.softName != null)
				return false;

		} else if (!softName.equals(other.softName))
			return false;

		if (url == null) {

			if (other.url != null)
				return false;

		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}