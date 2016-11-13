package com.main.java.servcie;

import java.util.ArrayList;
import java.util.List;

import com.main.java.entity.Colour;
import com.main.java.entity.Pocker;
import com.main.java.exception.NumberFaultException;
import com.main.java.util.PockersAttribute;
import com.main.java.util.SortPockerUtil;

/**
 * ComperService.java
 * 2016年11月13日上午12:14:29
 * @author cbb
 * TODO
 */
public class ComperService {
	
	public static boolean compare(List<Pocker> pockerA, List<Pocker> pockerB) throws NumberFaultException{
		SortPockerUtil.sort(pockerA);
		SortPockerUtil.sort(pockerB);
		PockersAttribute attributeA = PockersAttribute.getAttribute(pockerA);
		System.out.println(attributeA.getName());
		PockersAttribute attributeB = PockersAttribute.getAttribute(pockerB);
		System.out.println(attributeB.getName());
		if(attributeA.getIndex() == attributeB.getIndex()){
			return pockerA.get(2).getVlaue() > pockerB.get(2).getVlaue();
		}
		return attributeA.getIndex() > attributeB.getIndex();
	}
	public static void main(String[] args) {
		
		List<Pocker> pockera = new ArrayList<Pocker>();
		Pocker.THREE.setColour(Colour.HEART);
		Pocker.FOUR.setColour(Colour.HEART);
		Pocker.FIVE.setColour(Colour.HEART);
		pockera.add(Pocker.THREE);
		pockera.add(Pocker.FOUR);
		pockera.add(Pocker.FIVE);
		
		List<Pocker> pockerb = new ArrayList<Pocker>();
		Pocker.FIVE.setColour(Colour.SPADE);
		Pocker.K.setColour(Colour.HEART);
		Pocker.NINE.setColour(Colour.HEART);
		pockerb.add(Pocker.FIVE);
		pockerb.add(Pocker.K);
		pockerb.add(Pocker.NINE);
		try{
			System.out.println(ComperService.compare(pockerb, pockera));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
