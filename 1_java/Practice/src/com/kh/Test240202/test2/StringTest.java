package com.kh.Test240202.test2;

public class StringTest {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34"; 
	    double data[]= new double[5]; 
	    double sum = 0; 
	 
	    // str에서 데이터를 분리한다. 
	    String[] st;  
	    st = str.split(",");
	 
	    int index = 0;
	    for(String s : st){     //for~each 문 사용한다. 
	    	data[index] = Double.parseDouble(s); // 배열에 실수 데이터를 넣는다. 
	    	sum += data[index];//배열 데이터의 합을 구한다.
	    	index++;
	    }   
	 
	    // 결과 값을 출력 한다.   
	    System.out.printf("합계 : %.3f\n", sum);
	    System.out.printf("평균 : %.3f\n", sum / index);
	    
	}

}
