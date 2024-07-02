package com.kh.model.vo;

public class Item {
	 // 속성들
	private int iId;
    private String type; // 아이템의 종류 (무기, 갑옷, 포션 등)
    private String name;
    private int price;
    private String info;
    private int playerId;

	public Item(String type, String name, int price, String info) {
		super();
		this.type = type;
		this.name = name;
		this.price = price;
		this.info = info;
	}
	
	public Item(int iId, String type, String name, int price, String info, int playerId) {
		super();
		this.iId = iId;
		this.type = type;
		this.name = name;
		this.price = price;
		this.info = info;
		this.playerId = playerId;
	}
	

	
	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	
	
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return 	"번호: " + this.getiId() +
				   ", 이름: " + this.getName() +
		           ", 종류: " + this.getType() +
		           ", 가격: " + this.getPrice();
	}
	
	
	
}
