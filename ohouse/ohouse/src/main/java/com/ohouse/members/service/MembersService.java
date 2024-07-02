package com.ohouse.members.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.ohouse.common.model.vo.Media;
import com.ohouse.members.model.vo.Members;

public interface MembersService {
	public int insertMembers(Members m);
	
	public Members loginMembers(Members m);
	
	public int deleteMembers(Members m);
	
	public int idCheck(String checkId);
	
	public Members updatePwdMembers(HashMap<String, String> map);
	
	public int MembersScrapCount(int mNo);
	
	public int MemberCommunityCount(int mNo);
	
	public ArrayList<Media> MemberCommunityList(int mNo);

	public Members updateMembers(Media media, Members m);

}
