package com.kh.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	/*
	 * * TCP(Transmission Control Protocol)
	 * 		서버, 클라이언트 간 1:1 소켓 통신
	 * 		데이터를 교환하기에 앞서 서버, 클라이언트 연결 되어야 함.
	 * 		(다만, 서버가 먼저 실행되어 클라이언트의 요청을 기다려야 함)
	 * 		신뢰성 있는 데이터 전달 가능.
	 * * Socket
	 * 		프로세스간 통신을 담당.
	 * 		InputStream / OutputStream 을 가지고 있음.(해당 스트림 통해 입출력 이루어짐)
	 * 		(따라서 문자 입출력을 위해서는 보조 스트림 활용해야 함)
	 * 
	 * * ServerSocket
	 * 		포트와 연결(Bing)되어 외부의 연결 요청을 기다림 => 요청이 들어오면 수락함
	 * 		수락 means 통신할 수 있는 socket 생성
	 */
	
	// 서버용 프로그램
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null ;
		PrintWriter pw = null;
		
		// 1) 포트 번호 지정(서버측에서 몇 번 포트로 통로를 열겠냐라는 의미)
		int port = 3000;
		
		// 2) ServerSocket 객체 생성 시 포트 결합(Bind)
		ServerSocket server = null;
		try {
			server = new ServerSocket(port); 
			
			// 3) 클라이언트로부터 접속 요청이 올 때까지 대기
			System.out.println("클라이언트 요청을 기다리고 있습니다.");
			
			// 4) 연결 요청이 오면 수락 후 클라이언트와 통신 가능한 서버측 소켓객체 생성
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress().getHostAddress() + "가 연결을 요청함..."); 
			
			// 5) 클라이언트와 입출력 기반스트림 생성(바이트 단위 스트림 밖에 안됨)
			// 6) 따라서 보조스트림을 통한 성능 개선 요구됨
			// 입력용 스트림(클라이언트로부터 전달된 값을 한 줄 단위로 읽어들이기 위한 입력용 스트림)
			br = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			// 출력용 스트림(클라이언트에게 값을 한 줄 단위로 출력할 수 있는 출력용 스트림)
		    pw = new PrintWriter( socket.getOutputStream() );
			// PrintWriter
		    // 		: 데이터 출력 시 print(), println() 메소드를 가지고 있는 보조스트림
		    
		    while(true) {
		    	// 7) 스트림을 통해서 읽고 쓰기
		    	String message = br.readLine();
		    	System.out.println("클라이언트로부터 전달받은 메세지 : " + message);
		    	
		    	// 반대로 클라이언트에게 데이터 전달(출력)
		    	System.out.print("클라이언트에게 보낼 내용 : ");
		    	String sendMessage = sc.nextLine();
		    	
		    	pw.println(sendMessage); // 클라이언트한테 출력
		    	pw.flush(); // 현재 스트림에 있는 데이터를 강제로 내보내는 메소드
		    }
		    
		    
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
			try {
				br.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		sc.close();
	}
}
