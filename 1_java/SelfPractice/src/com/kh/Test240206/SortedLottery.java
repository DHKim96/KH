package com.kh.Test240206;

import java.util.Comparator;

public class SortedLottery implements Comparator<Lottery>{

	@Override
	public int compare(Lottery o1, Lottery o2) {
		int num = o1.getName().compareTo(o2.getName());
		if( num == 0 ) {
			return o1.getPhone().compareTo(o2.getPhone());
		}
		/*
		 * 음수 : o1 < o2 일 때
		 * 0 : o1 == o2
		 * 양수 : o1 > o2
		 * 오름차순(내림차순은 부호 반대로 바꿔주면 됨)
		 * 
		 */
		return num;
	}

	
	
}

//public int compare(Book obj1, Book obj2) {
//return obj1.getTitle().compareTo(obj2.getTitle());
//}
