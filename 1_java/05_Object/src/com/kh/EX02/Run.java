package com.kh.EX02;
//import java.util.Scanner;
public class Run {

	public static void main(String[] args) {
//		// choi 객체 생성 최지원, 15살, 영어 60점, 수학 70점, 국어 80점.
//		// kim 객체 생성 김동현, 17살, 영어 95, 수학 85, 국어 80
//		
//		Student choi = new Student("최지원", 15, 60, 70, 80);
//		Student kim = new Student("김동현", 17, 95, 85, 80);
//		
//		
//		//choi / kim  의 모든 과목의 평균을 각각 출력해라
//		
//		int choiarg = ((choi.getEnglishScore() + choi.getKoreanScore() + choi.getMathScore()) / 3) ;
//		int kimarg = (kim.getEnglishScore() + kim.getKoreanScore() + kim.getMathScore() )/ 3;
//		System.out.println(choi.getName() + "님의 평균은 " + choiarg + "입니다");
//		System.out.println(kim.getName() + "님의 평균은 " + kimarg + "입니다");
//		
//		System.out.println(choi.getName() + "님의 평균은 " + choi.getEverage() + "입니다");
//		System.out.println(kim.getName() + "님의 평균은 " + kim.getEverage() + "입니다");
		
		/*
		 * 사용자로부터 이름, 나이, 영어 점수, 수학 점수, 국어 점수를 입력받아
		 * 평균을 구하고 출력하는 프로그램 작서ㅡㅇ
		 * 
		 * [예시]
		 * 이름: 최지원
		 * 나이 : 15
		 * 영어 점수 : 80
		 * 수학 점수 : 100
		 * 국어 점수 : 75
		 * 최지원님의 평균 : 85
		 */
//		Scanner sc = new Scanner(System.in);
//		String name;
//		int age, enScore, maScore, koScore;
//		
//		System.out.print("이름 : ");
//		name = sc.nextLine();
//		
//		System.out.print("나이 : ");
//		age = sc.nextInt();
//		
//		System.out.print("영어 점수 : ");
//		enScore = sc.nextInt();
//		
//		System.out.print("수학 점수 : ");
//		maScore = sc.nextInt();
//		
//		System.out.print("국어 점수 : ");
//		koScore = sc.nextInt();
//		
//		sc.close();
//		
//		Student st1 = new Student(name, age, maScore, enScore, koScore);
//		
//		System.out.printf("%s님의 평균 : %d", st1.getName(), st1.getEverage());
//		
		// kh대학교, 평균 합격컷 : 75, 영어 컷 : 60, 국어 최저점수 : 60으로 객체 생성
		
		University kh = new University("kh대학교", 75, 60, 60);
		Student choi = new Student("최지원", 15, 70, 60, 80);
		
		/*
		 * choi 학생 객체는 kh 대학교에 입학 가능한지 검사하여
		 * 가능하다면 "합격입니다"
		 * 불가능하다면 "불합격입니다"
		 * 를 출력하는 프로그램 작성
		 */
		
		//조건문 통해 가능 => 메소드로 구현할 수도 있음
		Student kim = new Student("김동현", 17, 85, 100, 75);
		
		// System.out.println(kh.isEvaluate(kim) ? "합격입니다" : "불합격입니다");
		
		kh.isEvaluate(kim);
		kh.isEvaluate(choi);// 출력문까지 한 번에 메소드로 구현
	}

}
