package com.wilshire.admin.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PortfolioVO {
	
	private int boardNo;
	private String name;
	private String caption;
	private String location;
	private String client;
	private String scale;
	private String formation;
	private Date start_dt;
	private Date end_dt;
	
	private MultipartFile uploadFile;
	private String imgName;
	private String imgOriginalName;
	private Long imgSize;
	private String imgPath;
	private String imgType;
	private Date created_datetime;
	private Date updated_datetime;
	
	private List<PortfolioVO> listPortfolioVO;
	
	private String imgViewURL;
	private String imgDate;
	private String workType;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public Date getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}

	public Date getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgOriginalName() {
		return imgOriginalName;
	}

	public void setImgOriginalName(String imgOriginalName) {
		this.imgOriginalName = imgOriginalName;
	}

	public Long getImgSize() {
		return imgSize;
	}

	public void setImgSize(Long imgSize) {
		this.imgSize = imgSize;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public Date getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}

	public Date getUpdated_datetime() {
		return updated_datetime;
	}

	public void setUpdated_datetime(Date updated_datetime) {
		this.updated_datetime = updated_datetime;
	}

	public List<PortfolioVO> getListPortfolioVO() {
		return listPortfolioVO;
	}

	public void setListPortfolioVO(List<PortfolioVO> listPortfolioVO) {
		this.listPortfolioVO = listPortfolioVO;
	}
	

	public String getImgViewURL() {
		return imgViewURL;
	}

	public void setImgViewURL(String imgViewURL) {
		this.imgViewURL = imgViewURL;
	}
	

	public String getImgDate() {
		return imgDate;
	}

	public void setImgDate(String imgDate) {
		this.imgDate = imgDate;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	@Override
	public String toString() {
		return "PortfolioVO [boardNo=" + boardNo + ", name=" + name + ", caption=" + caption + ", location=" + location
				+ ", client=" + client + ", scale=" + scale + ", formation=" + formation + ", start_dt=" + start_dt
				+ ", end_dt=" + end_dt + ", uploadFile=" + uploadFile + ", imgName=" + imgName + ", imgOriginalName="
				+ imgOriginalName + ", imgSize=" + imgSize + ", imgPath=" + imgPath + ", imgType=" + imgType
				+ ", created_datetime=" + created_datetime + ", updated_datetime=" + updated_datetime
				+ ", listPortfolioVO=" + listPortfolioVO + ", imgViewURL=" + imgViewURL + ", imgDate=" + imgDate
				+ ", workType=" + workType + "]";
	}

}
