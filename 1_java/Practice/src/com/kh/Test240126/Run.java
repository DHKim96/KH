package com.kh.Test240126;

public class Run {
  public static void main(String[] args) {
        // PracticeController 객체 생성
        PhoneController phControler = new PhoneController();
        // method() 호출 후 반환 값을 String 배열에 담기
        String[] results = phControler.method();
        // 결과 출력
        for (String result : results) {
            System.out.println(result);
            System.out.println();
        }
    }
}
