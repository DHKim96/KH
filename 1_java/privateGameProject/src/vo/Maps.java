package vo;

import java.util.ArrayList;

public class Maps {
	private int mapId;
	private String mapName;
	private String mapType;
	private int requiredLevel;
	private ArrayList<Enemy> enemies;
	
	public Maps() {}
	
	//데이터를 받아서 생성하는 용
	public Maps(String mapName, String mapType, int requriedLevel, ArrayList<Enemy> enemies) {
		super();
		this.mapName = mapName;
		this.mapType = mapType;
		this.requiredLevel = requriedLevel;
		this.enemies = enemies;
	}
	
	//db에서 가져오는 생성자
	public Maps(int mapId, String mapName, String mapType, int requiredLevel) {
		super();
		this.mapName = mapName;
		this.mapType = mapType;
		this.requiredLevel = requiredLevel;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
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

	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	@Override
	public String toString() {
		return "맵 번호 : " + mapId + 
				"\n 맵 이름 : " + mapName + 
				"\n 맵 타입 : " + mapType + 
				"\n 최소 요구 레벨 : " + requiredLevel;
	}
	
}
