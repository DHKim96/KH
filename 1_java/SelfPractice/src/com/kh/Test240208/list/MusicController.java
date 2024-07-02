package com.kh.Test240208.list;

import java.util.ArrayList;
import java.util.List;

public class MusicController {
	private List<Music> list;
	
	public MusicController() {
		list = new ArrayList<Music>();
	}
	
	public int addList(Music music) {
		if (!list.contains(music)) {
			list.add(music);
			return 1;
		}
		return 0;
	}
	
	public int addAtZero(Music music) {
		if (!list.contains(music)) {
			list.add(0, music);
			return 1;
		}
		return 0;
	}
	
	public List<Music> printAll(){
		return this.list;
	}
	
	public Music searchMusic(String title) {
		for(int i = 0 ; i < list.size() ; i++ ) {
			if ( list.get(i).getTitle().equals(title) ) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		for(int i = 0 ; i < list.size() ; i++ ) {
			if ( list.get(i).getTitle().equals(title) ) {
				return list.remove(i);
			}
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		for(int i = 0 ; i < list.size() ; i++ ) {
			if ( list.get(i).getTitle().equals(title)) {
				list.get(i).setTitle(music.getTitle());
				list.get(i).setSinger(music.getSinger());
				return list.get(i);
			}
		}
		return null;
	}
	
	public int ascTitle() {
		list.sort(new AscTitle());
		return 1;
	}
	public int descSinger() {
		list.sort((obj1, obj2) -> ((Music)obj1).getSinger().compareTo( ((Music)obj2).getSinger() ) * -1 );
		return 1;
	}
}
