package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.GameDao;
import com.kh.model.vo.Enemy;
import com.kh.model.vo.Item;
import com.kh.model.vo.Map;
import com.kh.model.vo.Player;
import com.kh.model.vo.Skill;

public class GameService {
	
	
	public int insertPlayer(Player p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertPlayer(conn, p);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertEnemy(Enemy enemy) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertEnemy(conn, enemy);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertSkill(Skill skill) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertSkill(conn, skill);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertItem(Item item) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertItem(conn, item);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertMap(Map map) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertMap(conn, map);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertMap_Enemy(int num1, int num2) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertMap_Enemy(conn, num1, num2);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	public Map selectByMapId(int mapId) {
		Connection conn = JDBCTemplate.getConnection();
		Map m = new GameDao().selectByMapId(conn, mapId);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public Player selectByPlayerName(String playerName) {
		Connection conn = JDBCTemplate.getConnection();
		
		Player p = new GameDao().selectByPlayerName(conn, playerName);
		
		JDBCTemplate.close(conn);
		
		return p;
	}

	public ArrayList<Enemy> selectEnemyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Enemy> elist = new GameDao().selectEnemyList(conn);
		
		JDBCTemplate.close(conn);
		
		return elist;
	}

	public Enemy selectByEnemyId(int eId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Enemy e = new GameDao().selectByEnemyId(conn, eId);
		
		JDBCTemplate.close(conn);
		
		return e;
	}

	public ArrayList<Player> selectPlayerListByPlayerName(String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Player> list = new GameDao().selectPlayerListByPlayerName(conn, keyword);
	
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Map> selectMapList() {
		Connection conn = JDBCTemplate.getConnection();
	
		ArrayList<Map> list = new GameDao().selectMapList(conn);
	
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Enemy> selectEnemyByMapId(int mapId) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Enemy> list = new GameDao().selectEnemyByMapId(conn, mapId);
	
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public Enemy selectByEnemyName(String name) {
		Connection conn = JDBCTemplate.getConnection();
		
		Enemy e = new GameDao().selectByEnemyName(conn, name);
		
		JDBCTemplate.close(conn);
		
		return e;
	}
	
	
	
	public int deletePlayer(String playerName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().deletePlayer(conn, playerName);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteEnemy(String enemyName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().deleteEnemy(conn, enemyName);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	public int deleteMap(String mapName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().deleteMap(conn, mapName);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	


	
	



	
}
