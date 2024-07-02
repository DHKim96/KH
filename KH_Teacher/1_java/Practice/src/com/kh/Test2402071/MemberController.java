package com.kh.Test2402071;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {
	HashMap map = new HashMap();
	
	public boolean joinMembership(String id, Member m) {
		if (!map.containsKey(id)) {// ! 이미 값이 존재한다.
			map.put(id, m);
			return true;
		}
		return false;
	}
	
	public String login(String id, String password) {
		Member m = (Member)map.get(id);
		
		if(m != null) {
			if (m.getPassword().equals(password)) {
				return m.getName();
			}
		}
		
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		Member m = (Member)map.get(id);
		if (m != null && m.getPassword().equals(oldPw)) {
			m.setPassword(newPw);
			return true;
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
		if (map.containsKey(id)) {
			Member m = (Member)map.get(id);
			m.setName(newName);
		}
	}
	
	public TreeMap sameName(String name) {
		TreeMap result = new TreeMap(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for (Object id : map.keySet()) { // [qwe, asd, j1]
			Member m = (Member)map.get(id); 
			if (m.getName().equals(name)) {
				result.put(id, m.getName());
			}
		}
		
		return result;
	}
}
