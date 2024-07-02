package com.kh.model.vo;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	Scanner sc = new Scanner(System.in);
	
	private int playerNo;
	private String name;
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
    private ArrayList<Skill> skillList = new ArrayList<>();
    private ArrayList<Equipment> equipmentList = new ArrayList<>();
    private ArrayList<Item> inventory = new ArrayList<>();
    
    // 생성자
    
    public Player() {};
    
    // 처음 캐릭터 생성 시 초기화된 생성자
    public Player(String name) {
    	this.name = name;
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
	    this.skillList = null;
	    this.equipmentList = null;
	    this.inventory = null;
    }
     
    public Player(String name, String job, int level, int maxExperience, int experience, int maxHp, int hp,
            int maxMp, int mp, int strength, int intelligence, int agility, int money,
            ArrayList<Skill> skillList, ArrayList<Equipment> equipmentList, ArrayList<Item> inventory) {
        this.name = name;
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
        this.skillList = skillList;
        this.equipmentList = equipmentList;
        this.inventory = inventory;
    }
    
    public Player(int playerNo, String name, String job, int level, int maxExperience, int experience, int maxHp, int hp,
            int maxMp, int mp, int strength, int intelligence, int agility, int money,
            ArrayList<Skill> skillList, ArrayList<Equipment> equipmentList, ArrayList<Item> inventory) {
        this.playerNo = playerNo;
    	this.name = name;
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
        this.skillList = skillList;
        this.equipmentList = equipmentList;
        this.inventory = inventory;
    }
   
	// getter setter
    
    
	public String getName() {
		return name;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public void setName(String name) {
		this.name = name;
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

	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(ArrayList<Skill> skillList) {
		this.skillList = skillList;
	}

	public ArrayList<Equipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(ArrayList<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 인벤토리 추가 메서드
	public ArrayList<Item> addInven(Item item) {
    	this.inventory.add(item);
    	return this.inventory;
    }

	// 인벤토리 삭제 메서드
    public ArrayList<Item> removeInven(Item item) {
    	this.inventory.remove(item);
    	return this.inventory;
    }

    // 장비 착용 메서드
    public ArrayList<Equipment> equip(Equipment item){
    	this.equipmentList.add(item);
    	this.inventory.remove(item);
    	// 능력치 추가
    	return this.equipmentList;
    }

	// 장비 탈착 메서드
    public ArrayList<Equipment> unequip(Equipment item) {
    	this.equipmentList.remove(item);
    	this.inventory.add(item);
    	// 능력치 감소
    	return this.equipmentList;
    }
    
    // 공격 메서드
    public int attack(Enemy e) {
        // 피해량 초기값 설정
        int damage = 0;
        // 피해량 계산 (여기서는 힘 속성을 기준으로 간단히 계산)
        // 예시로 힘 속성이 피해량에 미치는 영향을 두 배로 가정
        // 피해량 적용 (상대의 체력에서 피해량을 빼줌)
        if (this.agility > e.getAgility()){
        	damage = this.strength * 2;
        	e.decreaseHealth(damage);
        	// 실제로 입힌 피해량 반환
        }
        else {
        	e.decreaseHealth(damage);
        }
        return damage;
    }
    
    // 체력 감소 메서드 (실제로 구현해야 함)
    public int decreaseHealth(int damage) {
    	this.hp -= damage;
    	return hp;
    }
    
    
    // 몬스터 처치 시 메소드
    public void gainExperience(int experience) {
        this.experience += experience;
        if (experience >= maxExperience) {
        	this.levelUp();
        }
    }

    // 돈 획득 메소드
    public void gainMoney(int money) {
        this.money += money;
    }

    // 아이템을 인벤토리에 추가하는 메소드 (추상적인 메소드)
    public void addToInventory(Item item) {
        // 인벤토리에 아이템을 추가하는 구체적인 구현은 각각의 캐릭터 클래스에서 직접 구현해야 합니다.
    }

    // 몬스터를 처치하여 경험치, 돈, 아이템을 얻는 메소드
    public void defeatEnemy(Enemy e) {
        // 경험치 획득
        gainExperience(e.getExperience());

        // 돈 획득
        gainMoney(e.dropMoney());

        // 아이템 획득
        if (e.dropItem() != null) {
            addToInventory(e.dropItem());
        }
    }
    // 사망 메소드
    public boolean isDefeated() {
		boolean isTrue = false;
		
		if(this.hp < 0) {
			isTrue = true;
		}
		
		return isTrue;
	}
    
    // 레벨업 메소드
    public void levelUp() {
            // 현재 경험치가 다음 레벨에 필요한 최대 경험치 이상인 경우에만 레벨업 가능
            this.level++; // 레벨 증가
            this.experience -= this.maxExperience; // 현재 경험치에서 최대 경험치만큼 차감
            this.upgradeAbility();
            this.maxExperience = calculateMaxExperience(); // 다음 레벨까지 필요한 최대 경험치 계산
            // 레벨업 후에는 특정한 스탯을 증가시키거나 추가적인 보상을 제공할 수 있습니다.
            // 여기서는 간단히 레벨업 메시지만 출력하도록 하겠습니다.
            System.out.println("레벨업! 레벨 " + this.level + " 달성!");
    }
    
    //레벨업 시 능력 증가 메소드
    public void upgradeAbility() {
    	System.out.println(this.showAbility());
    	System.out.println("5개의 스탯 포인트를 분배해주세요.");
    	int num, hpnum = 0, mpnum = 0, snum = 0, inum = 0 , anum = 0;
    	num = 5;
    	
    	while(num == 0) {
	    	System.out.print("최대 hp : ");
	    	hpnum = sc.nextInt();
	    	sc.nextLine();
	    	num += hpnum;
	    	System.out.print("최대 mp : ");
	    	mpnum = sc.nextInt();
	    	sc.nextLine();
	    	num += mpnum;
	    	System.out.print("힘 : ");
	    	snum = sc.nextInt();
	    	sc.nextLine();
	    	num += snum;
	    	System.out.print("지능 : ");
	    	inum = sc.nextInt();
	    	sc.nextInt();
	    	num += inum;
	    	System.out.print("민첩성 : ");
	    	anum = sc.nextInt();
	    	sc.nextInt();
	    	num += anum;
	    	
	    	if(num != 0) {
	    		System.out.println("잘못 분배하셨습니다. 다시 분배해주세요.");
	    		num = 5;
	    	}
    	}
    	
    	this.maxHp += hpnum;
    	this.maxMp += mpnum;
    	this.strength += snum;
    	this.intelligence += inum;
    	this.agility += anum;
    }

    // 다음 레벨까지 필요한 최대 경험치 계산 메소드
    private int calculateMaxExperience() {
        // 여기서는 단순히 레벨에 비례하여 필요 경험치를 계산하도록 하겠습니다.
        // 더 복잡한 레벨업 로직이 필요하다면 이 메소드를 수정해야 합니다.
        return this.level * 100; // 간단한 예시: 현재 레벨 * 100
    }
    
    // 정보 확인 메소드
  
    public String showinfo() {
    	return "레벨 : " + this.level + ", " + 
    			"직업 : " + this.job + ", " + 
    			"필요 경험치 :" + this.maxExperience + ", " + 
    			"현재 경험치 : " + this.experience + ", " + 
    			
    			this.showAbility() + ", " +
    			
    			"현재 hp : " + this.hp +", " + 
    			"현재 mp : " + this.mp +", " + 
    			
    			"보유 금액 : " + this.money;
    }
    
    public String showAbility(){
    	return "최대 hp: " + this.maxHp + ", " + 
    			"최대 mp: " + this.maxMp + ", " +
    			"힘 : " + this.strength + ", " + 
    			"지능 : " + this.intelligence + ", " + 
    			"민첩성 : " + this.agility;
    }
    
    public ArrayList<Skill> showSkill() {
    	return this.skillList;
    }
    
    public ArrayList<Equipment> showEquip(){
    	return this.equipmentList;
    }
    
    public ArrayList<Item> showInven(){
    	return this.inventory;
    }
    
    // 
    
    
}
