package com.kh.Test2402071;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmController {
	private HashMap<Farm, Integer> hMap;
	private ArrayList<Farm> list;
	
	public FarmController() {
		hMap = new HashMap<>();
		list = new ArrayList<>();
	}
	
	public boolean addNewKind(Farm f, int amount) {
		if (!hMap.containsKey(f)) {
			hMap.put(f, amount);
			return true;
		}
		return false;
	}
	
	public boolean removeKind(Farm f) {
		if (hMap.containsKey(f)) {
			hMap.remove(f);
			return true;
		}
		return false;
	}

	public boolean changeAmount(Farm f, int amount) {
		if (hMap.containsKey(f)) {
			hMap.put(f, amount);
			return true;
		}
		return false;
	}

	public HashMap<Farm, Integer> printFarm() {
		return this.hMap;
	}
	
	public boolean buyFarm(Farm f) {
		if(hMap.containsKey(f)) {
			Integer num = hMap.get(f);
			if (num > 0) {
				list.add(f);
				num--;
				return true;
			}
		}
		return false;
	}

	public boolean removeFarm(Farm f) {
		if (list.contains(f)) {
			Integer num = hMap.get(f);
			if (num > 0) {
				list.remove(f);
				num++;
				return true;
			}
		}
		return true;
	}
	
	public ArrayList<Farm> printBuyFarm(){
		return this.list;
	}

	
}
