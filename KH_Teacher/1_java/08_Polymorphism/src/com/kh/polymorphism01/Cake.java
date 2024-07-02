package com.kh.polymorphism01;

class Cake {
   public void yummy() {
	   System.out.println("yummy Cake");
   }
}

class CheeseCake extends Cake {
   public void yummy() {
	   super.yummy();
	   
   }    // Cake의 yummy를 오버라이딩
}

class StrawberryCheeseCake extends CheeseCake {
   public void yummy() {
	   super.yummy();
	   
   }    // 그리고 CheeseCake의 yummy를 오버라이딩
}
