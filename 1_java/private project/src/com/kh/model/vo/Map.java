package com.kh.model.vo;

public class Map {
	private int mapId;
	private String mapName;
	private String mapType;
	private int requriedLevel;
	private String mapInfo;
	
	public Map() {}
	
	public Map(String mapName, String mapType, int requriedLevel, String mapInfo) {
		super();
		this.mapName = mapName;
		this.mapType = mapType;
		this.requriedLevel = requriedLevel;
		this.mapInfo = mapInfo;
	}
	
	public Map(int mapId, String mapName, String mapType, int requriedLevel, String mapInfo) {
		super();
		this.mapName = mapName;
		this.mapType = mapType;
		this.requriedLevel = requriedLevel;
		this.mapInfo = mapInfo;
	}
	
	
	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getRequriedLevel() {
		return requriedLevel;
	}
	public void setRequriedLevel(int requriedLevel) {
		this.requriedLevel = requriedLevel;
	}
	public String getMapName() {
		return mapName;
	}
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	public String getMapType() {
		return mapType;
	}
	public void setMapType(String mapType) {
		this.mapType = mapType;
	}
	public String getMapInfo() {
		return mapInfo;
	}
	public void setMapInfo(String mapInfo) {
		this.mapInfo = mapInfo;
	}

	@Override
	public String toString() {
		return "맵 번호 : " + this.mapId + ", 맵 이름 : " + this.mapName + ", 맵 타입 : " + this.mapType + ", 입장 가능 레벨 : " + this.requriedLevel;
	}
	
	
}
