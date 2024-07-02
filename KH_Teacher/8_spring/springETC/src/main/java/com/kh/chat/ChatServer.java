package com.kh.chat;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;


//spring의 컴포넌트로 등록
@Slf4j
@Component 
public class ChatServer extends TextWebSocketHandler{
	
	private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<String, WebSocketSession>();

	//클라이언트가 연결을 맺을 때 호출되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		log.info("{} 연결됨...", nick);
		
		userSessions.put(nick, session);
	}

	//클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//내 세션에서 닉네임 가져옴
		String nick = (String)session.getAttributes().get("nick");
		//메세지 payload를 json객체로 파싱
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		
		log.info("message : {}", obj.get("message").getAsString());
		log.info("target : {}", obj.get("target").getAsString());
		
		MsgVo vo = new MsgVo();
		vo.setMsg(obj.get("message").getAsString());
		vo.setNick(nick);
		vo.setTime(new Date().toLocaleString());
		
		//다른 사용자에게 메세지 전송
		sendMessageUser(obj.get("target").getAsString(), vo);
		
	}
	
	//특정 사용자에게 메세지를 전송하는 메소드
	private void sendMessageUser(String targetNick, MsgVo msgVo) {
		//target의 세션을 세션목록으로부터 가져옴
		WebSocketSession targetSession = userSessions.get(targetNick);
		
		//현재 사용자의 세션을 세션목록으로부터 가져옴
		WebSocketSession mySession = userSessions.get(msgVo.getNick());
		
		//target의 세션이 유효한지 검사
		if(targetSession != null && targetSession.isOpen()) {
			
			String str = new Gson().toJson(msgVo);
			//웹소켓 텍스트 전송규격 메세지로 변환
			TextMessage msg = new TextMessage(str);
			
			try {
				mySession.sendMessage(msg);
				targetSession.sendMessage(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//클라이언트가 연결을 끊을 때 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		
		log.info("{}연결 끊김...", nick);
		userSessions.remove(nick);
	}

}
