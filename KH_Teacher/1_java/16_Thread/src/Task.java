
public class Task extends Thread{
	@Override
	public void run() {
		int n1 = 20;
		int n2 = 30;
		//currentThread() : 지금 실행하고 있는 쓰레드의 정보를 반환한다.
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1 + n2));
	}
}
