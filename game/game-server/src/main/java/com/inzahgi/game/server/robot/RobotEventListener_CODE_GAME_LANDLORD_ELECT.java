package com.inzahgi.game.server.robot;

import java.util.ArrayList;
import java.util.List;

import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.helper.TimeHelper;
import com.inzahgi.game.robot.RobotDecisionMakers;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.helper.TimeHelper;
import com.inzahgi.game.robot.RobotDecisionMakers;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.event.ServerEventListener;

public class RobotEventListener_CODE_GAME_LANDLORD_ELECT implements RobotEventListener{

	@Override
	public void call(ClientSide robot, String data) {
		ServerContains.THREAD_EXCUTER.execute(() -> {
			Room room = ServerContains.getRoom(robot.getRoomId());

			List<Poker> landlordPokers = new ArrayList<>(20);
			landlordPokers.addAll(robot.getPokers());
			landlordPokers.addAll(room.getLandlordPokers());

			List<Poker> leftPokers = new ArrayList<>(17);
			leftPokers.addAll(robot.getPre().getPokers());

			List<Poker> rightPokers = new ArrayList<>(17);
			rightPokers.addAll(robot.getNext().getPokers());

			PokerHelper.sortPoker(landlordPokers);
			PokerHelper.sortPoker(leftPokers);
			PokerHelper.sortPoker(rightPokers);

			TimeHelper.sleep(300);
			
			ServerEventListener.get(ServerEventCode.CODE_GAME_LANDLORD_ELECT).call(robot, String.valueOf(RobotDecisionMakers.howToChooseLandlord(room.getDifficultyCoefficient(), leftPokers, rightPokers, landlordPokers)));
		});
	}

}
