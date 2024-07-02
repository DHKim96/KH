package com.kh.threadtest;

public class Task2 extends Thread{ // 20미만 홀수 출력
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				if (i % 2 == 1) {
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
