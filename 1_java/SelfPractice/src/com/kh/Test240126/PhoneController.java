package com.kh.Test240126;

public class PhoneController {
	private String[] result;
	
	public PhoneController() {
		result = new String[2];
	}
	
	public String[] method() {
		Phone[] phone = new Phone[2];
		
		phone[0] = new GalaxyNote9();
		
		phone[1] =  new V40();
		
		for(int i = 0 ; i < phone.length ; i++) {
//			if(phone[i] instanceof GalaxyNote9) {
//				result[i] = ((GalaxyNote9)phone[i]).printInformation();
//			}
//			else if (phone[i] instanceof V40){
//				result[i] = ((V40)phone[i]).printInformation();
//			}
			result[i] = ((SmartPhone)phone[i]).printInformation();
			// 어차피 위에서 갤럭시노트와 v40의 객체들을 만들어줬고
			// 해당 객체들에서 사용할 메서드들은 부모 클래스인 SmartPhone의 메서드들이 전부 오버라이딩된 것.
			// 따라서 SmartPhone으로 다운캐스팅을 하더라도 각 객체들의 printinfomation값들이 다 나오기 때문
		}
		
		return result;
	}
}
