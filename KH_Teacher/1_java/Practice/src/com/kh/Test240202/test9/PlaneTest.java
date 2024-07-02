package com.kh.Test240202.test9;

public class PlaneTest {

	public static void main(String[] args) {
		// Airplane 과 Cargoplane 객체 생성   
		Plane airplane = new Airplane("L757", 1000);
		Plane cargoplane = new Cargoplane("C40", 1000);
		
        // 생성된 객체의 정보 출력   
		System.out.println("Plane\t\tfuelSize");
		System.out.println("-----------------------------");
		System.out.println(airplane.toString());
		System.out.println(cargoplane.toString());
        // Airplane 과 Cargoplane 객체에 100 씩 운항  
		System.out.println("100 운항");
		airplane.flight(100);
		cargoplane.flight(100);
        // 100 운항 후 객체 정보 출력
		
		System.out.println("Plane\t\tfuelSize");
		System.out.println("-----------------------------");
		System.out.println(airplane.toString());
		System.out.println(cargoplane.toString());
        
		//Airplane 과 Cargoplane 객체에 200 씩 주유
		System.out.println("200 주유");
		airplane.refuel(200);
		cargoplane.refuel(200);
		
        // 200 주유 후 객체 정보 출력
		System.out.println("Plane\t\tfuelSize");
		System.out.println("-----------------------------");
		System.out.println(airplane.toString());
		System.out.println(cargoplane.toString());

	}

}
