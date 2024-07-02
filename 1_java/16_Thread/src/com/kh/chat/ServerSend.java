package com.kh.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSend implements Runnable{
	private Socket socket;
	
	public ServerSend(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() { // 메세지 보내기
		try(PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
				Scanner sc = new Scanner(System.in)) {
			
			while(true) {
				String message = sc.nextLine();
				writer.println(message);
//				writer.flush(); // 안쓰려면 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
