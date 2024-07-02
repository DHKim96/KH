package com.ohouse.members.model.vo;

import java.sql.Date;

public class Members {
	private int membersNo;
	private String membersId;
	private String membersPwd;
	private String membersName;
	private Date membersBirth;
	private String membersPhone;
	private String membersEmail;
	private String gender;
	private String membersType;
	private String companyName;
	private String representative;
	private String companyPlace;
	private String companyPhone;
	private String companyEmail;
	private String regNum;
	private Date membersEnrollTime;
	private Date membersModifyTime;
	private String membersStatus;
	private String profile;
	
	public Members() {
		super();
	}

	

	public Members(int membersNo, String membersId, String membersPwd, String membersName, Date membersBirth,
			String membersPhone, String membersEmail, String gender, String membersType, String companyName,
			String representative, String companyPlace, String companyPhone, String companyEmail, String regNum,
			Date membersEnrollTime, Date membersModifyTime, String membersStatus, String profile) {
		super();
		this.membersNo = membersNo;
		this.membersId = membersId;
		this.membersPwd = membersPwd;
		this.membersName = membersName;
		this.membersBirth = membersBirth;
		this.membersPhone = membersPhone;
		this.membersEmail = membersEmail;
		this.gender = gender;
		this.membersType = membersType;
		this.companyName = companyName;
		this.representative = representative;
		this.companyPlace = companyPlace;
		this.companyPhone = companyPhone;
		this.companyEmail = companyEmail;
		this.regNum = regNum;
		this.membersEnrollTime = membersEnrollTime;
		this.membersModifyTime = membersModifyTime;
		this.membersStatus = membersStatus;
		this.profile = profile;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	public int getMembersNo() {
		return membersNo;
	}

	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}

	public String getMembersId() {
		return membersId;
	}

	public void setMembersId(String membersId) {
		this.membersId = membersId;
	}

	public String getMembersPwd() {
		return membersPwd;
	}

	public void setMembersPwd(String membersPwd) {
		this.membersPwd = membersPwd;
	}

	public String getMembersName() {
		return membersName;
	}

	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}

	public Date getMembersBirth() {
		return membersBirth;
	}

	public void setMembersBirth(Date membersBirth) {
		this.membersBirth = membersBirth;
	}

	public String getMembersPhone() {
		return membersPhone;
	}

	public void setMembersPhone(String membersPhone) {
		this.membersPhone = membersPhone;
	}

	public String getMembersEmail() {
		return membersEmail;
	}

	public void setMembersEmail(String membersEmail) {
		this.membersEmail = membersEmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMembersType() {
		return membersType;
	}

	public void setMembersType(String membersType) {
		this.membersType = membersType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getCompanyPlace() {
		return companyPlace;
	}

	public void setCompanyPlace(String companyPlace) {
		this.companyPlace = companyPlace;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public Date getMembersEnrollTime() {
		return membersEnrollTime;
	}

	public void setMembersEnrollTime(Date membersEnrollTime) {
		this.membersEnrollTime = membersEnrollTime;
	}

	public Date getMembersModifyTime() {
		return membersModifyTime;
	}

	public void setMembersModifyTime(Date membersModifyTime) {
		this.membersModifyTime = membersModifyTime;
	}

	public String getMembersStatus() {
		return membersStatus;
	}

	public void setMembersStatus(String membersStatus) {
		this.membersStatus = membersStatus;
	}

	@Override
	public String toString() {
		return "Members [membersNo=" + membersNo + ", membersId=" + membersId + ", membersPwd=" + membersPwd
				+ ", membersName=" + membersName + ", membersBirth=" + membersBirth + ", membersPhone=" + membersPhone
				+ ", membersEmail=" + membersEmail + ", gender=" + gender + ", membersType=" + membersType
				+ ", companyName=" + companyName + ", representative=" + representative + ", companyPlace="
				+ companyPlace + ", companyPhone=" + companyPhone + ", companyEmail=" + companyEmail + ", regNum="
				+ regNum + ", membersEnrollTime=" + membersEnrollTime + ", membersModifyTime=" + membersModifyTime
				+ ", membersStatus=" + membersStatus + ", profile=" + profile + "]";
	}
}
