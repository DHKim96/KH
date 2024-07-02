package com.kh.Test240123;

public class Student {
	String name;
	int maScore;
	int koScore;
	int enScore;
	
	public Student(String name, int maScore, int koScore, int enScore ) {
		this.name = name;
		this.maScore = maScore;
		this.koScore = koScore;
		this.enScore = enScore;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaScore() {
		return maScore;
	}

	public void setMaScore(int maScore) {
		this.maScore = maScore;
	}

	public int getKoScore() {
		return koScore;
	}

	public void setKoScore(int koScore) {
		this.koScore = koScore;
	}

	public int getEnScore() {
		return enScore;
	}
	
	public void setEnScore(int enScore) {
		this.enScore = enScore;
	}

	public double getAverage() {
		return (this.enScore + this.koScore + this.maScore) / 3;
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", maScore=" + maScore + ", koScore=" + koScore + ", enScore=" + enScore
				+ ", average=" + this.getAverage() + "]";
	} // alt + shift + s
	
}
