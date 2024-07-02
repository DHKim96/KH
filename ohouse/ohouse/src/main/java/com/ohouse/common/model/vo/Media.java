package com.ohouse.common.model.vo;

import java.sql.Date;

public class Media {
	private int mediaId;
	private int mediaBoardId;
	private int mediaMembersId;
	private int mediaType;
	private String originName;
	private String changeName;
	private String filePath;
	private int fileLevel;
	private Date uploadDate;
	private String mediaStatus;
	private int mediaProductId;
	
	public Media() {}

	




	public Media(int mediaId, int mediaBoardId, int mediaMembersId, int mediaType, String originName, String changeName,
			String filePath, int fileLevel, Date uploadDate, String mediaStatus, int mediaProductId) {
		super();
		this.mediaId = mediaId;
		this.mediaBoardId = mediaBoardId;
		this.mediaMembersId = mediaMembersId;
		this.mediaType = mediaType;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.uploadDate = uploadDate;
		this.mediaStatus = mediaStatus;
		this.mediaProductId = mediaProductId;
	}


	public int getMediaProductId() {
		return mediaProductId;
	}
	
	
	
	public void setMediaProductId(int mediaProductId) {
		this.mediaProductId = mediaProductId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public int getMediaBoardId() {
		return mediaBoardId;
	}

	public void setMediaBoardId(int mediaBoardId) {
		this.mediaBoardId = mediaBoardId;
	}

	public int getMediaMembersId() {
		return mediaMembersId;
	}

	public void setMediaMembersId(int mediaMembersId) {
		this.mediaMembersId = mediaMembersId;
	}

	public int getMediaType() {
		return mediaType;
	}

	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getMediaStatus() {
		return mediaStatus;
	}

	public void setMediaStatus(String mediaStatus) {
		this.mediaStatus = mediaStatus;
	}


	@Override
	public String toString() {
		return "Media [mediaId=" + mediaId + ", mediaBoardId=" + mediaBoardId + ", mediaMembersId=" + mediaMembersId
				+ ", mediaType=" + mediaType + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", fileLevel=" + fileLevel + ", uploadDate=" + uploadDate
				+ ", mediaStatus=" + mediaStatus + ", mediaProductId=" + mediaProductId + "]";
	}

	
	
	
	
}
