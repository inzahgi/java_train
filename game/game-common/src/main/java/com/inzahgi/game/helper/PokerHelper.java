package com.inzahgi.game.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.PokerSell;
import com.inzahgi.game.enums.PokerLevel;
import com.inzahgi.game.enums.PokerType;
import com.inzahgi.game.enums.SellType;
import com.inzahgi.game.utils.ListUtils;

public class PokerHelper {

	/**
	 * Print the type of poker style 
	 */
	public static int pokerPrinterType = 0;

	public static int totalPrinters = 5;
	
	/**
	 * The list of all pokers, by 54
	 */
	private static List<Poker> basePokers = new ArrayList<Poker>(54);

	private static Comparator<Poker> pokerComparator = new Comparator<Poker>() {
		@Override
		public int compare(Poker o1, Poker o2) {
			return o1.getLevel().getLevel() - o2.getLevel().getLevel();
		}
	};

	static {
		PokerLevel[] pokerLevels = PokerLevel.values();
		PokerType[] pokerTypes = PokerType.values();

		for(PokerLevel level: pokerLevels) {
			if(level == PokerLevel.LEVEL_BIG_KING) {
				basePokers.add(new Poker(level, PokerType.BLANK));
				continue;
			}
			if(level == PokerLevel.LEVEL_SMALL_KING) {
				basePokers.add(new Poker(level, PokerType.BLANK));
				continue;
			}
			for(PokerType type: pokerTypes) {
				if(type == PokerType.BLANK) {
					continue;
				}
				basePokers.add(new Poker(level, type));
			}
		}
	}

	//按照牌面升序 排序
	public static void sortPoker(List<Poker> pokers){
		Collections.sort(pokers, pokerComparator);
	}

	/**
	 * 解析输入参数 获取客户端输出牌数
	 * @param options 客户端出牌参数
	 * @param pokers  客户端剩余的牌数
	 * @return
	 */
	public static int[] getIndexes(Character[] options, List<Poker> pokers) {
		//复制客户端的牌数
		List<Poker> copyList = new ArrayList<>(pokers.size());
		copyList.addAll(pokers);
		int[] indexes = new int[options.length];
		//遍历输入参数
		for(int index = 0; index < options.length; index ++) {
			char option = options[index];
			boolean isTarget = false;
			//遍历备份的剩余扑克牌
			for(int pi = 0; pi < copyList.size(); pi ++) {
				Poker poker = copyList.get(pi);
				if(poker != null) {
					//如果输入的参数在剩余的扑克牌中有
					if(Arrays.asList(poker.getLevel().getAlias()).contains(option)) {
						isTarget = true;
						//Index start from 1, not 0
						//保存牌的索引
						indexes[index] = pi + 1;
						//清空该备份扑克牌列表
						copyList.set(pi, null);
						break;
					}
				}
			}
			if(! isTarget) {
				return null;
			}
		}
		Arrays.sort(indexes);
		return indexes;
	}


	public static boolean checkPokerIndex(int[] indexes, List<Poker> pokers){
		boolean access = true;
		if(indexes == null || indexes.length == 0) {
			access = false;
		}else {
			for(int index: indexes){
				if(index > pokers.size() || index < 1){
					access = false;
				}
			}
		}
		return access;
	}

	//检查出牌花色
	public static PokerSell checkPokerType(List<Poker> pokers) {

		if(pokers != null && ! pokers.isEmpty()) {
			//升序排序
			sortPoker(pokers);
			//标志出牌的字典表
			int[] levelTable = new int[20];
			//统计相同出牌的次数 对子 炸弹...
			for(Poker poker: pokers) {
				levelTable[poker.getLevel().getLevel()] ++; 
			}

			int startIndex = -1;
			int endIndex = -1;
			int count = 0;

			int singleCount = 0;
			int doubleCount = 0;
			int threeCount = 0;
			int threeStartIndex = -1;
			int threeEndIndex = -1;
			int fourCount = 0;
			int fourStartIndex = -1;
			int fourEndIndex = -1;
			//遍历出牌字典表
			for(int index = 0; index < levelTable.length; index ++) {
				//获取出牌重复次数
				int value = levelTable[index];
				if(value != 0) {
					//设置结束索引为当前索引
					endIndex = index;
					count ++;
					//首次初始化起始索引 为当前索引
					if(startIndex == -1) {
						startIndex = index;
					}
					//统计出牌重复类型
					if(value == 1) {
						singleCount ++;
					}else if(value == 2) {
						doubleCount ++;
					}else if(value == 3) {
						if(threeStartIndex == -1) {
							threeStartIndex = index;
						}
						threeEndIndex = index;
						threeCount ++;
					}else if(value == 4) {
						if(fourStartIndex == -1) {
							fourStartIndex = index;
						}
						fourEndIndex = index;
						fourCount ++;
					}
				}
			}
			//只出了四张一样的  为炸弹
			if(singleCount == doubleCount && singleCount == threeCount && singleCount == 0 && fourCount == 1) {
				return new PokerSell(SellType.BOMB, pokers, startIndex);
			}
			//出了两张牌 大小王 为王炸
			if(singleCount == 2 && startIndex == PokerLevel.LEVEL_SMALL_KING.getLevel() && endIndex == PokerLevel.LEVEL_BIG_KING.getLevel()) {
				return new PokerSell(SellType.KING_BOMB, pokers, PokerLevel.LEVEL_SMALL_KING.getLevel());
			}
			//当只有一种数字的牌时
			if(startIndex == endIndex) {
				// 单张
				if(levelTable[startIndex] == 1) {
					return new PokerSell(SellType.SINGLE, pokers, startIndex);
				}else if(levelTable[startIndex] == 2) {
					//对子
					return new PokerSell(SellType.DOUBLE, pokers, startIndex);
				}else if(levelTable[startIndex] == 3) {
					// 三张
					return new PokerSell(SellType.THREE, pokers, startIndex);
				}
			}
			//出完牌后
			if(endIndex - startIndex == count - 1 && endIndex < PokerLevel.LEVEL_2.getLevel()) {
				//起始牌为单张 总数大于4张牌  没有对子 三张 四张的  说明是单顺子
				if(levelTable[startIndex] == 1 && singleCount > 4 && doubleCount + threeCount + fourCount == 0) {
					return new PokerSell(SellType.SINGLE_STRAIGHT, pokers, endIndex);
					//起始相同牌数为2张 说明是连对
				}else if(levelTable[startIndex] == 2 && doubleCount > 2 && singleCount + threeCount + fourCount == 0) {
					return new PokerSell(SellType.DOUBLE_STRAIGHT, pokers, endIndex);
					//起始相同牌数为3张  说明三顺子
				}else if(levelTable[startIndex] == 3 && threeCount > 1 && doubleCount + singleCount + fourCount == 0) {
					return new PokerSell(SellType.THREE_STRAIGHT, pokers, endIndex);
					//起始相同牌数为4张  说明四顺子
				}else if(levelTable[startIndex] == 4 && fourCount > 1 && doubleCount + threeCount + singleCount == 0) {
					return new PokerSell(SellType.FOUR_STRAIGHT, pokers, endIndex);
				}
			}
			// 考虑三带 X
			if(threeCount != 0) {
				//三带一  带单牌
				if(singleCount != 0 && singleCount == threeCount && doubleCount == 0 && fourCount == 0) {
					// 一个三带一
					if(threeCount == 1) {
						return new PokerSell(SellType.THREE_ZONES_SINGLE, pokers, threeEndIndex);
					}else {
						//连续 三带一  而且不以二结束
						if(threeEndIndex - threeStartIndex + 1 == threeCount && threeEndIndex < PokerLevel.LEVEL_2.getLevel()) {
							return new PokerSell(SellType.THREE_STRAIGHT_WITH_SINGLE, pokers, threeEndIndex);
						}
					}
					// 三带二
				}else if(doubleCount != 0 && doubleCount == threeCount && singleCount == 0 && fourCount == 0) {
					// 单个三带二
					if(threeCount == 1) {
						return new PokerSell(SellType.THREE_ZONES_DOUBLE, pokers, threeEndIndex);
					}else {
						// 连续三带二
						if(threeEndIndex - threeStartIndex + 1 == threeCount && threeEndIndex < PokerLevel.LEVEL_2.getLevel()) {
							return new PokerSell(SellType.FOUR_STRAIGHT_WITH_DOUBLE, pokers, threeEndIndex);
						}
					}
				}
			}
			// 考虑 四带 X
			if(fourCount != 0) {
				// 四带一
				if(singleCount != 0 && singleCount == fourCount * 2 && doubleCount == 0 && threeCount == 0) {
					//单个四带一
					if(fourCount == 1) {
						return new PokerSell(SellType.FOUR_ZONES_SINGLE, pokers, fourEndIndex);
					}else {
						//多个四带一
						if(fourEndIndex - fourStartIndex + 1 == fourCount && fourEndIndex < PokerLevel.LEVEL_2.getLevel()) {
							return new PokerSell(SellType.FOUR_STRAIGHT_WITH_SINGLE, pokers, fourEndIndex);
						}
					}
					//四带二
				}else if(doubleCount != 0 && doubleCount == fourCount * 2 && singleCount == 0 && threeCount == 0) {
					//单个四带一
					if(fourCount == 1) {
						return new PokerSell(SellType.FOUR_ZONES_DOUBLE, pokers, fourEndIndex);
					}else {
						//多个四带二
						if(fourEndIndex - fourStartIndex + 1 == fourCount && fourEndIndex < PokerLevel.LEVEL_2.getLevel()) {
							return new PokerSell(SellType.FOUR_STRAIGHT_WITH_DOUBLE, pokers, fourEndIndex);
						}
					}
				}
			}
		}
		return new PokerSell(SellType.ILLEGAL, null, -1);
	}
	//计算牌面 得分
	public static int parseScore(SellType sellType, int level) {
		if(sellType == SellType.BOMB) {
			return level * 4 + 999;
		}else if(sellType == SellType.KING_BOMB) {
			return Integer.MAX_VALUE;
		}else if(sellType == SellType.SINGLE || sellType == SellType.DOUBLE || sellType == SellType.THREE) {
			return level;
		}else if(sellType == SellType.SINGLE_STRAIGHT || sellType == SellType.DOUBLE_STRAIGHT || sellType == SellType.THREE_STRAIGHT || sellType == SellType.FOUR_STRAIGHT) {
			return level;
		}else if(sellType == SellType.THREE_ZONES_SINGLE || sellType == SellType.THREE_STRAIGHT_WITH_SINGLE || sellType == SellType.THREE_ZONES_DOUBLE || sellType == SellType.FOUR_STRAIGHT_WITH_DOUBLE) {
			return level;
		}else if(sellType == SellType.FOUR_ZONES_SINGLE || sellType == SellType.FOUR_STRAIGHT_WITH_SINGLE || sellType == SellType.FOUR_ZONES_DOUBLE || sellType == SellType.FOUR_STRAIGHT_WITH_DOUBLE) {
			return level;
		}
		return -1;
	}

	public static List<Poker> getPoker(int[] indexes, List<Poker> pokers){
		List<Poker> resultPokers = new ArrayList<>(indexes.length);
		for(int index: indexes){
			resultPokers.add(pokers.get(index - 1));
		}
		sortPoker(resultPokers);
		return resultPokers;
	}

	public static boolean comparePoker(List<Poker> pres, List<Poker> currents){

		return true;
	}

	public static List<List<Poker>> distributePoker(){
		Collections.shuffle(basePokers);
		List<List<Poker>> pokersList = new ArrayList<List<Poker>>();
		List<Poker> pokers1 = new ArrayList<>(17);
		pokers1.addAll(basePokers.subList(0, 17));
		List<Poker> pokers2 = new ArrayList<>(17);
		pokers2.addAll(basePokers.subList(17, 34));
		List<Poker> pokers3 = new ArrayList<>(17);
		pokers3.addAll(basePokers.subList(34, 51));
		List<Poker> pokers4 = new ArrayList<>(3);
		pokers4.addAll(basePokers.subList(51, 54));
		pokersList.add(pokers1);
		pokersList.add(pokers2);
		pokersList.add(pokers3);
		pokersList.add(pokers4);
		for(List<Poker> pokers: pokersList) {
			sortPoker(pokers);
		}
		return pokersList;
	}

	public static String printPoker(List<Poker> pokers) {
		sortPoker(pokers);
		switch(pokerPrinterType){
		case 0:
			return buildHandStringSharp(pokers);
		case 1:
			return buildHandStringRounded(pokers);
		case 2:
			return textOnly(pokers);
		case 3:
			return textOnlyNoType(pokers);
		default:
			return buildHandStringSharp(pokers);

		}

	}
	private static String buildHandStringSharp(List<Poker> pokers){
		StringBuilder builder = new StringBuilder();
		if(pokers != null && pokers.size() > 0) {

			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("┌──┐");
				}else {
					builder.append("──┐");
				}
			}
			builder.append(System.lineSeparator());
			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("│");
				}
				String name = pokers.get(index).getLevel().getName();
				builder.append(name + (name.length() == 1 ? " " : "" ) +  "|");
			}
			builder.append(System.lineSeparator());
			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("│");
				}
				builder.append(pokers.get(index).getType().getName() + " |");
			}
			builder.append(System.lineSeparator());
			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("└──┘");
				} else {
					builder.append("──┘");
				}
			}
		}
		return builder.toString();
	}
	private static String buildHandStringRounded(List<Poker> pokers){
		StringBuilder builder = new StringBuilder();
		if(pokers != null && pokers.size() > 0) {

			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("┌──╮");
				}else {
					builder.append("──╮");
				}
			}
			builder.append(System.lineSeparator());
			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("│");
				}
				String name = pokers.get(index).getLevel().getName();
				builder.append(name + (name.length() == 1 ? " " : "" ) +  "|");
			}
			builder.append(System.lineSeparator());
			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("│");
				}
				builder.append(pokers.get(index).getType().getName() + " |");
			}
			builder.append(System.lineSeparator());
			for(int index = 0; index < pokers.size(); index ++) {
				if(index == 0) {
					builder.append("└──╯");
				} else {
					builder.append("──╯");
				}
			}
		}
		return builder.toString();
	}

	private static String textOnly(List<Poker> pokers){
		StringBuilder builder = new StringBuilder();
		if(pokers != null && pokers.size() > 0) {
			for(int index = 0; index < pokers.size(); index ++) {
				String name = pokers.get(index).getLevel().getName();
				String type = pokers.get(index).getType().getName();

				builder.append(name + type);
			}
		}
		return builder.toString();
	}
	public static String textOnlyNoType(List<Poker> pokers){
		StringBuilder builder = new StringBuilder();
		if(pokers != null && pokers.size() > 0) {
			for(int index = 0; index < pokers.size(); index ++) {
				String name = pokers.get(index).getLevel().getName();
				builder.append(name + " ");
			}
		}
		return builder.toString();
	}

	public static int parsePokerColligationScore(List<Poker> pokers){
		int score = 0;
		int count = 0;
		int increase = 0;
		int lastLevel = -1;
		if(pokers != null && ! pokers.isEmpty()){
			for(int index = 0; index < pokers.size(); index ++){
				int level = pokers.get(index).getLevel().getLevel();
				if(lastLevel == -1){
					increase ++;
					count ++;
					score += lastLevel;
				}else{
					if(level == lastLevel){
						++ count;
					}else{
						count = 1;
					}
					if(level < PokerLevel.LEVEL_2.getLevel() && level - 1 == lastLevel){
						++ increase;
					}else{
						increase = 1;
					}

					score += (count + (increase > 4 ? increase : 0)) * level;
				}

				if(level == PokerLevel.LEVEL_2.getLevel()){
					score += level * 2;
				}else if(level > PokerLevel.LEVEL_2.getLevel()){
					score += level * 3;
				}
				lastLevel = level;
			}
		}
		return score;
	}

	public static List<PokerSell> parsePokerSells(List<Poker> pokers){
		List<PokerSell> pokerSells = new ArrayList<>();
		int size = pokers.size();

		//all single or double
		{
			int count = 0;
			int lastLevel = -1;
			List<Poker> sellPokers = new ArrayList<>(4);
			for(int index = 0; index < pokers.size(); index ++) {
				Poker poker = pokers.get(index);
				int level = poker.getLevel().getLevel();
				if(lastLevel == -1) {
					++ count;
				}else {
					if(level == lastLevel) {
						++ count;
					}else {
						count = 1;
						sellPokers.clear();
					}
				}
				sellPokers.add(poker);
				if(count == 1) {
					pokerSells.add(new PokerSell(SellType.SINGLE, ListUtils.getList(sellPokers), poker.getLevel().getLevel()));
				}else if(count == 2){
					pokerSells.add(new PokerSell(SellType.DOUBLE, ListUtils.getList(sellPokers), poker.getLevel().getLevel()));
				}else if(count == 3){
					pokerSells.add(new PokerSell(SellType.THREE, ListUtils.getList(sellPokers), poker.getLevel().getLevel()));
				}else if(count == 4){
					pokerSells.add(new PokerSell(SellType.BOMB, ListUtils.getList(sellPokers), poker.getLevel().getLevel()));
				}

				lastLevel = level;
			}
		}
		//Shunzi
		{
			parsePokerSellStraight(pokerSells, SellType.SINGLE);
			parsePokerSellStraight(pokerSells, SellType.DOUBLE);
			parsePokerSellStraight(pokerSells, SellType.THREE);
			parsePokerSellStraight(pokerSells, SellType.BOMB);
		}
		
		//Shunzi with args
		{
			for(int index = 0; index < pokerSells.size(); index ++) {
				PokerSell sell = pokerSells.get(index);
				if(sell.getSellType() == SellType.THREE) {
					parseArgs(pokerSells, sell, 1, SellType.SINGLE, SellType.THREE_ZONES_SINGLE);
					parseArgs(pokerSells, sell, 1, SellType.DOUBLE, SellType.THREE_ZONES_DOUBLE);
				}else if(sell.getSellType() == SellType.BOMB) {
					parseArgs(pokerSells, sell, 2, SellType.SINGLE, SellType.FOUR_ZONES_SINGLE);
					parseArgs(pokerSells, sell, 2, SellType.DOUBLE, SellType.FOUR_ZONES_DOUBLE);
				}else if(sell.getSellType() == SellType.THREE_STRAIGHT) {
					int count = sell.getSellPokers().size() / 3;
					parseArgs(pokerSells, sell, count, SellType.SINGLE, SellType.THREE_STRAIGHT_WITH_SINGLE);
					parseArgs(pokerSells, sell, count, SellType.DOUBLE, SellType.THREE_STRAIGHT_WITH_DOUBLE);
				}else if(sell.getSellType() == SellType.FOUR_STRAIGHT) {
					int count = (sell.getSellPokers().size() / 4) * 2;
					parseArgs(pokerSells, sell, count, SellType.SINGLE, SellType.FOUR_STRAIGHT_WITH_SINGLE);
					parseArgs(pokerSells, sell, count, SellType.DOUBLE, SellType.FOUR_STRAIGHT_WITH_DOUBLE);
				}
			}
		}
		
		//king boom
		{
			if(size > 1) {
				if(pokers.get(size - 1).getLevel() == PokerLevel.LEVEL_BIG_KING && pokers.get(size - 2).getLevel() == PokerLevel.LEVEL_SMALL_KING) {
					pokerSells.add(new PokerSell(SellType.KING_BOMB, ListUtils.getList(new Poker[] {pokers.get(size - 2), pokers.get(size - 1)}), PokerLevel.LEVEL_BIG_KING.getLevel()));
				}
			}
		}
		
		return pokerSells;
	}
	
	private static void parseArgs(List<PokerSell> pokerSells, PokerSell pokerSell, int deep, SellType sellType, SellType targetSellType) {
		Set<Integer> existLevelSet = new HashSet<>();
		for(Poker p: pokerSell.getSellPokers()) {
			existLevelSet.add(p.getLevel().getLevel());
		}
		parseArgs(existLevelSet, pokerSells, new HashSet<>(), pokerSell, deep, sellType, targetSellType);
	}
	
	private static void parseArgs(Set<Integer> existLevelSet, List<PokerSell> pokerSells, Set<List<Poker>> pokersList, PokerSell pokerSell, int deep, SellType sellType, SellType targetSellType) {
		if(deep == 0) {
			List<Poker> allPokers = new ArrayList<>();
			allPokers.addAll(pokerSell.getSellPokers());
			for(List<Poker> ps: pokersList) {
				allPokers.addAll(ps);
			}
			pokerSells.add(new PokerSell(targetSellType, allPokers, pokerSell.getCoreLevel()));
			return;
		}
		
		for(int index = 0; index < pokerSells.size(); index ++) {
			PokerSell subSell = pokerSells.get(index);
			if(subSell.getSellType() == sellType && ! existLevelSet.contains(subSell.getCoreLevel())) {
				pokersList.add(subSell.getSellPokers());
				existLevelSet.add(subSell.getCoreLevel());
				parseArgs(existLevelSet, pokerSells, pokersList, pokerSell, deep - 1, sellType, targetSellType);
				existLevelSet.remove(subSell.getCoreLevel());
				pokersList.remove(subSell.getSellPokers());
			}
		}
	}

	private static void parsePokerSellStraight(List<PokerSell> pokerSells, SellType sellType) {
		int minLenght = -1;
		int width = -1;
		SellType targetSellType = null;
		if(sellType == SellType.SINGLE) {
			minLenght = 5;
			width = 1;
			targetSellType = SellType.SINGLE_STRAIGHT;
		}else if(sellType == SellType.DOUBLE) {
			minLenght = 3;
			width = 2;
			targetSellType = SellType.DOUBLE_STRAIGHT;
		}else if(sellType == SellType.THREE) {
			minLenght = 2;
			width = 3;
			targetSellType = SellType.THREE_STRAIGHT;
		}else if(sellType == SellType.BOMB) {
			minLenght = 2;
			width = 4;
			targetSellType = SellType.FOUR_STRAIGHT;
		}

		int increase_1 = 0;
		int lastLevel_1 = -1;
		List<Poker> sellPokers_1 = new ArrayList<>(4);
		for(int index = 0; index < pokerSells.size(); index ++) {
			PokerSell sell = pokerSells.get(index);

			if(sell.getSellType() == sellType) {
				int level = sell.getCoreLevel();
				if(lastLevel_1 == -1) {
					++ increase_1;
					sellPokers_1.addAll(sell.getSellPokers());
				}else {
					if(level - 1 == lastLevel_1 && level != PokerLevel.LEVEL_2.getLevel()) {
						++ increase_1;
						sellPokers_1.addAll(sell.getSellPokers());
					}else{
						if(increase_1 >= minLenght) {
							for(int s = 0; s <= increase_1 - minLenght; s ++) {
								int len = minLenght + s;
								for(int subIndex = 0; subIndex <= increase_1 - len; subIndex ++) {
									List<Poker> pokers = ListUtils.getList(sellPokers_1.subList(subIndex * width, (subIndex + len) * width));
									pokerSells.add(new PokerSell(targetSellType, pokers, pokers.get(pokers.size() - 1).getLevel().getLevel()));
								}
							}
						}
						increase_1 = 1;
						sellPokers_1.clear();
						sellPokers_1.addAll(sell.getSellPokers());
					}
				}
				lastLevel_1 = level;
			}
		}
		if(sellPokers_1 != null) {
			if(increase_1 >= minLenght) {
				for(int s = 0; s <= increase_1 - minLenght; s ++) {
					int len = minLenght + s;
					for(int subIndex = 0; subIndex <= increase_1 - len; subIndex ++) {
						List<Poker> pokers = ListUtils.getList(sellPokers_1.subList(subIndex * width, (subIndex + len) * width));
						pokerSells.add(new PokerSell(targetSellType, pokers, pokers.get(pokers.size() - 1).getLevel().getLevel()));
					}
				}
			}
			increase_1 = 0;
			sellPokers_1.clear();
		}
	}
}