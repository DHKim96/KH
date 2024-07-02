package com.kh.Test240126;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker; // 제조사 정보

    public SmartPhone() {
        this.maker = "";
    }

    public abstract String printInformation();

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }
}
