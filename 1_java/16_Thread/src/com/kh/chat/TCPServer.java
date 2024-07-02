package com.kh.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		int port = 3000;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("서버 연결준비 완료...");
			
			Socket socket = serverSocket.accept();	
			System.out.println(socket.getInetAddress().getHostAddress() + "에서 연결함...");
			
			// 클라이언트로부터 메세지를 받는 쓰레드
			Thread receiveTask = new Thread(new ServerReceive(socket));
			receiveTask.start();
			// 클라이언트로부터 메세지를 보내는 쓰레드
			Thread sendTask = new Thread(new ServerSend(socket));
			sendTask.start();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
