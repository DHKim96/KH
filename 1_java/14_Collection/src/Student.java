

public class Student {
	private String name;
	private int age;
	private int score;
	
	public Student() {}
	
	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int hashCode() { // 모든 필드에 담긴 값이 일치하면 동일한 hashCode 반환
		String str = this.name + this.age + this.score;
		return str.hashCode();
	}
	
	// Student.equals(Student객체) 이런 식으로 호출될 것
	@Override
	public boolean equals(Object obj) { // 현재 객체와 전달받은 객체의 각 필드값의 일치여부를 boolean 값으로 반환
		boolean isEquals = false;
		// this(현재 객체)		< - >		obj(전달받은 객체)
		// Student							Object타입
		if(obj instanceof Student) {
			Student other = (Student)obj;
			if (this.toString().equals(other.toString())) {
				isEquals = true;
			}
		}
		return isEquals;
	}
	
	
	
	
}
