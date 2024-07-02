package com.kh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	//서버용 프로그램
		public static void main(String[] arge) {
			int port = 3000;
			
			try {
				
				ServerSocket serverSocket = new ServerSocket(port);
				System.out.println("서버 연결준비 완료....");
				
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress().getHostAddress() + "에서 연결함...");
				
				//클라이언트로부터 메세지를 받는 쓰레드
				ServerReceive receive = new ServerReceive(socket);
				Thread receiveTask = new Thread(receive);
				receiveTask.start();
				
				//클라이언트로부터 메세지를 보내는 쓰레드
				ServerSend send = new ServerSend(socket);
				Thread sendTask = new Thread(send);
				sendTask.start();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
