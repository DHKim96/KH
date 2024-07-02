package com.kh.threadTest;

public class Task1 extends Thread { // 20미만 짝수 출력

	@Override
	public void run() {
		try {
			for(int i = 0 ; i < 20 ; i++) {
				if (i % 2 == 0) {
					System.out.print(i + " ");
				}
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 0.1초간 잠을 잔다(멈춘다)
		
	}
	
}
