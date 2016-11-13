package com.main.java.entity;

 /**
 * Pocker.java
 * 2016年11月13日下午8:19:54
 * @author cbb
 * TODO 
 */
public enum Pocker {
	
	TWO(2, "2"),
	THREE(3, "3"),
	FOUR(4, "4"),
	FIVE(5, "5"),
	SIX(6, "6"),
	SEVEN(7, "7"),
	EIGHT(8, "8"),
	NINE(9, "9"),
	TEN(10, "10"),
	J(11, "J"),
	Q(12, "Q"),
	K(13, "K"),
	A(14, "A");
	
	public Colour colour;
	public int vlaue; //牌面值，转成对应的数字大小
	public String name; //牌面值
	/**
	 * @param colour
	 * @param vlaue
	 * @param name
	 */
	private Pocker( int vlaue, String name) {
		this.vlaue = vlaue;
		this.name = name;
	}
	/**
	 * @return the colour
	 */
	public Colour getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	/**
	 * @return the vlaue
	 */
	public int getVlaue() {
		return vlaue;
	}
	/**
	 * @param vlaue the vlaue to set
	 */
	public void setVlaue(int vlaue) {
		this.vlaue = vlaue;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
