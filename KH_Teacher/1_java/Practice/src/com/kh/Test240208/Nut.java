package com.kh.Test240208;

public class Nut extends Farm{
	private String name;

	public Nut() {
		super();
	}

	public Nut(String kind, String name) {
		super(kind);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		String str = this.getName() + super.getKind();
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nut) {
			Nut f = (Nut)obj;
			if (f.getKind().equals(this.getKind()) && f.getName().equals(this.getName())) {
				return true;
			}
		}

		return false;
	}
}
