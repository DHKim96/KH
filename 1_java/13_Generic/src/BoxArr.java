
public class BoxArr<T> {
	private T[] ob; // 무엇을 담을지 - 객체가 들어감
	private int size; // 크기
	
	public BoxArr() {};

	public T[] getOb() {
		return ob;
	}

	public void setOb(T[] ob) {
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
		return "BoxArr [ob=" + ob + ", size=" + size + "]";
	}
	
	
	
}
