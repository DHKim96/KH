package com.kh.Test240208.list;

public class Music {
	private String title;
	private String singer;
	
	public Music() {}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public int hashCode() {
		String str = this.title + this.singer;
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Music) {
			if(obj.toString().equals(this.toString())) {
				return true;
			}
		}
		return false;
	}
	
	
	public int compareTo(Object o) {
		if (o instanceof Music) {
			return this.title.compareTo( ((Music)o).getTitle());
		}
		return 0;
	}
}
