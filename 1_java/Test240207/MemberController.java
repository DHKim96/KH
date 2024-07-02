package com.kh.Test240207;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {
	private HashMap<String, Member> map;
	
	public MemberController() {
		map = new HashMap<>();
	}
	
	public boolean joinMembership(String id, Member m) {
//		boolean isTrue = false;
		if ( !map.containsKey(id) ) {
			map.put(id, m);
//			isTrue = true;
			return true;
		}
//		return isTrue;
		return false;
	}
	
	public String login(String id, String password) {
//		if (map.containsKey(id)){
//			if ( map.get(id).getPassword().equals(password) ) {
//				return map.get(id).getName();
//			}
//		}
		Member m = (Member)map.get(id);
		
		if(m != null) {
			if (m.getPassword().equals(password)) {
				return m.getName();
			}
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if (map.containsKey(id) && ( map.get(id).getPassword().equals(oldPw) ) ){
			map.get(id).setPassword(newPw);
			return true;
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
//		map.get(id).setName(newName);
		if (map.containsKey(id)) { // 처리 한 번 해준다
			Member m = (Member)map.get(id);
			m.setName(newName);
		}
	}
	
	public TreeMap sameName(String name) {
//		TreeMap tmp = new TreeMap(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
//		if (map.containsValue(name)) {
//			Set mapKeySet = map.keySet();
//			Iterator itMapKey = mapKeySet.iterator();
//			while(itMapKey.hasNext()) {
//				String key = (String)itMapKey.next();
//				Member value = (Member)map.get(key);
//				if (value.getName().equals(name)) {
//					tmp.put(key, name);
//				}
//			}
//		}
//		return tmp;
//	}
		TreeMap result = new TreeMap(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (Object id : map.keySet()) {
			Member m = (Member)map.get(id);
			if (m.getName().equals(name)) {
				result.put(id, m.getName());
			}
		}
		return result;
	}
}
	

