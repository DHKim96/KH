package com.ohouse.common.model.vo;

import java.sql.Date;

public class Scrap {
	private int scrapId;
	private int scrapType;
	private int scrapMembersNo;
	private int scrapBoardId;
	private int scrapMediaId;
	private int scrapProductId;
	private Date scrapCreateTime;
	private String scrapStatus;

	public Scrap() {}

	public Scrap(int scrapId, int scrapType, int scrapMembersNo, int scrapBoardId, int scrapMediaId, int scrapProductId,
			Date scrapCreateTime, String scrapStatus) {
		super();
		this.scrapId = scrapId;
		this.scrapType = scrapType;
		this.scrapMembersNo = scrapMembersNo;
		this.scrapBoardId = scrapBoardId;
		this.scrapMediaId = scrapMediaId;
		this.scrapProductId = scrapProductId;
		this.scrapCreateTime = scrapCreateTime;
		this.scrapStatus = scrapStatus;
	}

	public int getScrapId() {
		return scrapId;
	}

	public void setScrapId(int scrapId) {
		this.scrapId = scrapId;
	}

	public int getScrapType() {
		return scrapType;
	}

	public void setScrapType(int scrapType) {
		this.scrapType = scrapType;
	}

	public int getScrapMembersNo() {
		return scrapMembersNo;
	}

	public void setScrapMembersNo(int scrapMembersNo) {
		this.scrapMembersNo = scrapMembersNo;
	}

	public int getScrapBoardId() {
		return scrapBoardId;
	}

	public void setScrapBoardId(int scrapBoardId) {
		this.scrapBoardId = scrapBoardId;
	}

	public int getScrapMediaId() {
		return scrapMediaId;
	}

	public void setScrapMediaId(int scrapMediaId) {
		this.scrapMediaId = scrapMediaId;
	}

	public int getScrapProductId() {
		return scrapProductId;
	}

	public void setScrapProductId(int scrapProductId) {
		this.scrapProductId = scrapProductId;
	}

	public Date getScrapCreateTime() {
		return scrapCreateTime;
	}

	public void setScrapCreateTime(Date scrapCreateTime) {
		this.scrapCreateTime = scrapCreateTime;
	}

	public String getScrapStatus() {
		return scrapStatus;
	}

	public void setScrapStatus(String scrapStatus) {
		this.scrapStatus = scrapStatus;
	}

	@Override
	public String toString() {
		return "Scrap [scrapId=" + scrapId + ", scrapType=" + scrapType + ", scrapMembersNo=" + scrapMembersNo
				+ ", scrapBoardId=" + scrapBoardId + ", scrapMediaId=" + scrapMediaId + ", scrapProductId="
				+ scrapProductId + ", scrapCreateTime=" + scrapCreateTime + ", scrapStatus=" + scrapStatus + "]";
	}
	
	
}