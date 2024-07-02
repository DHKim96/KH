package com.kh.threadTest;

public class Task2 extends Thread{ // 20미만 홀수 출력

	@Override
	public void run() {
		try {
			for(int i = 0 ; i < 20 ; i++) {
				if (i % 2 == 1) {
					System.out.print(i + " ");
				}
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 0.1초간 잠을 잔다(멈춘다)
		
	}
	
}
