package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	public static final String SERVICE_KEY = "8h1yVur%2F0C1jzB%2BQnTVFLYlJk9Gfckktb8MFl25lzXaujB8wU9qgmg5abLreCLJnE2J%2FOK4DW5bqq0p4FPIEqw%3D%3D";

	@ResponseBody
	@RequestMapping(value="air", produces="application/json; charset=UTF-8")
	public String getAirInfo(String location) throws IOException {
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); //요청시 전달값에 한글이 있으면 인코딩 작업을 해줘야한다.
		
		URL reqeustURL = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)reqeustURL.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseText = "";
		String line;
		while((line = br.readLine()) != null ) {
			responseText += line;
		}
		
		br.close();
		urlConnection.disconnect();
		
		return responseText;
	}
}

