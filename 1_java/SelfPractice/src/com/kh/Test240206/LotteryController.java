package com.kh.Test240206;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet<Lottery> lottery;
	private HashSet<Lottery> win;
	
	public LotteryController() {
		lottery = new HashSet<>();
		win = new HashSet<>();
	}
	
	public boolean insertObject(Lottery l) {
//		boolean isTrue = false;
//		if(this.lottery.add(l)) {
//			this.lottery.add(l);
//			isTrue = true;
//		}
//		return isTrue;
		return this.lottery.add(l);
	}
	
	public void showLotteryObject() {
		for(Lottery lo : lottery) {
			System.out.println(lo);
		}
	}
	
	public void showWinObject() {
		for(Lottery lo : win) {
			System.out.println(lo);
		}
	}
	
	public boolean deleteObject(Lottery l) {
//		boolean isTrue = false;
//		if (this.lottery.remove(l)) {
//			isTrue = true;
//			if (this.win != null) {
//				this.win.remove(l);
//			}
//		}
//		return isTrue;
		boolean isRemove = lottery.remove(l);
		if(isRemove && win != null) {
			win.remove(l);
		}
		return isRemove;
	}
	
	public HashSet<Lottery> winObject() {
		
		if ( lottery.size() < 4 ) {
			return null;
		}
		
		List<Lottery> list = new ArrayList<>(this.lottery);
//		list.addAll(this.lottery);
//		Random random = new Random();
//		while(true) {
//			this.win.add(list.get(random.nextInt(3))); // 겹쳐서 안나왔나보다 nextInt(list.size())로 하면 어떰?
//			if(win.size() == 4) {
//				break;
//			}
//		}
		while(win.size() < 4) {
			int rand = (int)(Math.random() * list.size() );
			win.add(list.get(rand));
		}
		
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		TreeSet<Lottery> sortedWinSet = new TreeSet<>(new SortedLottery());
		sortedWinSet.addAll(win);
		return sortedWinSet;
	}
	
	public boolean searchWinner(Lottery l) {
		boolean isTrue = false;
		if (this.win.equals(l)) {
			isTrue = true;
		}
		return isTrue;
	}
}
