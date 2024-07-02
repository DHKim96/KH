package com.kh.model.vo;

public class Skill {
	 // 속성들
	private int skillId;
    private String name;
    private String type; // 스킬의 종류 (공격, 방어, 마법, 지원 등)
    private int power; // 스킬의 효과 (피해량, 방어력 증가, 회복량 등)
    private int requiredLevel;
    private int requiredInt;
    private int reduceMp;
    private int playerId;

    // 생성자
    public Skill(String name, String type, int power, int requiredLevel, int requiredInt, int reduceMp) {
		super();
		this.name = name;
		this.type = type;
		this.power = power;
		this.requiredLevel = requiredLevel;
		this.requiredInt = requiredInt;
		this.reduceMp = reduceMp;
	}
   
    
    public Skill(int skillId, String name, String type, int power, int requiredLevel, int requiredInt, int reduceMp, int playerId) {
		super();
		this.skillId = skillId;
		this.name = name;
		this.type = type;
		this.power = power;
		this.requiredLevel = requiredLevel;
		this.requiredInt = requiredInt;
		this.reduceMp = reduceMp;
		this.playerId = playerId;
	}
    
    
    
	public int getPlayerId() {
		return playerId;
	}


	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


	public int getSkillId() {
		return skillId;
	}



	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}



	public String getName() {
		return name;
	}

	
	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	public int getRequiredInt() {
		return requiredInt;
	}

	public void setRequiredInt(int requiredInt) {
		this.requiredInt = requiredInt;
	}

	public int getReduceMp() {
		return reduceMp;
	}

	public void setReduceMp(int reduceMp) {
		this.reduceMp = reduceMp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}



	// 스킬 사용 메서드 (효과 적용)
    public int use(Player c) {
        // 스킬의 효과를 적용합니다. 여기서는 단순히 피해량을 반환합니다.
        return power;
    }


	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", name=" + name + ", type=" + type + ", power=" + power
				+ ", requiredLevel=" + requiredLevel + ", requiredInt=" + requiredInt + ", reduceMp=" + reduceMp
				+ ", playerId=" + playerId + "]";
	}

   
}
