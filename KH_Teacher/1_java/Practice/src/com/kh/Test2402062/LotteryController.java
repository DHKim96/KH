package com.kh.Test2402062;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<>();
	private HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		boolean isRemove = lottery.remove(l);
		if (isRemove && win != null) {
			win.remove(l);
		}
		
		return isRemove;
	}
	
	public HashSet<Lottery> winObject(){
		
		if (lottery.size() < 4) {
			return null;
		}
		
		List<Lottery> list = new ArrayList<Lottery>(lottery);
		
		while(win.size() < 4) {
			int rand = (int)(Math.random() * list.size());
			win.add(list.get(rand));
		}
		
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject(){
		TreeSet<Lottery> sortedWinSet = new TreeSet<>(new SortedLottery());
		sortedWinSet.addAll(win);
		
		return sortedWinSet;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
}
