import java.util.ArrayList;

public class Run {

	public static void main(String[] args) {
		
		
//		Box aBox = new Box("사과", 10); // 이렇게 생성하지 않고
		// 객체를 생성하는 시점에 어떤 타입을 사용할지 타입 인자를 전달해줌
		Box<String> aBox = new Box<String>("사과", 10);
		
		System.out.println(aBox);
		
		aBox.setOb("복숭아"); // 객체 생성 시점에 String형으로 정해졌기에 가능
		
		BoxArr<Integer> aBoxArr = new BoxArr<>();
		
		Integer[] arr = new Integer[10];
		aBoxArr.setOb(arr);
		
		aBoxArr.getOb()[0] =  10;
		
		ArrayList<String> arr1 = new ArrayList<>();
		
		
		arr1.set(0, "안녕");  // "안녕" 대신 숫자를 넣으면 컴파일 에러 발생. why? 객체 생성 시 제너릭으로 String형 쓰겠다고 선언했기 때문에
	}

	
	
	
	
	
	
}
