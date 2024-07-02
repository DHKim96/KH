package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
	/**
	 * 원본 파일 전달받아서 파일명 수정 작업 후 수정된 파일 리턴
	 */
	@Override
	public File rename(File originFile) { // 원본 파일을 File 객체로 전달받음
		// 원본파일명("sample.png") 추출
		String originName = originFile.getName();
		// 수정파일명("2024040215213200012345.jpg") 파일 업로드 시간(년월일시분초 + 랜덤 5자리 + 확장자명)으로 설정
		
		// 1. 파일 업로드 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2. 5자리 랜덤값
		int ranNum = (int)(Math.random()*90000 + 10000);
		
		// 3. 원본 파일 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		// String객체.lastIndexOf() : 뒤에서부터 인덱스값을 찾아서 '.'의 위치를 반환해주고
		// substring 메소드로 .위치 이하의 문자열 반환
		
		// 4. 모두 하나로
		String changeName = currentTime + ranNum + ext;
		
		File changeFile = new File(originFile.getParent(), changeName);
		// File 객체의 getParent() 메소드 : 해당 파일이 있는 부모 디렉토리의 경로를 반환
		
		return changeFile; 
	}
	
}
