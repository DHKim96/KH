package com.kh.Test240125;

public class LibraryController {
	private Member mem = null;
	private Book[] bList;
	
	public LibraryController(){
		bList = new Book[5];
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
		//keyword가 포함된 도서
		//bList 안의 도서들과 keyword를 비교하여 포함하고 있는 경우 tmpArr에 차곡차곡담기
		Book[] tmpArr = new Book[5];
		int count = 0;
		
		for (int i = 0; i < bList.length; i++) {
			if (bList[i].getTitle().contains(keyword)) { // keyword를 비교하여 포함하고 있는 경우
				tmpArr[count++] = bList[i];
			}
		}
		
		return tmpArr;
		
	}
	
	public int rentBook(int index) {
		int result = 0;
		// Book -> 상속관계중에 AniBook이 존재하니?
		// Book, AniBook, CookBook
		if (bList[index] instanceof AniBook) { //만화책인경우
			AniBook ainBook = (AniBook)bList[index];
			if (mem.getAge() < ainBook.getAccessAge()) { // 회원의 나이가 더 적은 경우
				result = 1;
			} 
		} else if (bList[index] instanceof CookBook){ //요리책인경우
			CookBook cookBook = (CookBook)bList[index];
			if (cookBook.isCoupon()) { // 쿠폰유무가 유일경우
				mem.setCouponCount(mem.getCouponCount()+1);
				result = 2;
			}
		}
				
		return result;
	}
}