package com.kh.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 3000);
			
			// 서버로부터 메세지를 받는 쓰레드
			new Thread(new ServerReceive(socket)).start();
			// 서버에 메세지를 보내는 쓰레드
			new Thread(new ServerSend(socket)).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
