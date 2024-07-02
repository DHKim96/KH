package com.kh.Test240208.list;

import java.util.Comparator;

public class AscTitle implements Comparator<Music> {

	@Override
	public int compare(Music m1, Music m2) {
		
		int result = m1.getTitle().compareTo(m2.getTitle()) ;
		
		if ( m1.getTitle().equals(m2.getTitle()) ){
			result = m1.getSinger().compareTo(m2.getSinger());
		}
		return result;
	}
	
}
