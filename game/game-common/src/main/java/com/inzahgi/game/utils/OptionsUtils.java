package com.inzahgi.game.utils;

public class OptionsUtils {

	public static int getOptions(String line) {
		int option = -1;
		try {
			option = Integer.valueOf(line);
		}catch(Exception e) {}
		return option;
	}
}
