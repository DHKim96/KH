package com.kh.model.vo;

public class Equipment extends Item {
	  // 속성들
    private int bonusStrength; // 힘 보너스
    private int bonusIntelligence; // 지능 보너스
    private int bonusAgility; // 민첩성 보너스
    
    // 장비 객체 생성자
    public Equipment(String type, String name, int price, String info, int bonusStrength, int bonusIntelligence,
			int bonusAgility) {
		super(type, name, price, info);
		this.bonusStrength = bonusStrength;
		this.bonusIntelligence = bonusIntelligence;
		this.bonusAgility = bonusAgility;
	}

	public int getBonusStrength() {
		return bonusStrength;
	}

	public void setBonusStrength(int bonusStrength) {
		this.bonusStrength = bonusStrength;
	}

	public int getBonusIntelligence() {
		return bonusIntelligence;
	}

	public void setBonusIntelligence(int bonusIntelligence) {
		this.bonusIntelligence = bonusIntelligence;
	}

	public int getBonusAgility() {
		return bonusAgility;
	}

	public void setBonusAgility(int bonusAgility) {
		this.bonusAgility = bonusAgility;
	}

	@Override
	public String toString() {
		return super.toString() +
				", 힘 보너스: " + bonusStrength +
		           ", 지능 보너스: " + bonusIntelligence +
		           ", 민첩성 보너스: " + bonusAgility +
		           ", 아이템 정보 : " + super.getInfo();
	}

}
