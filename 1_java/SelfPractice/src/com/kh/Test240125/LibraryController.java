package com.kh.Test240125;

public class LibraryController {
	private Member mem;
	private Book[] bList;
	
	public LibraryController(){ // 클래스 영역에서는 if문 등의 코드를 쓸 수 없음. 정의하는 공간이지 코드를 구현하는 공간이 아니기 때문
		this.mem = null;
		this.bList = new Book[5];
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return this.bList;
	}
	
	public Book[] searchBook(String keyword) {
			Book[] myList = new Book[5];
			int index = 0;
			for(int i = 0 ; i < bList.length ; i++) { // bList[i] 는 인덱스i의 배열의 길이 즉, 2차원 배열에 해당
				if(bList[i].getTitle().contains(keyword)) {
					myList[index++] = bList[i];
				}
			}
		return myList;
	}
	
	public int rentBook(int index) {
		int result = 0;
		
		if (bList[index] instanceof AniBook) {
			AniBook aniBook = ((AniBook)bList[index]);
			if ( aniBook.getAccessAge() > this.mem.getAge() ){
				result = 1;
			}
		}
		else if (bList[index] instanceof CookBook) {
			CookBook cookBook = ( (CookBook)bList[index] );
			if ( cookBook.isCoupon() ) {
				this.mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
		}
		return result;	
		}
		
}
