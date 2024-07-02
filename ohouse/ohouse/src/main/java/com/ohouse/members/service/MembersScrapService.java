package com.ohouse.members.service;

import java.util.ArrayList;

import com.ohouse.common.model.vo.Media;
import com.ohouse.members.model.vo.Members;

public interface MembersScrapService {
	
	public int MemberScrapCount(int membersNo, int scrapType);
	
	public ArrayList<Media> MembersScrapList(int mNo,int scrapType);

}
