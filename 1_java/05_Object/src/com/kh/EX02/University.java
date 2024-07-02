package com.kh.EX02;

/*
 * 대학교 이름, 평균 합격컷, 국어 최저 점수, 영어 최저 점수
 * 모든 데이터를 매개변수로 받아 초기화하는 생성자 정의
 */
public class University {
	private String uniName;
	private int avgCut;
	private int koCut;
	private int enCut;
	
	public University(String uniName, int avgCut, int koCut, int enCut) {
		this.uniName = uniName;
		this.avgCut = avgCut;
		this.koCut = koCut;
		this.enCut = enCut;
	}
	
	public String getUniName() {
		return this.uniName;
	}
	
	public int getAvgCut() {
		return this.avgCut;
	}
	
	public int getKoCut() {
		return this.koCut;
	}
	
	public int getEnCut() {
		return this.enCut;
	}
	
	public void setUniName(String uniName){ //자료형 까먹지말고 써줘
		this.uniName = uniName;
	}
	
	public void setAvgCut(int avgCut) {
		this.avgCut = avgCut;
	}
	
	public void setKoCut(int koCut) {
		this.koCut = koCut;
	}
	
	public void setEnCut(int enCut) {
		this.enCut = enCut;
	}
	
	//합격했다면 true / 불합격시 false 리턴
//	public boolean isEvaluate(Student st) {
//		if(st.getEverage() >= this.avgCut && 
//				st.getEnglishScore() >= this.enCut &&
//				st.getKoreanScore() >= this.koCut) {
//			return true;
//		}
//		else {
//			return false;
//		}
		
	public void isEvaluate(Student st) {
		if(st.getEverage() >= this.avgCut && 
				st.getEnglishScore() >= this.enCut &&
				st.getKoreanScore() >= this.koCut) {
				System.out.println(st.getName() + "님 축하합니다 합격입니다.");;
			}
			else {
				System.out.println(st.getName() + "님 아쉽지만 불합격입니다.");;
			}
	}
}
