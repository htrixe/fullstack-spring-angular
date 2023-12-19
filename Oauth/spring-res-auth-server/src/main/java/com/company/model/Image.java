package com.company.model;

public class Image {

	private String imgId;
	private String imgName;

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override
	public String toString() {
		return "Image [imgId=" + imgId + ", imgName=" + imgName + "]";
	}

}