package com.inzahgi.game.print;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.helper.PokerHelper;
import io.netty.channel.Channel;


public class SimplePrinter {

	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//	public static int pokerDisplayFormat = 0;
//
//	public static void printPokers(List<Poker> pokers) {
//		System.out.println(PokerHelper.printPoker(pokers));
//	}
//
//	public static void printNotice(String msg) {
//		System.out.println(msg);
//	}
//
//	public static void printNotice(String msgKey, String locale) {
//		//TODO : read locale
//		Map<String,Map<String, String>> map = new HashMap<String,Map<String, String>>();
//		map.put("english", new HashMap<String, String>());
//		map.get("eng").put("caterpillar", "caterpillar's message!!");
//
//		System.out.println(map.get(locale).get(msgKey));
//	}


	public static void serverLog(String address, String msg){

		System.out.println(new StringBuilder(256)
							.append(address).append("\t")
							.append(msg));
	}


	public static void serverLog(String msg) {
		System.out.println(FORMAT.format(new Date()) + "-> " + msg);
	}
}
