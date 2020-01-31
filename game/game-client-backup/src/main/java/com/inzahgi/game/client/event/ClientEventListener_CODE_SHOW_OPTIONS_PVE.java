package com.inzahgi.game.client.event;

import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.print.SimpleWriter;
import com.inzahgi.game.utils.OptionsUtils;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_SHOW_OPTIONS_PVE extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		SimplePrinter.printNotice("PVE: ");
		SimplePrinter.printNotice("1. Simple Model");
		SimplePrinter.printNotice("2. Medium Model");
		SimplePrinter.printNotice("3. Difficulty Model");
		SimplePrinter.printNotice("Please enter the number of options (enter [BACK] return options list)");
		String line = SimpleWriter.write("pve");
		
		if(line.equalsIgnoreCase("BACK")) {
			get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
		}else {
			int choose = OptionsUtils.getOptions(line);
			
			if(0 < choose && choose < 4) {
				initLastSellInfo();
				pushToServer(channel, ServerEventCode.CODE_ROOM_CREATE_PVE, String.valueOf(choose));
			}else {
				SimplePrinter.printNotice("Invalid option, please choose again：");
				call(channel, data);
			}
		}
		
	}



}
