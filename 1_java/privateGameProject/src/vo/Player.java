package vo;

public class Player {
	private int pNo;
	private String pName;
    private String job;
    private int level;
    private int maxExperience;
    private int experience;
    private int maxHp;
    private int hp;
    private int maxMp;
    private int mp;
    private int strength;
    private int intelligence;
    private int agility;
    private int money;
    
    public Player() {};
    
    // 플레이어 모드에서 캐릭터 최초 생성 시 값을 초기화하는 생성자
    public Player(String pName) {
    	this.pName = pName;
    	this.job = "모험가";
    	this.level = 1;
    	this.maxExperience = 10;
    	this.experience = 0;
    	this.maxHp = 100;
    	this.maxMp = 50;
    	this.hp = 100;
    	this.mp = 50;
		this.strength = 5;
	    this.intelligence = 0;
	    this.agility = 0;
	    this.money = 0;
    }
    
    // 자바에서 insert 하는 생성자
    public Player(String pName, String job, int level, int maxExperience, int experience, int maxHp, int hp,
            int maxMp, int mp, int strength, int intelligence, int agility, int money) {
        this.pName = pName;
        this.job = job;
        this.level = level;
        this.maxExperience = maxExperience;
        this.experience = experience;
        this.maxHp = maxHp;
        this.hp = hp;
        this.maxMp = maxMp;
        this.mp = mp;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.money = money;
    }
    
    
    // sql 연동 시 데이터베이스에서 값을 받아 객체를 생성하는 생성자
    public Player(int pNo, String pName, String job, int level, int maxExperience, int experience, int maxHp, int hp,
            int maxMp, int mp, int strength, int intelligence, int agility, int money) {
        this.pName = pName;
        this.job = job;
        this.level = level;
        this.maxExperience = maxExperience;
        this.experience = experience;
        this.maxHp = maxHp;
        this.hp = hp;
        this.maxMp = maxMp;
        this.mp = mp;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.money = money;
    }

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "플레이어 번호 : " + pNo + 
				"\n 플레이어명 : " + pName + 
				"\n 직업 : " + job + 
				"\n 레벨 :" + level + 
				"\n 필요경험치 : "+ maxExperience + 
				"\n 현재 경험치 : " + experience +
				"\n 최대 체력 : " + maxHp + 
				"\n 현재 체력 : " + hp + 
				"\n 최대 마나 : " + maxMp + 
				"\n 현재 마나 : " + mp + 
				"\n 힘 : " + strength + 
				"\n 지능 : " + intelligence + 
				"\n 민첩 : " + agility + 
				"\n 소지금 : " + money;
	}
    
	
    
    
}
