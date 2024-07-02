package com.kh.sns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Value("${admin.name}")
	private String name;
	
	@RequestMapping("login")
	public String login(HttpSession session, String nick) {
		//로그인할때 정보를 받아서 세션에 저장하고 chat창으로 보냄
		session.setAttribute("nick", nick);
		return "chat";
	}
	
	@RequestMapping("nametest")
	public String nametest() { 
		//로그인할때 정보를 받아서 세션에 저장하고 chat창으로 보냄
		System.out.println(name);
		log.info("{}",name);
		System.out.println("????----------------------------");
		return "redirect:/";
	}

	@RequestMapping("/naver-login")
	public String naverLoginCallback(HttpServletRequest request) {
		
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		try {
			String redirectURI = URLEncoder.encode("http://localhost:8899/etc/naver-login", "UTF-8");
			String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
		
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
			
			System.out.println(apiURL);
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			//HTTP요청에 대한 응답코드 확인
			int responseCode = con.getResponseCode();
			
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			//응답데이터를 읽어온다.
			String inputLine;
			StringBuffer res = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			
			if (responseCode == 200) {
				//정상적으로 정보를 받아왔을 때 result에 정보를 저장
				String result = res.toString();
//				System.out.println(result);
				
				JsonObject totalObj = JsonParser.parseString(result).getAsJsonObject();
//				System.out.println(totalObj.get("access_token"));
				
				String token = totalObj.get("access_token").getAsString(); //정보접근을 위한 토큰
				String header = "Bearer " + token;
				
				apiURL = "https://openapi.naver.com/v1/nid/me";
				Map<String, String> requestHeaders = new HashMap<String, String>();
				requestHeaders.put("Authorization", header);
				
				String responseBody = get(apiURL, requestHeaders);
				
				JsonObject memberInfo = JsonParser.parseString(responseBody).getAsJsonObject();
				JsonObject resObj = memberInfo.getAsJsonObject("response");
				
				System.out.println(resObj);
				//받아온 email과 데이터베이스의 email을 비교하여 가입유무 확인 후
				//가입되어있다면 로그인, 아니라면 회원가입창으로 정보를 가지고 이동
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "login";
		
	}
	
	//API에 GET요청 보내고 응답을 받아오는 메서드
	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection conn = connect(apiUrl);
		
		try {
			conn.setRequestMethod("GET");
			
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				conn.setRequestProperty(header.getKey(), header.getValue());
			}
			
			int responseCode = conn.getResponseCode();
			if(responseCode == 200) {
				return readBody(conn.getInputStream());
			} else {
				return readBody(conn.getErrorStream());
			}
			
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패. : " + apiUrl, e);
		} finally {
			conn.disconnect();
		}
	}
	
	//API에 연결하기위한 HttpURLConnection객체를 생성하고 반환하는 메서드
	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("연결이 실패하였습니다. : " + apiUrl, e);
		} 
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);
		
		try (BufferedReader br = new BufferedReader(streamReader)){
			StringBuilder responseBody = new StringBuilder();
			
			String line;
			while((line = br.readLine()) != null) {
				responseBody.append(line);
			}
			
			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패하였습니다.", e);
		}
		
	}
}
