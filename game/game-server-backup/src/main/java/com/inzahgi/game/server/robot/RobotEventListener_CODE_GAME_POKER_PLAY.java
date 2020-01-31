package com.inzahgi.game.server.robot;

import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.PokerSell;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.SellType;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.helper.TimeHelper;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.robot.RobotDecisionMakers;
import org.nico.noson.Noson;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.PokerSell;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.SellType;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.helper.TimeHelper;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.robot.RobotDecisionMakers;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.event.ServerEventListener;

public class RobotEventListener_CODE_GAME_POKER_PLAY implements RobotEventListener{

	@Override
	public void call(ClientSide robot, String data) {
		ServerContains.THREAD_EXCUTER.execute(() -> {
			Room room = ServerContains.getRoom(robot.getRoomId());

			PokerSell lastPokerSell = null;
			PokerSell pokerSell = null;
			if(room.getLastSellClient() != robot.getId()) {
				lastPokerSell = room.getLastPokerShell();
				pokerSell = RobotDecisionMakers.howToPlayPokers(room.getDifficultyCoefficient(), lastPokerSell, robot.getPokers());
			}else {
				pokerSell = RobotDecisionMakers.howToPlayPokers(room.getDifficultyCoefficient(), null, robot.getPokers());
			}
			
			if(pokerSell != null && lastPokerSell != null) {
				SimplePrinter.serverLog("Robot monitoring[room:" + room.getId() + "]");
				SimplePrinter.serverLog("last  sell  -> " + lastPokerSell.toString());
				SimplePrinter.serverLog("robot sell  -> " + pokerSell.toString());
				SimplePrinter.serverLog("robot poker -> " + PokerHelper.textOnlyNoType(robot.getPokers()));
			}
			
			TimeHelper.sleep(300);
			
			if(pokerSell == null || pokerSell.getSellType() == SellType.ILLEGAL) {
				ServerEventListener.get(ServerEventCode.CODE_GAME_POKER_PLAY_PASS).call(robot, data);
			}else {
				Character[] cs = new Character[pokerSell.getSellPokers().size()];
				for(int index = 0; index < cs.length; index ++) {
					cs[index] = pokerSell.getSellPokers().get(index).getLevel().getAlias()[0];
				}
				ServerEventListener.get(ServerEventCode.CODE_GAME_POKER_PLAY).call(robot, Noson.reversal(cs));
			}
		});
	}
}
