import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetRun {

	public static void main(String[] args) {
		// Object객체.equals() : 두 객체의 "주소값"을 비교해서 boolean 값 반환
		// Object객체.hashCode() : 해당 객체의 "주소값"을 가지고 10진수의 형태로 만들어서 반환
		HashSet<String> hs1 = new HashSet<String>();
		
		hs1.add("반갑습니다.");
		hs1.add(new String("반갑습니다."));
		hs1.add(new String("여러분"));
		hs1.add(new String("안녕하세요"));
		hs1.add(new String("여러분"));
		
		System.out.println(hs1); // 저장 순서를 유지하지 않는다! 중복된 데이터(동일객체) 보관 불가
		// String객체.equals() 오버라이딩 : "실제 담긴 문자열"을 가지고 동등비교 진행하여 boolean 값 반환
		// String객체.hashCode() 오버라이딩 : "실제 담긴 문자열"을 가지고 10진수의 형태로 만들어서 반환
		
		
		HashSet<Student> hs2 = new HashSet<Student>();
		hs2.add(new Student("공유", 43, 100));
		hs2.add(new Student("최지원", 20, 85));
		hs2.add(new Student("홍길동", 25, 20));
		hs2.add(new Student("공유", 43, 100));
		
		// HashSet 이라는 공간에 객체가 추가될 때마다 동일객체인지 비교!
		// 동일객체 : 각 객체마다 hashCode 결과가 일치하고, equals 메소드로 비교 시 true 가 나올 때
		
		// Student객체.equals() 오버라이딩 : "실제 각 필드에 담긴 데이터"들을 가지고 boolean 값 반환
		// Student객체.hashCode() 오버라이딩 : "실제 각 필드에 담긴 데이터"들을 가지고 10진수 형태로 만들어 반환
		System.out.println(hs2);
		
		// HashSet객체.get(index) 안됨. why?
		// 		인덱스의 개념도 없고 get 메소드 자체가 정의되어 있지 않음.
		//		한 개씩 무작위로 가져올 수 있음
		// HashSet에 담긴 모든 객체들에 순차적으로 접근이 가능
		
		// 1. for문 사용 가능(for each 문으로만 가능; 인덱스가 없기 때문)
		for(Object s : hs2) {
			System.out.println(s);
		}
		
		// 2. ArrayList 에 담은 다음 해당 ArrayList 를 반복문으로 돌려가며 접근 가능
		// 2.1 ArrayList에 담는 방법
		// 2.1.1. ArrayList 생성 후 addAll 메소드 이용해 통채로 추가
		ArrayList<Student> list = new ArrayList<Student>();
		list.addAll(hs2);
		// 2.1.2. ArrayList 생성과 동시에 통채로 추가
		ArrayList<Student> list2 = new ArrayList<Student>(hs2);
		
		for (int i = 0 ; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		
		//3. Iterator 반복자 이용해 순차적으로 접근
		
		Iterator<Student> it = hs2.iterator();
		
		while(it.hasNext()) { // 다음에 가져올 값이 있을까?
			Student s = (Student)it.next(); // 이터레이터의 반환값은 오브젝트
			System.out.println(s);
		} // StringTokenizer 와 비슷한 개념
		
	}

}
