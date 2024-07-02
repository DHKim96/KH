package test_0214_03;

import java.net.ServerSocket;
import java.net.Socket;

public class Test01 {
	public static void main(String[] args){
		int port = 3000;
		String serverIP = "192.168.20.34";
		try {
			Socket socket = new Socket(serverIP, port);
		}
		
		int port = 3000;
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			Socket client = server.accept();
			while(true) {
				
			}
		}
	}
}
