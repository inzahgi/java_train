package com.inzahgi.game.client.event;

import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.print.SimpleWriter;
import com.inzahgi.game.utils.OptionsUtils;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_SHOW_OPTIONS_SETTING extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		SimplePrinter.printNotice("Setting: ");
		SimplePrinter.printNotice("1. Card with shape edges (Default)");
		SimplePrinter.printNotice("2. Card with rounded edges");
		SimplePrinter.printNotice("3. Text Only with types");
		SimplePrinter.printNotice("4. Text Only without types");
		SimplePrinter.printNotice("5. Unicode Cards");

		SimplePrinter.printNotice("Please enter the number of setting (enter [BACK] return options list)");
		String line = SimpleWriter.write("setting");
		
		if(line.equalsIgnoreCase("BACK")) {
			get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
		}else {
			int choose = OptionsUtils.getOptions(line);
			
			if(choose >=1 && choose <= 5){
				PokerHelper.pokerPrinterType = choose - 1;
				get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
			} else {
				SimplePrinter.printNotice("Invalid setting, please choose again：");
				call(channel, data);
			}
		}
	}



}
