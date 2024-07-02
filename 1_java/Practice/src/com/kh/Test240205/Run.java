package com.kh.Test240205;

public class Run {
	public static void main(String[] args) {
		Human[] aGroup = new Human[5];
		
		aGroup[0] = new Human("김개똥", 20);
		aGroup[1] = new Human("김개순", 25);
		aGroup[2] = new Human("최지훈", 30);
		aGroup[3] = new Human("최지연", 40);
		aGroup[4] = new Human("최수민", 50);
		//김철수, 70
		
		Human[] tmp = new Human[aGroup.length + 1];
		for(int i = 0; i < aGroup.length; i++) {
			tmp[i] = aGroup[i];
		}
		tmp[5] = new Human("김철수", 70);
		
		aGroup = tmp;
		
		for(Human h :  aGroup) {
			System.out.println(h);
		}
		
		//중간에 있는 2번째 인덱스값 삭제
		aGroup[2] = null;
		
		for(int i = 2; i < 5; i++) {
			aGroup[i] = aGroup[i + 1];
		}
		aGroup[5] = null;
		
	}
}
