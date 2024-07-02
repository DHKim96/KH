package com.kh.EX02;

// 이름(name), 평균 합격컷(evgCut), 국어최저점수(koCut), 영어최저점수(enCut)
// 모든 데이터를 매개변수로받아 초기화하는 생성자 정의

public class University {
	private String name;
	private int evgCut;
	private int koCut;
	private int enCut;
	
	public University(String name, int evgCut, int koCut, int enCut) {
		this.name = name;
		this.evgCut = evgCut;
		this.koCut = koCut;
		this.enCut = enCut;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getEvgCut() {
		return this.evgCut;
	}
	
	public int getEnCut() {
		return this.enCut;
	}
	
	public int getKoCut() {
		return this.koCut;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEvgCut(int evgCut) {
		this.evgCut = evgCut;
	}
	
	public void setEnCut(int enCut) {
		this.enCut = enCut;
	}
	
	public void setKoCut(int koCut) {
		this.koCut = koCut;
	}
	
	//합격했다면 true / 불합격했다면 false 리턴
	public void isEvaluate(Student st) {
		if (st.getEvg() >= this.evgCut && 
				st.getEnScore() >= this.enCut &&
				st.getKoScore() >= this.koCut) {
			
			System.out.println(st.getName() + "님 축하합니다 합격입니다.");
		} else {
			System.out.println(st.getName() + "님 아쉽지만 불합격입니다.");
		}
	}
}
