package com.ohouse.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy; 

public class MyFileRenamePolicy implements FileRenamePolicy{
	
	/**
	 * 원본 파일 전달받아서 파일명 수정 작업 후 수정된 파일 리턴
	 */
	@Override
	public File rename(File originFile) {
		String originName = originFile.getName();
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int ranNum = (int)(Math.random()*90000 + 10000);
		
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		File changeFile = new File(originFile.getParent(), changeName);
		
		return changeFile;
	}

}
