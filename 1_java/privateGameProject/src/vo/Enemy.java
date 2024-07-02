package vo;

public class Enemy {
	private int eId;
	private String name;
    private int health;
    private int strength;
    private int agility;
    private int experience; // 플레이어에게 제공하는 경험치
    private int money; // 플레이어에게 제공하는 돈
    
    public Enemy() {}
    
    //db에 저장하기 위한 생성자
    public Enemy(String name, int health, int strength, int agility, int experience, int money) {
    	this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.experience = experience;
        this.money = money;
    }
    
    // db에서 가져오기 위한 생성자
    public Enemy(int eId, String name, int health, int strength, int agility, int experience, int money) {
        this.eId = eId;
    	this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.experience = experience;
        this.money = money;
    }

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "적 번호 : " + eId + 
				"\n 적 이름 : " + name + 
				"\n 체력 : " + health + 
				"\n 힘 : " + strength + 
				"\n 민첩 : " + agility + 
				"\n 드랍 경험치 : " + experience + 
				"\n 드랍 머니 : " + money;
	}
    
}
