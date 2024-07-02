package com.kh.model.vo;

public class Portion extends Item {
	private String pType;
	private String volume;
	private int recoveryFigure;
	
	public Portion(String type, String name, int price, String info, String pType, String volume, int recoveryFigure) {
		super(type, name, price, info);
		this.pType = pType;
		this.volume = volume;
		this. recoveryFigure = recoveryFigure;
	}

	public final String getpType() {
		return pType;
	}

	public final void setpType(String pType) {
		this.pType = pType;
	}

	public final String getVolume() {
		return volume;
	}

	public final void setVolume(String volume) {
		this.volume = volume;
	}

	public final int getRecoveryFigure() {
		return recoveryFigure;
	}

	public final void setRecoveryFigure(int recoveryFigure) {
		this.recoveryFigure = recoveryFigure;
	}

	@Override
	public String toString() {
		return pType + "," + volume + ", " + recoveryFigure;
	}
	
	public int use() {
		return this.recoveryFigure;
	}
	
	
}
