package com.kh.threadtest;

public class Task1 extends Thread { // 20미만 짝수 출력
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				if (i % 2 == 0) {
					System.out.print(i + " ");
				}
				Thread.sleep(100);  // 0.1초간 잠을잔다.
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
