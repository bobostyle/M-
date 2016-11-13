package com.main.java.util;

import java.util.List;

import com.main.java.entity.Pocker;
import com.main.java.exception.NumberFaultException;

/**
 * OutOfThreeNumbersUtil.java
 * 2016年11月13日上午1:21:15
 * @author cbb
 * TODO
 */
public class OutOfThreeNumbersUtil {
	private static final int NUMBERS = 3;
	public static void handleVaildNumException(List<Pocker> pockers) throws NumberFaultException{
		if(null == pockers || pockers.size() != NUMBERS){
			throw new NumberFaultException("the number of pockers is falut!");
		}
	}
}
