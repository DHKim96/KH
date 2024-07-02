package com.kh.model.vo;

import java.util.Arrays;
import java.util.Random;

public class Enemy {
	private int eId;
	private String name;
    private int health;
    private int strength;
    private int agility;
    private int experience; // 플레이어에게 제공하는 경험치
    private int money; // 플레이어에게 제공하는 돈
    private Item[] items; // 아이템 배열 추가
    // 생성자
    public Enemy() {}
    
    public Enemy(int eId, String name, int health, int strength, int agility, int experience, int money, Item[] items) {
        this.eId = eId;
    	this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.experience = experience;
        this.money = money;
        this.items = items;
    }
    
    public Enemy(String name, int health, int strength, int agility, int experience, int money, Item[] items) {
    	this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.experience = experience;
        this.money = money;
        this.items = items;
    }

    // getter와 setter 메서드 생략
    
    public int getEId() {
		return eId;
	}
    
	public void setEId(int eId) {
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

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}
	
	// 공격 메서드
    public int attack(Player c) {
    	int damage = 0;
        // 피해량 계산 (여기서는 힘 속성을 기준으로 간단히 계산)
        // 예시로 힘 속성이 피해량에 미치는 영향을 두 배로 가정
        // 피해량 적용 (상대의 체력에서 피해량을 빼줌)
        if (this.agility > (c.getAgility() * 0.5) ){
        	damage = this.strength * 2;
        	c.decreaseHealth(damage);
        	// 실제로 입힌 피해량 반환
        }
        else {
        	c.decreaseHealth(damage);
        }
        return damage;
    }
    
    // 피해량 감소 메서드 (캐릭터와 유사한 구현)
    public int decreaseHealth(int damage) {
        this.health -= damage;
        return this.health;
    }

    // 아이템 드롭 메서드
    public int dropMoney() {
    	 Random random = new Random();
         double multiplier = random.nextDouble() * 0.7 + 0.5; // 0.5 ~ 1.2 배수의 확률을 위한 랜덤한 배수
         int moneyObtained = (int)(money * multiplier); // 몬스터가 가진 돈에 배수를 곱하여 얻은 돈 계산
         return moneyObtained;
    }
    
    
    public Item dropItem() {
    	if(items == null) {
    		return null;
    	}
    	else {
    		Random random = new Random();
        	
        	int i = random.nextInt(items.length);
        	
        	return items[i];
    	}
    }

	public boolean isDefeated() {
		boolean isTrue = false;
		
		if(this.health < 0) {
			isTrue = true;
		}
		
		return isTrue;
	}

	
	@Override
	public String toString() {
		return "Enemy [eId=" + eId + ", name=" + name + ", health=" + health + ", strength=" + strength + ", agility="
				+ agility + ", experience=" + experience + ", money=" + money + ", items=" + Arrays.toString(items)
				;
	}
    
}
