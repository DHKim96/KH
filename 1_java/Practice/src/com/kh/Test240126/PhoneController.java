package com.kh.Test240126;

public class PhoneController {
    private String[] result;

    public String[] method() {
        // 2개의 Phone 객체를 저장할 수 있는 객체배열 생성
        Phone[] phones = new Phone[2];
        // 각각의 인덱스에 다형성을 적용하여 GalaxyNote9, V40 객체 저장
        phones[0] = new GalaxyNote9();
        phones[1] = new V40();
        
        // 반환할 문자열 배열 초기화
        result = new String[phones.length];
        // for문을 이용하여 Phone 객체배열에 각 인덱스의 printInformation()의 반환 값을 String배열에 담아 반환
        for (int i = 0; i < phones.length; i++) {
        	result[i] = ((SmartPhone)phones[i]).printInformation();
        }
        return result;
    }
}
