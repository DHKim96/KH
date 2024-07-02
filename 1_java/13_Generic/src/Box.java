/*
 * 클래스를 정의할 때 타입을 정하지 않고 임의의 값으로 지정
 * 해당 타입은 실제 객체가 생성될 때 정의됨
 */
public class Box<T> {
	private T ob; // 무엇을 담을지 - 객체가 들어감
	private int size; // 크기
	
	public Box(T ob, int size) {
		super();
		this.ob = ob;
		this.size = size;
	}

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Box [ob=" + ob + ", size=" + size + "]";
	}
	
	
}
