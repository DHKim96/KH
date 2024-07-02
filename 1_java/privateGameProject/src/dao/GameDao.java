package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import common.JDBCTemplate;
import vo.Enemy;
import vo.Maps;
import vo.Player;

public class GameDao {

	private Properties prop = new Properties();

	public GameDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int insertPlayer(Connection conn, Player p) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertPlayers");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getpName());
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

	public int insertEnemy(Connection conn, Enemy en) {
		int result = 0;
	    PreparedStatement pstmt = null;
	    String sql = prop.getProperty("insertEnemies");

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

	public int insertMap(Connection conn, Maps m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMaps");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMapName());
			pstmt.setString(2, m.getMapType());
			pstmt.setInt(3, m.getRequiredLevel());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int insertMaps_Enemies(Connection conn, Maps m, Enemy en) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MAPS_ENEMIES VALUES(? , ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMapId());
			pstmt.setInt(2, en.geteId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Player selectPlayer(Connection conn, int id) {
		Player p = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM PLAYERS WHERE PLAYER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			
			
			
			if(rset.next()) {
				p = new Player();
				
				p.setpNo(rset.getInt("PLAYER_ID"));
				p.setpName(rset.getString("PLAYER_NAME"));
				p.setJob(rset.getString("PJOB"));
				p.setLevel(rset.getInt("PLEVEL"));
				p.setMaxExperience(rset.getInt("MAX_EXPERIENCE"));
		        p.setExperience(rset.getInt("EXPERIENCE"));
		        p.setMaxHp(rset.getInt("MAX_HP"));
		        p.setHp(rset.getInt("HP"));
		        p.setMaxMp(rset.getInt("MAX_MP"));
		        p.setMp(rset.getInt("MP"));
		        p.setStrength(rset.getInt("STRENGTH"));
		        p.setIntelligence(rset.getInt("INTELLIGENCE"));
		        p.setAgility(rset.getInt("AGILITY"));
		        p.setMoney(rset.getInt("MONEY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}
	
	public Enemy selectEnemy(Connection conn, int id) {
		Enemy en = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM ENEMIES WHERE ENEMY_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				en = new Enemy();
				en.seteId(rset.getInt("ENEMY_ID"));
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
	
	public Maps selectMap(Connection conn, int id) {
		Maps m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MAPS WHERE MAP_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Maps();
				m.setMapId(rset.getInt("MAP_ID"));
				m.setMapName(rset.getString("MAP_NAME"));
				m.setMapType(rset.getString("MAP_TYPE"));
				m.setRequiredLevel(rset.getInt("REQUIRED_LEVEL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	
	public ArrayList<Player> selectPlayers(Connection conn) {
		ArrayList<Player> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPlayers");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Player player = new Player();
				
				player.setpNo(rset.getInt("PLAYER_ID"));
				player.setpName(rset.getString("PLAYER_NAME"));
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

	public ArrayList<Maps> selectMaps(Connection conn) {
		ArrayList<Maps> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MAPS";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Maps m = new Maps();
				
				m.setMapId(rset.getInt("MAP_ID"));
				m.setMapName(rset.getString("MAP_NAME"));
				m.setMapType(rset.getString("MAP_TYPE"));
				m.setRequiredLevel(rset.getInt("REQUIRED_LEVEL"));
				
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

	
	public ArrayList<Enemy> selectEnemies(Connection conn) {
		ArrayList<Enemy> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM ENEMIES";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Enemy en = new Enemy();
				en.seteId(rset.getInt("ENEMY_ID"));
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

	public ArrayList<Enemy> selectEnemiesFromMaps_Enemies(Connection conn, Maps m) {
		ArrayList<Enemy> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT ENEMY_ID, ENEMY_NAME, HEALTH, STRENGTH, AGILITY, EXPERIENCE, MONEY "
				+ "FROM MAPS_ENEMIES "
				+ "JOIN ENEMIES USING (ENEMY_ID)"
				+ "WHERE MAP_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMapId());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Enemy en = new Enemy();
				en.seteId(rset.getInt("ENEMY_ID"));
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
	
	public int updatePlayer(Connection conn, Player p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePlayers");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getJob());
			pstmt.setInt(2, p.getLevel());
			pstmt.setInt(3, p.getMaxExperience());
			pstmt.setInt(4, p.getExperience());
			pstmt.setInt(5, p.getMaxHp());
			pstmt.setInt(6, p.getHp());
			pstmt.setInt(7, p.getMaxMp());
			pstmt.setInt(8, p.getMp());
			pstmt.setInt(9, p.getStrength());
			pstmt.setInt(10, p.getIntelligence());
			pstmt.setInt(11, p.getAgility());
			pstmt.setInt(12, p.getMoney());
			pstmt.setString(13, p.getpName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateEnemy(Connection conn, Enemy en) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateEnemies");
		try {
			pstmt = conn.prepareStatement(sql);
			
	        pstmt.setInt(1, en.getHealth());
	        pstmt.setInt(2, en.getStrength());
	        pstmt.setInt(3, en.getAgility());
	        pstmt.setInt(4, en.getExperience());
	        pstmt.setInt(5, en.getMoney());
	        pstmt.setString(6, en.getName());

	        result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMap(Connection conn, Maps m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMaps");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMapType());
			pstmt.setInt(2, m.getRequiredLevel());
			pstmt.setString(3, m.getMapName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deletePlayer(Connection conn, String name) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM PLAYERS WHERE PLAYER_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteEnemy(Connection conn, String name) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM ENEMIES WHERE ENEMY_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
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
		
		String sql = "DELETE FROM MAPS WHERE MAP_NAME = ?";
		
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
