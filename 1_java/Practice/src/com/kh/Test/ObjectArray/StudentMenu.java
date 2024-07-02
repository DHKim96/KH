package com.kh.Test.ObjectArray;

public class StudentMenu {
	private StudentController ssm;
	
	public StudentMenu() {
		this.ssm = new StudentController();
		
		System.out.println("========== 학생 정보 출력 ==========");
		for ( Student s : ssm.printStudent() ) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("========== 학생 성적 출력 ==========");
		
		double arr[] = ssm.avgScore();
		System.out.println("학생 점수 합계 : " + (int)arr[0]);
		System.out.println("학생 점수 평균 : " + arr[1]);
		
		System.out.println();
		System.out.println("========== 성적 결과 출력 ==========");
		for ( Student s : ssm.printStudent() ) {
			if ( s.getScore() < ssm.CUT_LINE ) {
				System.out.println( s.getName() + "은(는) 재시험 대상입니다.");
			}
			else {
				System.out.println( s.getName() + "은(는) 통과입니다.");
			}
		}
		
	}
	
}
