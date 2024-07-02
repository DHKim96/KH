package com.kh.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.vo.Dungeon;
import com.kh.model.vo.Enemy;
import com.kh.model.vo.Equipment;
import com.kh.model.vo.Item;
import com.kh.model.vo.Map;
import com.kh.model.vo.Player;
import com.kh.model.vo.Skill;
import com.kh.service.GameService;
import com.kh.view.GameMenu;

public class GameController {
    private Scanner sc = new Scanner(System.in);
    private Player player;
    private ArrayList<Skill> skillList = new ArrayList<>();
    private ArrayList<Map> mapList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Dungeon> dungeonList = new ArrayList<>();
    
    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(ArrayList<Skill> skillList) {
		this.skillList = skillList;
	}

	public ArrayList<Map> getMapList() {
		return mapList;
	}

	public void setMapList(ArrayList<Map> mapList) {
		this.mapList = mapList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}
	
	//============================= 입력 메소드 =====================================
	
	public Map createMap() {
        System.out.print("맵 이름 : ");
        String mapName = sc.nextLine();
        System.out.print("맵 타입 : ");
        String mapType = sc.nextLine();
        System.out.print("입장 가능 레벨 : ");
        int requiredLevel = sc.nextInt();
        sc.nextLine();
        System.out.print("맵 정보 : ");
        String mapInfo = sc.nextLine();
        // 맵 생성
        Map map = new Map(mapName, mapType, requiredLevel, mapInfo);
        int result = new GameService().insertMap(map);
        
        if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 맵이 추가됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("맵 추가에 실패했습니다.");
			
		}
        return map;
	}

    public void createItem() {
        System.out.print("아이템 종류 : ");
        String itemType = sc.nextLine();
        System.out.print("아이템 이름 : ");
        String itemName = sc.nextLine();
        System.out.print("아이템 가격 : ");
        int itemPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("아이템 정보 : ");
        String itemInfo = sc.nextLine();

        Item item = new Item(itemType, itemName, itemPrice, itemInfo);
        int result = new GameService().insertItem(item);
        
        if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 스킬이 추가됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("스킬 추가에 실패했습니다.");
		}	
    }

    public void createSkill() {
        System.out.print("스킬 이름 : ");
        String skillName = sc.nextLine();
        System.out.print("스킬 종류 : ");
        String skillType = sc.nextLine();
        System.out.print("스킬 효과 : ");
        int power = sc.nextInt();
        sc.nextLine();
        System.out.print("사용 가능 레벨 : ");
        int requiredLevel = sc.nextInt();
        sc.nextLine();
        System.out.print("사용 가능 지능 : ");
        int requiredInt = sc.nextInt();
        sc.nextLine();
        System.out.print("mp 소모량 : ");
        int reduceMp = sc.nextInt();
        sc.nextLine();

        Skill skill = new Skill(skillName, skillType, power, requiredLevel, requiredInt, reduceMp);
        
        int result = new GameService().insertSkill(skill);
        
        if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 스킬이 추가됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("스킬 추가에 실패했습니다.");
			
		}
    }

    public void createEnemy() {
    	int num = 0;
    	int[] mapids = new int[100];
        System.out.println("========== 몬스터 추가 ==========");
        System.out.print("몬스터 이름: ");
        String name = sc.nextLine();
        System.out.print("몬스터 체력: ");
        int health = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 힘: ");
        int strength = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 민첩성: ");
        int agility = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 경험치: ");
        int experience = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 보상 돈: ");
        int money = sc.nextInt();
        sc.nextLine();
        this.selectMapList();
        while(true) {
	        System.out.print("출몰하는 맵 번호: ");
	        int mapId = sc.nextInt();
	        sc.nextLine();
	        System.out.println("맵 번호를 추가하시겠습니까?(y/n)");
	        char c = sc.next().charAt(0);
	        if(c == 'n') {
	        	break;
	        }
	        mapids[num++] = mapId; // 같은 맵 번호 입력시 예외처리할 것  
        }
        
        
        // 아이템 추가 메소드와 연결하여 몬스터에 드롭할 아이템 배열 생성
        // Item[] items = createItems(); // createItems()는 아이템 추가 메소드를 호출하여 아이템을 생성하여 반환하는 메소드입니다.

        // Enemy 객체 생성 및 리스트에 추가
        Enemy enemy = new Enemy(name, health, strength, agility, experience, money, null); // 아이템 배열 추가
        
        int result = new GameService().insertEnemy(enemy);
        
        // enemy 이름으로 id 받아오는 메소드 추가한 후 이를 매핑에 넣자
        
        if (result > 0 ) { // 성공 화면
			int eId = this.selectByEnemyName(name).getEId();
			for(int i = 0; i < mapids.length ; i++) {
		    	   this.insertMap_Enemy(eId, mapids[i]);  
		        }
        	new GameMenu().displaySuccess("성공적으로 몬스터가 추가됐습니다.");
			
        }
		else { // 실패 화면
			new GameMenu().displayFail("몬스터 추가에 실패했습니다.");
        			
	
			// + 몬스터 추가 시 맵 리스트를 보여준 뒤에 넣고 싶은 맵의 번호를 적으면
         	// 해당 mapID들을 Array로 받은 뒤
         	// 몬스터의 ENEMY_ID 와 MAP_ID들을 매핑 테이블에 넣으면 될듯
         	// 그리고 몬스터 추가 시에 던전 타입의 맵에 몬스터를 넣으면서 비로소 던전 클래스를 형성하고 
         	// 같은 종류의 몬스터가 겹치지 않도록 구현할 것
			
		}
    }
    
    public void createPlayer() {
    	System.out.print("캐릭터의 이름을 입력하세요:");
        String name = sc.nextLine();

        System.out.print("캐릭터의 직업을 입력하세요:");
        String job = sc.nextLine();

        System.out.print("캐릭터의 초기 레벨을 입력하세요:");
        int level = sc.nextInt();

        System.out.print("캐릭터의 최대 경험치를 입력하세요:");
        int maxExperience = sc.nextInt();

        System.out.print("캐릭터의 초기 경험치를 입력하세요:");
        int experience = sc.nextInt();

        System.out.print("캐릭터의 최대 체력을 입력하세요:");
        int maxHp = sc.nextInt();

        System.out.print("캐릭터의 초기 체력을 입력하세요:");
        int hp = sc.nextInt();

        System.out.print("캐릭터의 최대 마나를 입력하세요:");
        int maxMp = sc.nextInt();

        System.out.print("캐릭터의 초기 마나를 입력하세요:");
        int mp = sc.nextInt();

        System.out.print("캐릭터의 힘을 입력하세요:");
        int strength = sc.nextInt();

        System.out.print("캐릭터의 지능을 입력하세요:");
        int intelligence = sc.nextInt();

        System.out.print("캐릭터의 민첩성을 입력하세요:");
        int agility = sc.nextInt();

        System.out.print("캐릭터의 초기 소지금을 입력하세요:");
        int money = sc.nextInt();

        // 캐릭터 객체 생성
        Player player = new Player(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp,
                strength, intelligence, agility, money, new ArrayList<Skill>(), new ArrayList<Equipment>(), new ArrayList<Item>());
        // 캐릭터 객체 반환
        
        int result = new GameService().insertPlayer(player);
        
    	if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 캐릭터가 추가됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("캐릭터 추가에 실패했습니다.");
		}
        
    }
    
    public void insertMap_Enemy(int num1, int num2) {
    	int result = new GameService().insertMap_Enemy(num1, num2);
    	if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 매핑됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("매핑에 실패했습니다.");
		}
    }
    
    // =============================== 조회 메소드 ===========================================
    public void showEnemyList() {
        System.out.println("========== 몬스터 목록 ==========");
        ArrayList<Enemy> elist = new GameService().selectEnemyList();
        if(elist.isEmpty()) { // list 비어있을 경우
			new GameMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new GameMenu().displayList(elist);
		}
	}
    
    public Enemy selectByEnemyId(int eId) {
    	Enemy e = new GameService().selectByEnemyId(eId);
    	if (e == null ) {
			new GameMenu().displayNoData(eId + "에 해당하는 조회 결과가 없습니다.");
		}
		else {
			new GameMenu().displayOne(e);
		}
    	return e;
    }
 
    public ArrayList<Map> selectMapList() {
    	ArrayList<Map> list = new GameService().selectMapList();
    	if(list.isEmpty()) { // list 비어있을 경우
			new GameMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new GameMenu().displayList(list);
		}
    	return list;
	}
    
    public void selectByPlayerName(String keyword) {
    	ArrayList<Player> list = new GameService().selectPlayerListByPlayerName(keyword);
		
		if(list.isEmpty()) {
			new GameMenu().displayFail(keyword + "에 해당하는 검색 결과가 없습니다.");
		}
		else {
			new GameMenu().displayList(list);
		}
    }
       
    public Map selectByMapId(int mapId) {
    	 Map m = new GameService().selectByMapId(mapId);
    	 
    	 if (m == null ) {
 			new GameMenu().displayNoData(mapId + "에 해당하는 조회 결과가 없습니다.");
 		}
 		else {
 			new GameMenu().displayOne(m);
 		}
    	 
    	 return m;
     }
 
    public ArrayList<Enemy> selectEnemyByMapId(int mapId) {
    	ArrayList<Enemy> list = new GameService().selectEnemyByMapId(mapId);
    	if(list.isEmpty()) { // list 비어있을 경우
			new GameMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new GameMenu().displayList(list);
		}
    	return list;
	}
    
    public Enemy selectByEnemyName(String name) {
    	Enemy e = new GameService().selectByEnemyName(name);
    	
    	if (e == null ) {
			new GameMenu().displayNoData(name + "에 해당하는 조회 결과가 없습니다.");
		}
		else {
			new GameMenu().displayOne(e);
		}
    	return e;
    }
    
    //=================================== 삭제 메소드 ===========================
     
    public void deletePlayer(String playerName) {
    	int result = new GameService().deletePlayer(playerName);
    	
    	if(result > 0) {
			new GameMenu().displaySuccess("플레이어 삭제에 성공했습니다");
		}
		else {
			new GameMenu().displayFail("삭제 실패했습니다");
		
		}
    }
     
    public void deleteEnemy(String enemyName) {
    	int result = new GameService().deleteEnemy(enemyName);
    	
    	if(result > 0) {
			new GameMenu().displaySuccess("적 삭제에 성공했습니다");
		}
		else {
			new GameMenu().displayFail("삭제 실패했습니다");
		
		}
    }
    
    public void deleteMap(String mapName) {
    	int result = new GameService().deleteMap(mapName);
    	
    	if(result > 0) {
			new GameMenu().displaySuccess("적 삭제에 성공했습니다");
		}
		else {
			new GameMenu().displayFail("삭제 실패했습니다");
		
		}
    }
    
    
   // =============================== 기타 메소드 ==================================
     
 // 새로 생성할건지 이미 존재하는 캐릭터를 가져올 건지 결정하는 메소드
    public Player beforeGame() {
    	// 새로 생성할건지 이미 존재하는 캐릭터를 가져올 건
    	System.out.println("=== 게임 시작 전 설정 ===");
    	
    	Player player = new Player();
  
    	System.out.println("1. 캐릭터 생성하기");
    	System.out.println("2. 캐릭터 불러오기");
    	System.out.println("메뉴 입력 : ");
    	int menu = sc.nextInt();
    	sc.nextLine();
    	
    	if(menu == 1) {
        	player = new Player(this.inputPlayerName() );
        	System.out.println("캐릭터가 생성됐습니다.");
    	}
    	else{
    		player = new GameService().selectByPlayerName(this.inputPlayerName());
    		System.out.println(player.getName() + "으로 시작합니다.");
    	}
    
    	return player;
    }
    
    /**
     * 캐릭터명을 입력하는 메소드
     * @return 입력받은 캐릭터명을 반환
     */
    public String inputPlayerName() {
    	System.out.println("플레이어의 이름을 입력해주세요");
    	String name = sc.nextLine(); 
    	return name;
    }
    
    // 던전 클래스 생성하는 메소드
    public void putEnemyInMap(Map map) {
        if (map.getMapType().equals("던전")) {
            ArrayList<Enemy> list;
            System.out.println("맵에 몬스터를 추가합니다.");
            list = this.selectEnemyByMapId(map.getMapId());
            Dungeon d = new Dungeon(map.getMapName(), map.getMapType(), map.getRequriedLevel(), map.getMapInfo(), list, player);
            dungeonList.add(d);
            // 매핑 테이블에서 MAPID로 검색해서 나온 결과값들을 리스트에 넣고 해당 리스트를 던전 클래스에 넣을 것
        	
         	// + 몬스터 추가 시 맵 리스트를 보여준 뒤에 넣고 싶은 맵의 번호를 적으면
         	// 해당 mapID들을 Array로 받은 뒤
         	// 몬스터의 ENEMY_ID 와 MAP_ID들을 매핑 테이블에 넣으면 될듯
         	// 그리고 몬스터 추가 시에 던전 타입의 맵에 몬스터를 넣으면서 비로소 던전 클래스를 형성하고 
         	// 같은 종류의 몬스터가 겹치지 않도록 구현할 것
            
        }
    }


	public void showInfo() {
    	System.out.println("확인하고자 하는 플레이어의 이름 검색 : ");
    	String keyword = sc.nextLine();
    	this.selectByPlayerName(keyword);
    }

    public void resetCharacter() {
        // 캐릭터의 정보를 초기화하고 필요한 작업을 수행할 수 있도록 구현해야 합니다.
    }
    
    //============================= 게임 시작 메소드 =====================================
    public void startGame() {
    	
    	Player player = this.beforeGame();
    	
    	this.selectMapList();
    	
    	System.out.println("입장할 맵 번호 입력: ");
    	int select = sc.nextInt();
    	sc.nextLine();
    	Map m = this.selectByMapId(select);
    	
    	if(m.getMapType().equals("던전")) {
    		if(m instanceof Dungeon) {
    			Dungeon d = ((Dungeon)m);
    			d.enter(player);
    		} else {
    			System.out.println("선택된 맵에 몬스터가 없습니다.");
    		}
    	} else {
    		System.out.println("선택된 맵 타입이 던전이 아닙니다.");
    	}
    	
    	
    	
    }
    
}
