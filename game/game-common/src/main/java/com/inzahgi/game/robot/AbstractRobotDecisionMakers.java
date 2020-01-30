package com.inzahgi.game.robot;

import java.util.List;

import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.PokerSell;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.PokerSell;

/** 
 * 
 * @author nico
 * @version createTime：2018年11月15日 上午12:12:15
 */

public abstract	class AbstractRobotDecisionMakers {

	public abstract PokerSell howToPlayPokers(PokerSell lastPokerSell, List<Poker> myPokers);
	
	public abstract boolean howToChooseLandlord(List<Poker> leftPokers, List<Poker> rightPokers, List<Poker> myPokers);
}
