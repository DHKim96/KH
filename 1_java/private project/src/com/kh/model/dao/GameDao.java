package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Enemy;
import com.kh.model.vo.Item;
import com.kh.model.vo.Map;
import com.kh.model.vo.Player;
import com.kh.model.vo.Skill;

public class GameDao {

	public int insertPlayer(Connection conn, Player p) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO PLAYER VALUES(SEQ_PLAYER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getJob());
			pstmt.setInt(3, p.getLevel());
			pstmt.setInt(4, p.getMaxExperience());
			pstmt.setInt(5, p.getExperience());
			pstmt.setInt(6, p.getMaxHp());
			pstmt.setInt(7, p.getHp());
			pstmt.setInt(8, p.getMaxMp());
			pstmt.setInt(9, p.getMp());
			pstmt.setInt(10, p.getStrength());
			pstmt.setInt(11, p.getIntelligence());
			pstmt.setInt(12, p.getAgility());
			pstmt.setInt(13, p.getMoney());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertMap(Connection conn, Map map) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MAP VALUES(SEQ_MAP.NEXTVAL, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.getMapName());
			pstmt.setString(2, map.getMapType());
			pstmt.setInt(3, map.getRequriedLevel());
			pstmt.setString(4, map.getMapInfo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertEnemy(Connection conn, Enemy en) {
	    int result = 0;
	    PreparedStatement pstmt = null;
	    String sql = "INSERT INTO ENEMY VALUES(SEQ_ENEMY.NEXTVAL, ?, ?, ?, ?, ?, ?)";

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, en.getName());
	        pstmt.setInt(2, en.getHealth());
	        pstmt.setInt(3, en.getStrength());
	        pstmt.setInt(4, en.getAgility());
	        pstmt.setInt(5, en.getExperience());
	        pstmt.setInt(6, en.getMoney());

	        result = pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCTemplate.close(pstmt);
	    }
	    return result;
	}

	public int insertSkill(Connection conn, Skill skill) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MAP VALUES(SEQ_SKILL.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skill.getName());
			pstmt.setString(2, skill.getType());
			pstmt.setInt(3, skill.getPower());
			pstmt.setInt(4, skill.getRequiredLevel());
			pstmt.setInt(5, skill.getRequiredInt());
			pstmt.setInt(6, skill.getReduceMp());
			pstmt.setInt(7, skill.getPlayerId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int insertItem(Connection conn, Item item) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MAP VALUES(SEQ_ITEM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getType());
			pstmt.setString(2, item.getName());
			pstmt.setInt(3, item.getPrice());
			pstmt.setString(4, item.getInfo());
			pstmt.setInt(5, item.getPlayerId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int insertMap_Enemy(Connection conn, int num1, int num2) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MAP_ENEMY VALUES (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num1);
			pstmt.setInt(2, num2);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//=================================================
	
	public Map selectByMapId(Connection conn, int mapId) {
		Map m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MAP WHERE MAP_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mapId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Map();
				m.setMapId(rset.getInt("MAP_ID"));
				m.setMapName(rset.getString("MAP_NAME"));
				m.setMapType(rset.getString("MAP_TYPE"));
				m.setRequriedLevel(rset.getInt("REQUIRED_LEVEL"));
				m.setMapInfo(rset.getString("MAP_INFO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public Player selectByPlayerName(Connection conn, String playerName) {
		Player player = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM PLAYER WHERE PLAYER_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, playerName);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				player = new Player();
				player.setPlayerNo(rset.getInt("PLAYER_NO"));
				player.setName(rset.getString("PLAYER_NAME"));
				player.setJob(rset.getString("PJOB"));
				player.setLevel(rset.getInt("PLEVEL"));
				player.setMaxExperience(rset.getInt("MAX_EXPERIENCE"));
		        player.setExperience(rset.getInt("EXPERIENCE"));
		        player.setMaxHp(rset.getInt("MAX_HP"));
		        player.setHp(rset.getInt("HP"));
		        player.setMaxMp(rset.getInt("MAX_MP"));
		        player.setMp(rset.getInt("MP"));
		        player.setStrength(rset.getInt("STRENGTH"));
		        player.setIntelligence(rset.getInt("INTELLIGENCE"));
		        player.setAgility(rset.getInt("AGILITY"));
		        player.setMoney(rset.getInt("MONEY"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
	
	public ArrayList<Player> selectPlayerListByPlayerName(Connection conn, String keyword) {
		ArrayList<Player> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM PLAYER WHERE PLAYER_NAME LIKE '%' || ? || '%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Player player = new Player();
				player.setPlayerNo(rset.getInt("PLAYER_NO"));
				player.setName(rset.getString("PLAYER_NAME"));
				player.setJob(rset.getString("PJOB"));
				player.setLevel(rset.getInt("PLEVEL"));
				player.setMaxExperience(rset.getInt("MAX_EXPERIENCE"));
		        player.setExperience(rset.getInt("EXPERIENCE"));
		        player.setMaxHp(rset.getInt("MAX_HP"));
		        player.setHp(rset.getInt("HP"));
		        player.setMaxMp(rset.getInt("MAX_MP"));
		        player.setMp(rset.getInt("MP"));
		        player.setStrength(rset.getInt("STRENGTH"));
		        player.setIntelligence(rset.getInt("INTELLIGENCE"));
		        player.setAgility(rset.getInt("AGILITY"));
		        player.setMoney(rset.getInt("MONEY"));
		        
		        list.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Enemy> selectEnemyList(Connection conn) {
		ArrayList<Enemy> elist = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM ENEMY";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Enemy en = new Enemy();
				en.setEId(rset.getInt("ENEMY_ID"));
				en.setName(rset.getString("ENEMY_NAME"));
				en.setHealth(rset.getInt("HEALTH"));
				en.setStrength(rset.getInt("STRENGTH"));
				en.setAgility(rset.getInt("AGILITY"));
				en.setExperience(rset.getInt("EXPERIENCE"));
				en.setMoney(rset.getInt("MONEY"));
				elist.add(en);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return elist;
	}

	public Enemy selectByEnemyId(Connection conn, int eId) {
		Enemy en = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM ENEMY WHERE ENEMY_ID = ?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, eId);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			en = new Enemy();
			en.setEId(rset.getInt("ENEMY_ID"));
			en.setName(rset.getString("ENEMY_NAME"));
			en.setHealth(rset.getInt("HEALTH"));
			en.setStrength(rset.getInt("STRENGTH"));
			en.setAgility(rset.getInt("AGILITY"));
			en.setExperience(rset.getInt("EXPERIENCE"));
			en.setMoney(rset.getInt("MONEY"));
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return en;
	}

	public ArrayList<Map> selectMapList(Connection conn) {
		ArrayList<Map> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MAP";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Map m = new Map();
				m.setMapId(rset.getInt("MAP_ID"));
				m.setMapName(rset.getString("MAP_NAME"));
				m.setMapType(rset.getString("MAP_TYPE"));
				m.setRequriedLevel(rset.getInt("REQUIRED_LEVEL"));
				m.setMapInfo(rset.getString("MAP_INFO"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
	
		return list;
	}

	public ArrayList<Enemy> selectEnemyByMapId(Connection conn, int mapId) {
		ArrayList<Enemy> list = new ArrayList<>();
		Enemy en = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = 
					"SELECT ENEMY_ID, ENEMY_NAME, HEALTH, STRENGTH, AGILITY, EXPERIENCE, MONEY "
					+ "FROM MAP_ENEMY "
					+ "JOIN ENEMY USING (ENEMY_ID) "
					+ "WHERE MAP_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mapId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				en = new Enemy();
				en.setEId(rset.getInt("ENEMY_ID"));
				en.setName(rset.getString("ENEMY_NAME"));
				en.setHealth(rset.getInt("HEALTH"));
				en.setStrength(rset.getInt("STRENGTH"));
				en.setAgility(rset.getInt("AGILITY"));
				en.setExperience(rset.getInt("EXPERIENCE"));
				en.setMoney(rset.getInt("MONEY"));
				list.add(en);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Enemy selectByEnemyName(Connection conn, String name) {
		Enemy en = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM ENEMY WHERE ENEMY_NAME = ?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			en = new Enemy();
			en.setEId(rset.getInt("ENEMY_ID"));
			en.setName(rset.getString("ENEMY_NAME"));
			en.setHealth(rset.getInt("HEALTH"));
			en.setStrength(rset.getInt("STRENGTH"));
			en.setAgility(rset.getInt("AGILITY"));
			en.setExperience(rset.getInt("EXPERIENCE"));
			en.setMoney(rset.getInt("MONEY"));
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return en;
	}


	//===================================================
	public int deletePlayer(Connection conn, String playerName) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM PLAYER WHERE PLAYER_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, playerName);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteEnemy(Connection conn, String enemyName) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM ENEMY WHERE ENEMY_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, enemyName);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMap(Connection conn, String mapName) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MAP WHERE MAP_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mapName);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	



	
}
