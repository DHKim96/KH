package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GameController;
import vo.Enemy;
import vo.Maps;
import vo.Player;


public class GameMenu {
	private Scanner sc = new Scanner(System.in);
	private GameController gc = new GameController();
	
	
	
	// ============================== 시작 메뉴 ==========================
	public void mainMenu() {
		while (true) {
			System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║                  시작메뉴                ║");
            System.out.println("║             1. 관리자 메뉴                ║");  
            System.out.println("║             2. 플레이어 메뉴              ║");
            System.out.println("║             0. 종료                     ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    this.adminMenu();
                    break;
                case 2:
                    this.playerMenu();
                    break;
                case 0:
                    System.out.println("═══════════════════이용해주셔서 감사합니다. 다음에 또 방문해주세요.═══════════════════");
                    sc.close();
                    return;
                default:
                    System.out.println("! 잘못 입력하셨습니다. 다시 입력해주세요. !");
            }
        }
	}
	
	
	// ==============================관리자 모드================================
	public void adminMenu() {
		while(true) {
			System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║               관리자 메뉴                 ║");
	        System.out.println("║             1. 생성 메뉴                 ║");  
	        System.out.println("║             2. 수정 메뉴                 ║");
	        System.out.println("║             3. 삭제 메뉴                 ║");
	        System.out.println("║             4. 조회 모드                 ║");
	        System.out.println("║             0. 시작 메뉴로 돌아가기         ║");
	        System.out.println("╚════════════════════════════════════════╝");
	        System.out.print("메뉴 입력 : ");
	        int menu = sc.nextInt();
	        sc.nextLine();
	        switch(menu) {
	        case 1:
	        	this.adminInsertMenu();
	        	break;
	        case 2:
	        	this.adminUpdateMenu();
	        	break;
	        case 3:
	        	this.adminDeleteMenu();
	        	break;
	        case 4:
	        	this.adminSelectMenu();
	        	break;
	        case 0:
	        	System.out.println("=======메인 메뉴로 돌아갑니다.=======");
	        	return;
	        default:
	        	System.out.println("!! 잘못 입력하셨습니다. 다시 입력해주세요. !!");
	        }
    	}
	}

	public void adminDeleteMenu() {
		while (true) {
			System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║               삭제 메뉴                  ║");
	        System.out.println("║             1. 플레이어 삭제              ║");  
	        System.out.println("║             2. 적 삭제                   ║");
	        System.out.println("║             3. 맵 삭제                   ║");
	        System.out.println("║             0. 뒤로 가기	                 ║");
	        System.out.println("╚════════════════════════════════════════╝");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    gc.DeletePlayer(this.inputName());
                    break;
                case 2:
                    gc.DeleteEnemy(this.inputName());
                    break;
                case 3:
                    gc.DeleteMap(this.inputName());
                    break;
                case 0:
                	System.out.println("=======관리자 메뉴로 돌아갑니다.=======");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}

	public void adminUpdateMenu() {
		while (true) {
			System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║               수정 메뉴                  ║");
	        System.out.println("║             1. 플레이어 수정              ║");  
	        System.out.println("║             2. 적 수정                   ║");
	        System.out.println("║             3. 맵 수정                   ║");
	        System.out.println("║             0. 뒤로 가기	                 ║");
	        System.out.println("╚════════════════════════════════════════╝");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    this.updatePlayer();
                    break;
                case 2:
                    this.updateEnemy();
                    break;
                case 3:
                    this.updateMap();
                    break;
                case 0:
                	System.out.println("=======관리자 메뉴로 돌아갑니다.=======");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}

	public void adminInsertMenu() {
		while (true) {
			System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║               생성 메뉴                  ║");
	        System.out.println("║             1. 플레이어 생성              ║");  
	        System.out.println("║             2. 적 생성                   ║");
	        System.out.println("║             3. 맵 생성                   ║");
	        System.out.println("║             4. 몬스터를 맵에 추가하기        ║");
	        System.out.println("║             0. 뒤로 가기	                 ║");
	        System.out.println("╚════════════════════════════════════════╝");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    this.createPlayer();
                    break;
                case 2:
                    this.createEnemy();
                    break;
                case 3:
                    this.createMap();
                    break;
                case 4:
                	this.putEnemiesInMaps();
                	break;
                case 0:
                	System.out.println("관리자 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}
	
	public void adminSelectMenu() {
		while (true) {
			System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║               조회 메뉴                  ║");
	        System.out.println("║             1. 플레이어 전체 조회          ║");  
	        System.out.println("║             2. 적 전체 조회               ║");
	        System.out.println("║             3. 맵 전체 조회               ║");
	        System.out.println("║             0. 뒤로 가기	                 ║");
	        System.out.println("╚════════════════════════════════════════╝");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    gc.selectPlayers();
                    break;
                case 2:
                    gc.selectEnemies();
                    break;
                case 3:
                    gc.selectMaps();
                    break;
                case 0:
                	System.out.println("==========관리자 메뉴로 돌아갑니다.========");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}
	
	// ===============================플레이어 모드 ===========================
	
	private void playerMenu() {
		System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║               플레이어 모드               ║");
        System.out.println("║             1. 게임 시작	                 ║");  
        System.out.println("║             2. 전체 캐릭터 정보 조회        ║");
        System.out.println("║             0. 게임 종료                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("메뉴 입력 : ");
        int menu = sc.nextInt();
        sc.nextLine();

        switch (menu) {
            case 1:
            	this.startGame();
                break;
            case 2:
                gc.selectPlayers();
                break;
            case 0:
                System.out.println("════════════════════════════이용해주셔서 감사합니다. 다음에 또 방문해주세요.════════════════════════════");
                return;
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
	}
	
	
	
	public void createPlayer() {
		System.out.println("================= 플레이어 생성 =======================");
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
        
        gc.insertPlayer(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp, strength, intelligence, agility, money);
	}
	
	public void createEnemy() {
		System.out.println("========================== 적 생성 ==============================");
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
        
        gc.insertEnemy(name, health, strength, agility, experience, money);
	}

	public void createMap() {
		System.out.println("=========================== 맵 생성 ===================================");
		System.out.print("맵 이름 : ");
        String mapName = sc.nextLine();
        System.out.print("맵 타입 : ");
        String mapType = sc.nextLine();
        System.out.print("입장 가능 레벨 : ");
        int requiredLevel = sc.nextInt();
        sc.nextLine();
        
        gc.insertMap(mapName, mapType, requiredLevel);
	}
	
	
	public void updatePlayer() {
		System.out.println("======== 플레이어 수정 =========");
		System.out.print("캐릭터의 이름을 입력하세요:");
        String name = sc.nextLine();
        // 있는 이름인지 처리할 것
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
        
        gc.updatePlayer(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp, strength, intelligence, agility, money);
	}
	
	public void updateEnemy() {
		System.out.println("============ 적 수정 ============");
		System.out.print("몬스터 이름: ");
        String name = sc.nextLine();
        //예외처리
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
        
        gc.updateEnemy(name, health, strength, agility, experience, money);
	}
	
	public void updateMap() {
		System.out.println("======== 맵 수정 =========");
		System.out.print("맵 이름 : ");
        String mapName = sc.nextLine();
        System.out.print("맵 타입 : ");
        String mapType = sc.nextLine();
        System.out.print("입장 가능 레벨 : ");
        int requiredLevel = sc.nextInt();
        sc.nextLine();
        
        gc.updateMap(mapName, mapType, requiredLevel);
	}
	
	
	
	
	// ====================== 기타 메소드 ===============
	
	
	//몬스터를 추가하고 싶은 맵을 고르는 메소드
	public void putEnemiesInMaps() {
		System.out.println("====================몬스터를 추가하고 싶은 맵 선택=======================");
		gc.selectMaps();
		System.out.print("맵 번호 : ");
		int mId = sc.nextInt();
		sc.nextLine();
		Maps m = gc.selectMap(mId);
		this.putEnemies(m);
	}
	
	// 맵에 추가하고 싶은 몬스터들을 고르는 메소드
	public void putEnemies(Maps m) {
		System.out.println("================ 맵에 추가하고 싶은 몬스터 선택 ==================");
		Enemy e = null;
		gc.selectEnemies();
		while(true) {
			System.out.print("몬스터의 번호 입력 : ");
			int select = sc.nextInt();
			sc.nextLine();
			e = gc.selectEnemy(select);
			
			gc.insertMaps_Enemies(m, e);
			
			System.out.print("계속 추가하시겠습니까?(y/n) : ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			if(c == 'n') {
				System.out.println("생성 메뉴로 돌아갑니다.");
				return;
			}
		}
	}
	
	
	//플레이할 캐릭터 선택하는 메소드
	public Player selectPlayerByPlayerId(int num){
		Player p = new Player();
		p = gc.selectPlayer(num);
		return p;
	}
	
	public void startGame() {
		Player player = new Player();
		Maps m = new Maps();
		
		System.out.println("===============!! 게임을 시작합니다. !!=======================");
		
		int select = this.selectPlayerIdForPlay();
		
		player = this.selectPlayerByPlayerId(select);
		
		while(true) {
			System.out.println("============== 원하시는 맵에 입장합니다. ==============");
			int mId = this.selectMapIdForPlay();
			m = gc.selectMap(mId);
			System.out.println(m.getMapId() + "에 입장");
			if(m.getMapType().equals("던전")) {
				ArrayList<Enemy> list = new ArrayList<>();
				list = gc.selectEnemiesFromMaps_Enemies(m);
				m.setEnemies(list);
				gc.startDungeon(player, m);
				char c =this.keepFightOrRunaway();
				if(c == 'n') {
					break;
				}
			}else {
				System.out.println("이 맵은 던전이 아닙니다.");
			}
		}
	}
	
	
	// ====================
	public char keepFightOrRunaway() {
		System.out.print("계속 사냥하시겠습니까?(y/n)");
		char c = sc.next().charAt(0);
		return c;
	}
	
	
	//레벨업 시 증가할 스탯 정하는 메소드
	public void levelUp(Player p) {
		int num = this.levelUpMessage(p);
		for(int i = 0; i < 5 ; i++) {
			switch(num) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default :
				System.out.println("잘못된 숫자입니다. 다시 입력해주세요");
				i--;
			}
		}
		
		
	}
	
	//레벨업 시 표시할 메세지 & 올릴 스탯 항목을 리턴
	private int levelUpMessage(Player p) {
		int select = 0;
		System.out.println("===========업그레이드할 스탯==========");
		System.out.println("현재 최대Hp : " + p.getMaxHp());
		System.out.println("현재 최대Mp : " + p.getMaxMp());
		System.out.println("현재 힘 : " + p.getStrength());
		System.out.println("현재 지능 : " + p.getIntelligence());
		System.out.println("현재 민첩 : " + p.getAgility());
		
		System.out.println("향상시킬 스탯 ");
		System.out.println("1. HP / 2.MP / 3.힘 / 4.지능 / 5.민첩");
		System.out.print("번호 입력 : ");
		select = sc.nextInt();
		sc.nextLine();
		return select;
	}
	
	//================== 응답 화면 =================
	
	
	
	public int selectMapIdForPlay() {
		System.out.println("========== 입장할 맵을 선택해주세요 =========");
		gc.selectMaps();
		System.out.print("맵 번호 입력 : ");
		int select = sc.nextInt();
		sc.nextLine();
		return select;
	}

	
	public int selectPlayerIdForPlay() {
		System.out.println("======= 플레이할 플레이어를 선택해주세요.========");
		gc.selectPlayers();
		System.out.print("플레이어 번호 입력 : ");
		int select = sc.nextInt();
		sc.nextLine();
		return select;
	}
	
	
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}


	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}

	public void displayNoData(String message) {
 		System.out.println("\n" + message);
 	}
	
	public void displayList(ArrayList<? extends Object> list) {
 	    for (Object obj : list) {
 	        System.out.println(obj);
 	    }
 	}
	
	public void displayOne(Object o) {
 		System.out.println("\n조회된 데이터는 다음과 같습니다.");
 		System.out.println(o);
 	}
	
	public String inputName() {
		System.out.println("조회/수정/삭제 하고자 하는 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		return name;
	}
	
	
	
	
	
	
	
	
}
