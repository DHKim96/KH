import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MapRun {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		
		// 계층구조를 보면
		// List계열, Set계열의 클래스들은 Collection 구현한 클래스이다.
		// => 객체를 추가하고자 할때 공통적으로 add메소드를 사용!
		
		// Map계열은 Collection을 구현한 클래스가 아님
		// => 객체를 추가하고자 할때 put메소드를 이용(key + value 세트로 담아야합니다.)
		
		// 1. put(K key, V value) :Map에 키 벨류 세트로 추가시켜주는 메소드
		hm.put("다이제", new Snack("초코맛", 1000));
		hm.put("칸초", new Snack("단맛", 500));
		hm.put("새우깡", new Snack("짠맛", 500));
		
		hm.put("먹태깡", new Snack("짠맛", 300));
		
		System.out.println(hm); // {키=벨류, 키=벨류...}
		//저장되는 순서 유지 안됨!! value값이 중복되어도 키값이 중복되지 않는다면 잘 저장됨
		
		hm.put("새우깡", new Snack("매운맛", 600));
		// 동일한 키값으로 다시 추가하는 경우 value값이 덮어씌워짐!! (중복된 키값 공존할 수 없음! 키값이 식별자 역할을 함)
		System.out.println(hm); 
		
		// 2. get(Object key) : V => 해당 키값을 가지는 Value값을 반환시켜주는 메소드
		Snack s = (Snack)hm.get("다이제");
		System.out.println(s);
		
		// 3. size() : 담겨있는 객체들의 객수 반환
		System.out.println(hm.size());
		
		// 4. replace(k key, v value) => 해당 키값을 찾아서 다시 전달한 Value값으로 수정시켜주는 메소드
		hm.replace("먹태깡", new Snack("엄청 짠맛", 600));
		
		System.out.println(hm);
		
		// 5. remove(Object key) => 해당 키값을 찾아서 그 벨류세트를 삭제시켜주는 메소드
		hm.remove("칸초");
		System.out.println(hm);
		
		// for each문 => 안됨
//		for (Object obj : hm) {
//			
//		}
		
		//ArrayList로 변경가능? 안됨
		//ArrayList list = new ArrayList(hm);
		
		//Iterator 반복자 이용가능? 안됨
		// 바로 Iterator를 호출할 수 없음 왜? -> Iterator는 List계열 또는 Set계열에서만 가능하기 때문
		
		// Map -> Set 변경해주는 메소드를 제공한다
		
		// 1. keySet() 이용하는 방법
		Set keySet = hm.keySet();
		System.out.println(keySet);
		
		Iterator itKey = keySet.iterator();
		while(itKey.hasNext()) {
			String key = (String)itKey.next();
			Snack value = (Snack)hm.get(key);
			System.out.println(key + " : " + value);
		}
		
		//==================================================================
		//2. entrySet() 이용하는 방법
		
		Set entrySet = hm.entrySet(); // key+value세트의 집합
		
		Iterator itEntry = entrySet.iterator();
		
		while(itEntry.hasNext()) {
			Entry entry = (Entry)itEntry.next(); // Entry객체안에 key, value값이 다 담겨있다.
			
			String key = (String)entry.getKey();
			Snack value = (Snack)entry.getValue();
			
			System.out.println(key + " : " + value);
		}
		
		
		// Properties : Map계열의 컬렉션 => 키+벨류 세트로 저장
		
		Properties prop = new Properties();
		
		//Map계열이기 떄문에 put 메소드를 이용해서 키+벨류 세트로 담는다.
//		prop.put("다이제", new Snack("초코맛", 1000));
//		prop.put("칸초", new Snack("단맛", 500));
//		prop.put("새우깡", new Snack("짠맛", 500));
		prop.setProperty("list", "ArrayList");
		prop.setProperty("set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop); // 저장순서 유지안됨, key값 중복시 덮어씌움
		
		//Properties 사용하는 경우는 주로 Properties에 담긴 것들을 파일로 출력 또는 입력받아 올때 사용함
		//즉, Properties에서 제공하는 store(), load()등의 메소드를 사용하기위해서 사용
		
		Properties prop2 = new Properties();
		
		try {
			//store : Properties에 담겨있는 key-value값들을 파일형태로 저장할 때 사용하는 메소드
			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			//ClassCastException
			//내부적으로 store실행시 properties에 담겨있는 키+벨류 세트들을 String으로 형변환해서 출력함
			
			//storeToXML : Properties에 담겨있는 key-value값들을 xml파일형태로 저장할 때 사용하는 메소드
			prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");
			
			// load : 파일로부터 정보를 읽어온다.
			prop2.load(new FileInputStream("test.properties"));
			System.out.println(prop2);
			
			//loadFromXML : xml파일로부터 정보를 읽어온다.
			prop2.loadFromXML(new FileInputStream("test.xml"));
			
			System.out.println(prop2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * properties파일을 사용하는 이유
		 * 프로그램상에 필요한 기본 환경설정(서버의 ip주소, dbms경로...)관련한 구문을 기술할 것이다.
		 * => 모두 문자열이기 떄문에 개발자가 아닌 일반인관리자가 해당 문서를 수정하기 쉽다
		 * 
		 * xml -> 프로그래밍 언어들간에 있어서 호환성이 좋다.
		 */
	}
}
