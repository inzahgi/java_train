package com.inzahgi.game.utils;

import io.netty.channel.Channel;

import java.net.InetSocketAddress;

public class UrlUtils {

    public static String getRemoteAddress(Channel channel){
        return getRemoteAddress((InetSocketAddress)channel.remoteAddress());
    }

    public static String getRemoteAddress(InetSocketAddress inetSocketAddress){
        return new StringBuilder()
                .append(inetSocketAddress.getAddress().getHostAddress())
                .append(":")
                .append(inetSocketAddress.getPort()).toString();

    }
}
