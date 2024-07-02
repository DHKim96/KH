package com.kh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceive implements Runnable{
	private Socket socket;
	
	public ServerReceive(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//메세지를 받는 것 
		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			
			while(true) {
				String message = br.readLine();
				System.out.println("클라이언트로부터 전달된 메세지 : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
