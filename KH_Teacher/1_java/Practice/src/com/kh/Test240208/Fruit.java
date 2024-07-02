package com.kh.Test240208;

public class Fruit extends Farm{
	private String name;

	public Fruit() {
		super();
	}

	public Fruit(String kind, String name) {
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
		if (obj instanceof Fruit) {
			Fruit f = (Fruit)obj;
			if (f.getKind().equals(this.getKind()) && f.getName().equals(this.getName())) {
				return true;
			}
		}

		return false;
	}
	
}
