package com.ohouse.community.model.vo;

import java.sql.Date;

public class Reply {
	private String replyId; 
	private	String replyContent;
	private Date replyCreateDate;
	private Date replyModifyDate;
	private String replyBoardId;
	private String replyMembersNo;
	private String replyWriter;
	private String replyStatus;
	
	public Reply(){}
	
	public Reply(String replyId, String replyContent, Date replyCreateDate, Date replyModifyDate, String replyBoardId,
			String replyMembersNo, String replyStatus) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyCreateDate = replyCreateDate;
		this.replyModifyDate = replyModifyDate;
		this.replyBoardId = replyBoardId;
		this.replyMembersNo = replyMembersNo;
		this.replyStatus = replyStatus;
	}
	

	public Reply(String replyId, String replyContent, Date replyCreateDate, Date replyModifyDate, String replyBoardId,
			String replyMembersNo, String replyWriter, String replyStatus) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyCreateDate = replyCreateDate;
		this.replyModifyDate = replyModifyDate;
		this.replyBoardId = replyBoardId;
		this.replyMembersNo = replyMembersNo;
		this.replyWriter = replyWriter;
		this.replyStatus = replyStatus;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyCreateDate() {
		return replyCreateDate;
	}

	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}

	public Date getReplyModifyDate() {
		return replyModifyDate;
	}

	public void setReplyModifyDate(Date replyModifyDate) {
		this.replyModifyDate = replyModifyDate;
	}

	public String getReplyBoardId() {
		return replyBoardId;
	}

	public void setReplyBoardId(String replyBoardId) {
		this.replyBoardId = replyBoardId;
	}

	public String getReplyMembersNo() {
		return replyMembersNo;
	}

	public void setReplyMembersNo(String replyMembersNo) {
		this.replyMembersNo = replyMembersNo;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyCreateDate=" + replyCreateDate
				+ ", replyModifyDate=" + replyModifyDate + ", replyBoardId=" + replyBoardId + ", replyMembersNo="
				+ replyMembersNo + ", replyWriter=" + replyWriter + ", replyStatus=" + replyStatus + "]";
	}

	
}
