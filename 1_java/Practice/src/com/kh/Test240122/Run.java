package com.kh.Test240122;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정수 n(2~9)를 입력받아 2부터 n까지 중 짝수의 구구단을 출력하는 함수를 작성하세요. 
		// 만약 2~9사이의 값을 입력하지 않았다면 다시입력하세요를 반복합니다.
		
		/*
		do {
			//정수 n 입력받기
			System.out.print("정수를 입력 : ");
			int n = sc.nextInt();
			
			if (n < 2 || n > 9) {
				continue;
			}
			// 반복문을 통해 2부터 n보다 작거나 같을때까지 반복하며 구구단출력(내부에서 1~9까지 반복문 하나더)
			for(int i = 2; i <= n; i++) {
				// 2*1 2*2 2*3... 2*9
				if (i % 2 != 0) {
					continue;
				}
				
				for (int j = 1; j < 10; j++) {
					System.out.printf("%d * %d = %d\n",i, j, i * j);
				}
				System.out.println();
			}
			
			break;
	 		// 전체를 2~9사이의 값인지를 확인하는 반복문으로 감싸주기
		} while(true);
		*/
		
		/*
		//정수 num을 입력받아 크기가 num인 정수형 배열을 만들고 1~100사이의 랜덤값으로 모든 배열의 값을 대입합니다.
		// 이후 모든 배열의 홀수인덱스의 값을 더한 값을 구하세요.
		
		//정수 num입력받아 배열만들기
		System.out.print("정수 입력 : ");
		int num = sc.nextInt(), sum = 0;
		// 0~(num - 1 또는 배열의 길이 - 1)까지 반복하며 Math.random() * 100 + 1 값 대입해주기
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100 + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < arr.length; i++) {
			if (i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.print("총 합 : " + sum);
		
		// 변수sum 만들고 전체 배열 반복하며 인덱스 i가 i % 2 = 1 인값 더하기
		// 더한값 출력
		*/
		
		/*
		//다음과 같은 코드를 실행했을 때 예시와같은 결과가 출력되도록 TV클래스를 작성하세요.
		 TV myTV = new TV("삼성", 2020, 65, 100000);
		 myTV.show();
		 TV myTV2 = new TV("LG", 2024, 85, 200000);
	
		 
		// => 삼성에서 만든 2020년형 65인치 TV
		// => LG에서 만든 2024년형 85인치 TV
		 
		 
		//one이라는 Human객체를 생성하고
		// 해당객체로 myTV와 myTV2구매가 가능한지 확인
		 Human one = new Human("최지원", 150000);
		 one.buy(myTV);
		 myTV.show();
		 myTV.inch = 3;
		 */
		/*
		System.out.println(Human.count);
		
		Human choi = new Human("최지원", 15000);
		System.out.println(Human.count);
		
		Human kim = new Human("김지원", 15000);
		System.out.println(Human.count);
		*/
		
		// ==============================================================
		
		/*
		 * 우리는 도서관에서 책을 관리하는 프로그램을 만든다고 가정한다.
		 * 해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book 클래스이다.
		 * 필요하다고 생각하는 데이터와 기능을 구현해보자
		 * 
		 * 
		 * Book book1 = new Book(초기화변수);
		 */
		
		// 사용자로부터 제목, 장르, 저자, 책번호를 입력받아
		// book객체를 생성하고 생성된 객체의 toString메소드를 호출하여 정보를 확인해주세요.
		
		
		Book[] bookArr = new Book[100];
		int count = 0;
		int menu = 0;
		
		while(menu != 9) {
			System.out.println("==============도서관리프로그램===============");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서목록출력");
			System.out.println("3. 도서검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1: {
				int number;
				String title, genre, author; // 제목
				System.out.print("도서 제목 : ");
				title = sc.next();
				
				System.out.print("장르 : ");
				genre = sc.next();
				
				System.out.print("저자 : ");
				author = sc.next();
				
				System.out.print("책 번호 : ");
				number = sc.nextInt();
				
				bookArr[count] = new Book(title, genre, author, number);
				System.out.println("도서등록 완료 : " + bookArr[count++].toString());
			}break;
			case 2:
				//배열bookArr에 등록된 모든 도서정보 출력
				// ============등록된 도서정보=================
				//Book [title=홍길동전, genre=소설, author=박지원, number=1]
				
				System.out.println("============등록된 도서정보=================");
				if (bookArr[0] == null) {
					System.out.println("등록된 도서가 없습니다.");
					break;
				}
				for (int i = 0; i < bookArr.length; i++) {
					if (bookArr[i] == null)
						break;
					System.out.println(bookArr[i].toString());
				}
				break;
			case 3:{
				System.out.println("===============도서 검색==================");
				System.out.print("검색할 도서 제목 : ");
				String title = sc.next();
				Book target = null;
				
				for (int i = 0; i < bookArr.length; i++) {
					if (bookArr[i] == null) {
						break;
					} else if(bookArr[i].getTitle().equals(title)) { // Book배열 요소에 있는 제목이 입력받은 제목과 동일하다면
						target = bookArr[i]; //만약 찾았다면 target => null아님
						break;
					}
				}
				if (target == null) {
					System.out.println("동일한 제목의 도서가 없습니다.");
				} else {
					System.out.println("검색 도서 정보 : " + target.toString());
				}
				
			}break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
			}	
		}
	}

}
