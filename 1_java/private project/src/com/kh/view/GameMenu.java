package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.GameController;
import com.kh.model.vo.Map;

public class GameMenu {
    private Scanner sc = new Scanner(System.in);
    private GameController gc = new GameController();
    
    public void mainMenu() {
        while (true) {
            System.out.println("========== 시작 메뉴 ============");
            System.out.println("1. 관리자 모드");
            System.out.println("2. 플레이어 모드");
            System.out.println("0. 종료");
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
                    System.out.println("이용해주셔서 감사합니다. 다음에 또 방문해주세요.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    
    
    //======================================== 관리자 메소드 ==================================================
    
    public void adminMenu() {
    	while(true) {
	    	System.out.println("======== 관리자 모드 =========");
	        System.out.println("1. 생성 모드");
	        System.out.println("2. 수정 모드");
	        System.out.println("3. 삭제 모드");
	        System.out.println("0. 메인 메뉴로 돌아가기");
	        System.out.print("메뉴 입력 : ");
	        int menu = sc.nextInt();
	        sc.nextLine();
	        switch(menu) {
	        case 1:
	        	this.adminCreateMenu();
	        	break;
	        case 2:
	        	
	        	break;
	        case 3:
	        	this.adminDeleteMenu();
	        	break;
	        case 0:
	        	System.out.println("메인 메뉴로 돌아갑니다.");
	        	return;
	        default:
	        	System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
	        }
    	}
    }
    
    public void adminCreateMenu() {
        while (true) {
            System.out.println("======== 생성 모드 =========");
            System.out.println("1. 캐릭터 생성");
            System.out.println("2. 몬스터 생성");
            System.out.println("3. 스킬 생성");
            System.out.println("4. 아이템 생성");
            System.out.println("5. 맵 생성");
            System.out.println("0. 뒤로 가기");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    gc.createPlayer();
                    break;
                case 2:
                    gc.createEnemy();
                    break;
                case 3:
                    gc.createSkill();
                    break;
                case 4:
                    gc.createItem();
                    break;
                case 5:
                    this.mapMenu();
                    break;
                case 0:
                	System.out.println("시작메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
    }

    public void adminUpdateMenu() {
    	
    }
    
    public void adminDeleteMenu() {
    	while(true) {
	    	System.out.println("======== 삭제 모드 =========");
	        System.out.println("1. 캐릭터 삭제");
	        System.out.println("2. 몬스터 삭제");
	        System.out.println("3. 스킬 삭제");
	        System.out.println("4. 아이템 삭제");
	        System.out.println("5. 맵 삭제");
	        System.out.println("0. 관리자 메뉴로 돌아가기");
	        System.out.print("메뉴 입력 : ");
	        int menu = sc.nextInt();
	        sc.nextLine();
	        switch(menu) {
	        case 1:
	        	System.out.println("=== 캐릭터 삭제 === ");
	        	gc.showInfo();
	        	System.out.println("삭제할 캐릭터명 : ");
	        	String pname = sc.nextLine();
	        	gc.deletePlayer(pname);
	        	break;
	        case 2:
	        	System.out.println("=== 몬스터 삭제 === ");
	        	gc.showEnemyList();
	        	System.out.println("삭제할 몬스터명 : ");
	        	String ename = sc.nextLine();
	        	gc.deletePlayer(ename);
	        	break;
	        case 3:
	        	break;
	        case 4:
	        	break;
	        case 5:
	        	System.out.println("=== 맵 삭제 === ");
	        	gc.selectMapList();
	        	System.out.println("삭제할 맵 이름 : ");
	        	String mname = sc.nextLine();
	        	gc.deletePlayer(mname);
	        	break;
	        case 0:
	        	System.out.println("관리자 메뉴로 돌아갑니다.");
	        	return;
	        default :
	        	System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
	        }
    	}
    }

    // ======================================== 플레이어 메소드 ===========================================
    
    public void playerMenu() {
        System.out.println("=========== 플레이어 모드 ==============");
        System.out.println("1. 게임 시작");
        System.out.println("2. 정보 보기");
        System.out.println("3. 캐릭터 초기화");
        System.out.println("0. 게임 종료");
        System.out.print("메뉴 입력 : ");
        int menu = sc.nextInt();
        sc.nextLine();

        switch (menu) {
            case 1:
                gc.startGame();
                break;
            case 2:
                gc.showInfo();
                break;
            case 3:
                gc.resetCharacter();
                break;
            case 0:
                System.out.println("이용해주셔서 감사합니다. 다음에 또 방문해주세요.");
                return;
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

   
    
    
    
    // --------------- 추가 메소드 -------------------------

    public void mapMenu() {
    	System.out.println("==== 맵 생성 ====");
    	while(true) {
	    	System.out.println("1. 맵 추가하기");
	    	System.out.println("2. 맵에 몬스터 추가하기");
	    	// 맵 조회 후 추가하고 싶은 맵 번호 선택
	    	// 해당 맵의 정보를 받아 몬스터 추가 put 메소드 통해
	    	System.out.println("0. 메인 메뉴로 돌아가기");
	    	System.out.print("메뉴 입력 : ");
	    	int select = sc.nextInt();
	    	sc.nextLine();
	    	switch(select) {
	    	
	    	case 1 : 
	    		gc.createMap();
	    		break;
	    		
	    	case 2 : 
	    		System.out.println("맵 목록을 보여드리겠습니다.");
	    		ArrayList<Map> maps = gc.selectMapList();
	    		System.out.print("몬스터 추가할 맵 번호 선택: ");
	            int mapIndex = sc.nextInt();
	            sc.nextLine();
	            if (mapIndex > 0 && mapIndex <= maps.size()) {
	                Map selectedMap = gc.selectByMapId(mapIndex);
	                if(selectedMap != null) {
	                	gc.putEnemyInMap(selectedMap);
	                }else {
	                	System.out.println("선택된 맵이 없습니다.");
	                }
	            } else {
	                System.out.println("잘못된 맵 번호입니다.");
	            }
	           break;
	           
	    	case 0 : System.out.println("메인 메뉴로 돌아갑니다.");
	    		return;
	    		
	    	default : System.out.println("잘못된 입력입니다. 다시 입력해주세요");
	    	}
    	}
    }
    

   
    
 // ========================================= 응답 화면 ==================================
 	/**
 	 * 서비스 요청 처리 후 성공했을시 사용자가 보게되는 응답 화면
 	 * @param : 객체별 성공 메세지
 	 */
 	public void displaySuccess(String message) {
 		System.out.println("\n서비스 요청 성공 : " + message);
 	}
 	
 	/**
 	 * 서비스 요청 처리 후 성공했을시 사용자가 보게되는 응답 화면
 	 * @param : 객체별 실패 메세지
 	 */
 	public void displayFail(String message) {
 		System.out.println("\n서비스 요청 실패 : " + message);
 	}
 	
 	/**
 	 * 조회서비스 요청시 조회결과가 없을때 사용자가 보게될 응답화면
 	 * @param message : 조회 결과에 대한 응답메세지
 	 */
 	public void displayNoData(String message) {
 		System.out.println("\n" + message);
 	}
 	
 	/**
 	 * 조회서비스 요청시 조회결과가 여러 행일 때 사용자가 보게될 응답화면
 	 * @param list : 조회 결과
 	 */
 	public void displayList(ArrayList<? extends Object> list) {
 	    for (Object obj : list) {
 	        System.out.println(obj);
 	    }
 	}

 	public void displayOne(Object o) {
 		System.out.println("\n조회된 데이터는 다음과 같습니다.");
 		System.out.println(o);
 	}
 	
}	
 	
 	
 	
 	
 	
 	