package com.inzahgi.game.robot;

import java.util.List;

import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.PokerSell;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.PokerSell;
import com.inzahgi.game.helper.PokerHelper;

public class MediumRobotDecisionMakers extends AbstractRobotDecisionMakers{

	@Override
	public PokerSell howToPlayPokers(PokerSell lastPokerSell, List<Poker> myPokers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean howToChooseLandlord(List<Poker> leftPokers, List<Poker> rightPokers, List<Poker> myPokers) {
		int leftScore = PokerHelper.parsePokerColligationScore(leftPokers);
		int rightScore = PokerHelper.parsePokerColligationScore(rightPokers);
		int myScore = PokerHelper.parsePokerColligationScore(myPokers);
		return myScore >= (leftScore + rightScore)/2;
	}

}
