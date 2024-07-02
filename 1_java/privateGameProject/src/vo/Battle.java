package vo;

import java.util.ArrayList;
import java.util.Random;

import controller.GameController;

public class Battle {
	private GameController gc = new GameController();
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private Player player =  new Player();
	
	public Battle() {}
	
	public Battle(ArrayList<Enemy> enemies, Player player) {
		super();
		this.enemies = enemies;
		this.player = player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * 플레이어와 적이 싸우는 메소드
	 */
	public void startBattle() {
        System.out.println("전투가 시작되었습니다!");
        Random random = new Random();
        int randomIndex = random.nextInt(this.enemies.size()); 
        while(true) {
        	// 랜덤한 적들이 등장
        	Enemy enemy = this.enemies.get(randomIndex);
        	this.beforeBattleMessage(enemy);
        	while (enemy.getHealth() > 0 && player.getHp() > 0) {
        		// 플레이어와 적이 서로 공격
        		System.out.println();
        		this.playerAttack(enemy);
        		System.out.println();
        		if(enemy.getHealth() > 0) {
        			this.enemyAttack(enemy);
        		}
        	}
        	if(player.getHp() <= 0) {
        		System.out.println("플레이어가 전투에서 패배했습니다!");
        		// 전투 패배 시 패널티 등록
        		return;
        	}else {
        		System.out.println();
               this.saveExpAndMoney(player, enemy);
               System.out.println();
               this.afterBattleMessage(enemy);
               return;
        	}
        }
	}
	
	
	// 싸움 전 메세지
	public void beforeBattleMessage(Enemy enemy) {
		System.out.println(enemy.getName() + "가 나타났다!");
		System.out.println(enemy);
	}
	
	//싸움 후 저장
	public void saveExpAndMoney(Player player, Enemy enemy) {
		player.setExperience(player.getExperience() + enemy.getExperience());
        player.setMoney(player.getMoney() + enemy.getMoney());
        gc.savePlayerInfo(player);
	}
	// 싸움 후 메세지
	public void afterBattleMessage(Enemy e) {
		System.out.println(e.getName() + "를 처치했습니다!");
		System.out.println("싸움이 끝났습니다.");
		System.out.println("======= 전투 후 정산 ======");
		System.out.println("획득한 경험치 : " + e.getExperience());
		System.out.println("획득한 전리품 : " + e.getMoney() + "원");
	}
	
	/**
	 * 플레이어가 적을 공격하는 메소드
	 * @param enemy
	 */
	public void playerAttack(Enemy enemy) {
		Random random = new Random();
		double damageMultiplier = 0.8 + (random.nextDouble() * 0.4); // 0.8에서 1.2 사이의 난수를 생성하여 배수값을 구합니다.
	    int damage = (int) Math.round((player.getStrength() * damageMultiplier)); // 힘에 데미지 배수를 곱하고 반올림합니다.
        System.out.println("플레이어가 " + enemy.getName() + "에게 " + damage + "의 데미지를 입혔습니다!");
        enemy.setHealth(enemy.getHealth() - damage);
	}
	
	/**
	 * 적이 플레이어를 공격하는 메소드
	 * @param enemy
	 */
	public void enemyAttack(Enemy enemy) {
		Random random = new Random();
		double damageMultiplier = 0.8 + (random.nextDouble() * 0.4); // 0.8에서 1.2 사이의 난수를 생성하여 배수값을 구합니다.
	    int damage = (int) Math.round((enemy.getStrength() * damageMultiplier)); // 힘에 데미지 배수를 곱하고 반올림합니다.
        System.out.println("플레이어가 " + player.getpName() + "에게 " + damage + "의 데미지를 입혔습니다!");
        player.setHp(player.getHp() - damage);
	}
	
	
}
