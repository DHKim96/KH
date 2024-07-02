package com.kh.tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("보낼메세지 입력");
		String msg = sc.nextLine();
		
		InetAddress inet; 
		int port = 4000;
		
		//전송하기위한 UDP소켓 만들어주기
		try (DatagramSocket dsoc = new DatagramSocket()){
			inet = InetAddress.getByName("192.168.30.2");
			//전송할 데이터 생성
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inet, port);
			dsoc.send(dp);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
