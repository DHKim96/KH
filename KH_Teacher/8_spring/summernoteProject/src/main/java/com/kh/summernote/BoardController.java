package com.kh.summernote;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
public class BoardController {

	
	//게시글 작성하기(화면)
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	//게시글 추가하기
	@PostMapping("write")
	public String insertBoard(Board b) {
		System.out.println(b);
		return "write";
	}
	
	//ajax로 들어오는 파일 업로드 요청 처리
	//파일목록을 저장한 후 저장된 파일명목록을 반환
	@PostMapping("upload")
	@ResponseBody
	public String upload(List<MultipartFile> fileList, HttpSession session) {
		System.out.println(fileList);
		
		List<String> changeNameList = new ArrayList<String>();
		
		for (MultipartFile f : fileList) {
			String changeName = saveFile(f, session, "/resources/img/");
			
			changeNameList.add("/resources/img/" + changeName);
		}
		
		return new Gson().toJson(changeNameList);
	}
	
	//실제 넘어온 파일의 이름을 변경해서 서버에 저장하는 메소드
	public String saveFile(MultipartFile upfile, HttpSession session, String path) {
		//파일명 수정 후 서버에 업로드하기("imgFile.jpg => 202404231004305488.jpg")
		String originName = upfile.getOriginalFilename();
		
		//년월일시분초 
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//5자리 랜덤값
		int ranNum = (int)(Math.random() * 90000) + 10000;
		
		//확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//수정된 첨부파일명
		String changeName = currentTime + ranNum + ext;
		
		//첨부파일을 저장할 폴더의 물리적 경로(session)
		String savePath = session.getServletContext().getRealPath(path);
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
}
