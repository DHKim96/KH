package test8;

public class UserTest {

	public static void main(String[] args) {
		User[] users = new User[3];
		{
			users[0] = new User("user01", "pass01", "김철수", 32, 'M', "010-1234-5678");
			users[1] = new User("user02", "pass02", "이영희", 25, 'F', "010-5555-7777");
			users[2] = new User("user03", "pass03", "황진이", 20, 'F', "010-9874-5632");
		}
		System.out.println("users list-------------------------");
		for(int i = 0 ; i < users.length ; i++) {
			System.out.println(users[i].toString());
		}
		
		User[] copyUsers = new User[users.length];
		
		for (int i = 0 ; i < users.length ; i++) {
			copyUsers[i] = (User)users[i].clone(); // 같은 자료형이어야 대입할 수 있으니 캐스팅
		}
		
		
		System.out.println("copyUsers-------------------------");
		for (User cu : copyUsers) {
			System.out.println(cu);
		}
		
		System.out.println("비교결과-----------------------------");
		for (int i = 0 ; i < users.length ; i++) {
			System.out.println(users[i].equals(copyUsers[i]));
		}

	}

}
