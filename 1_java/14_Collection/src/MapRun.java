import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MapRun {

	public static void main(String[] args) {
		HashMap<String, Snack> hm = new HashMap<String, Snack>();
		
		// 계층구조를 보면
		// List 계열, Set 계열의 클래스들은 Collection 구현한 클래스이다.
		// => 객체를 추가하고자 할 때 공통적으로 add 메소드 사용!
		
		// Map 계열은 Collection을 구현한 클래스가 아님
		// => 객체 추가하고자 할 때 put 메소드 이용(key + value 세트로 담아야 함)
		
		// 1.put(K key, V value) : Map 에 key, value 세트로 추가시켜주는 메소드
		hm.put("다이제", new Snack("초코맛", 1000));
		hm.put("칸초", new Snack("단맛", 500));
		hm.put("새우깡", new Snack("짠맛",500));
		
		hm.put("먹태깡", new Snack("짠맛",300));
		
		System.out.println(hm); // {key=value, key=value, key=value...}
		// 저장되는 순서 유지 안됨!! value 값이 중복되어도 키값이 중복되지 않는다면 잘 저장됨
		
		// 동일한 key값으로 다시 추가하는 경우 value 값이 덮어씌워짐(중복된 key 값 공존 불가. key 값이 식별자 역할 수행)
		hm.put("새우깡", new Snack("매운맛",600));
		System.out.println(hm);
		
		// 2. get(Object key) : V => 해당 key 값을 가지는 value 값을 반환시켜주는 메소드
		Snack s = (Snack)hm.get("다이제");
		System.out.println(s);
		
		// 3. size() : 담겨있는 객체들의 갯수를 반환
		System.out.println(hm.size());
		
		// 4. replace(K key, V value) => 해당 key 값을 찾아서 다시 전달한 value 값으로 수정시켜주는 메소드
		hm.replace("먹태깡", new Snack("엄청 짠맛", 600));
		System.out.println(hm);
		
		// 5. remove(Object key) => 해당 key값을 찾아서 value 세트를 삭제시켜주는 메소드
		hm.remove("칸초");
		System.out.println(hm);
		
		// for each 문 => 안됨
//		for (Object obj : hm) {
//			
//		}
		
		// ArrayList 로 변경 => 안됨(Map은 컬렉션 상속 클래스가 아님)
//		ArrayList list = new ArrayList(hm);
		
		// Iterator 반복자 이용 => 안됨(Iterator 도 List 또는 Set 계열에서만 가능
		
		// Map -> Set 변경해주는 메소드 사용해야 함
		
		System.out.println("================keySet()===============");
		// 1. keySet() 메소드
		Set<String> keySet = hm.keySet();
		System.out.println(keySet);
		
		Iterator<String> itKey = keySet.iterator();
		while(itKey.hasNext()) {
			String key = (String)itKey.next();
			Snack value = (Snack)hm.get(key);
			System.out.println(key + " : " + value);
		}
		
		System.out.println("===============entrySet================");
		
		// 2. entrySet() 메소드
		Set<?> entrySet = hm.entrySet(); // key + value 세트의 집합을 반환
		Iterator<?> itEntry = entrySet.iterator();
		while(itEntry.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>)itEntry.next(); // Entry 객체 안에 key 값, value 값 다 담겨있음
			
			String key = (String)entry.getKey();
			Snack value = (Snack)entry.getValue();
			
			System.out.println(key + " : " + value);
		}
		
		
		System.out.println("===============Properties================");
		
		// Properties : Map 계열 컬렉션 => key + value 세트로 저장
		
		Properties prop = new Properties();
		// Map 계열이기 때문에 put 메소드 이용해 key + value 세트로 담음
//		prop.put("다이제", new Snack("초코맛", 1000));
//		prop.put("칸초", new Snack("단맛", 500));
//		prop.put("새우깡", new Snack("짠맛",500));
		prop.setProperty("list", "ArrayList");
		prop.setProperty("set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		
		System.out.println(prop); // 저장 순서 유지 안됨, key 값 중복 시 덮어씌움
//		System.out.println(prop.get("새우깡"));
		
		// Properties 사용하는 경우는 주로 Properties 에 담긴 것들을 파일로 출력 또는 입력받을 때 사용함
		// 즉, Properties 에서 제공하는 store(), load() 등의 메소드를 사용하기 위해서 사용
		
		Properties prop2 = new Properties();
		
		try {
			// store : Properties 에 담겨있는 key-value 값들을 파일 형태로 저장할 때 사용하는 메소드
			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			// ClassCastException 발생 - 직렬화 필요?
			// 내부적으로 store 실행 시 properties 에 있는 key + value 세트들을 String 으로 형변환해서 출력함
			
			
			//storeToXML : Properties 에 담겨있는 key - value 값들을 xml 파일 형태로 저장할 때 사용하는 메소드
			prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");
			
			// load
			prop2.load(new FileInputStream("test.properties"));
			// loadFromXML : xml 파일로부터 정보를 읽어옴
			prop2.loadFromXML(new FileInputStream("test.xml"));
			
			System.out.println(prop2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Properties 파일을 사용하는 이유
		 * 프로그램상에 필요한 기본 환경설정(서버의 ip 주소, DBMS 경로 ...) 관련한 구문을 기술할 것이다.
		 * => 모두 문자열이기 때문에 개발자가 아닌 일반인 관리자가 해당 문서를 수정하기 쉽다
		 * 
		 * xml -> 프로그래밍 언어 간에 있어서 호환성이 좋다.
		 */
		
	}

}
