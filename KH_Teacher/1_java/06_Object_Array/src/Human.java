
public class Human {
	private String name;
	private int age;
	private char classRoom;
	
	public Human(String name, int age, char classRoom) {
		this.name = name;
		this.age = age;
		this.classRoom = classRoom;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void print() {
		System.out.printf("%c강의장에서 수업을 듣고있는 %d살 %s입니다.", this.classRoom, this.age, this.name);
	}
}
