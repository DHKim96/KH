
public class Thread01 {

	/*
	 * 쓰레드 : 프로그램 내에서 실행의 흐름을 가지고있는 최소 단위
	 *        main메소드 실행시 메인쓰레드가 실행되는 것이다.
	 */
	public static void main(String[] args) {
		Runnable task = new MyRunable();
		
		Thread t1 = new Thread(task);
		Task t2 = new Task();
		t1.start();
		t2.start();

		System.out.println("End : " + Thread.currentThread().getName());
	}

}
