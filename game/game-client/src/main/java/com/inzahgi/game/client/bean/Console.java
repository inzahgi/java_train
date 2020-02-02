package com.inzahgi.game.client.bean;

import com.google.inject.Inject;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.print.SimplePrinter;
import io.netty.channel.Channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int pokerDisplayFormat = 0;

    private Channel ch;

    @Inject
    public Console(Channel ch){
        this.ch = ch;
    }

    public void printPokers(List<Poker> pokers) {
        System.out.println(PokerHelper.printPoker(pokers));
    }

    public void printNotice(String msg) {
        System.out.println(msg);
    }

    public void serverLog(String msg) {
        System.out.println(FORMAT.format(new Date()) + "-> " + msg);
    }

    public String write(String message) {
        System.out.println();
        System.out.print("[server:\t" + message + "]$ ");
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println();
        }
        return null;
    }
}
