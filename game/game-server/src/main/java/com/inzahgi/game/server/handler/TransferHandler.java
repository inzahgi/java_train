package com.inzahgi.game.server.handler;

import com.google.inject.Inject;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.ControlDataProtoc;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.ServerTransferData;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientStatus;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.MsgType;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.ServerTransferData.ServerTransferDataProtoc;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientStatus;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.bean.RoomsSerice;
import com.inzahgi.game.server.bean.UsersService;
import com.inzahgi.game.server.event.ServerEventListener;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.util.Date;

public class TransferHandler extends ChannelInboundHandlerAdapter{

	@Inject
	private UsersService usersService;

	@Inject
	private RoomsSerice roomsSerice;

	public final static String CONNECT_SUCCESS = "connect success!";

	//public final static String CONNECT_FAIL = "connect fail!";


	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		Channel ch = ctx.channel();

		InetSocketAddress insocket = (InetSocketAddress) ch.remoteAddress();
		String clientIP = insocket.getAddress().getHostAddress();
		int port = insocket.getPort();

		StringBuilder sb = new StringBuilder();
		sb.append(new Date())
				.append(" Has client connect to the server：IP=")
				.append(clientIP)
				.append("\tport=")
				.append(port);

		SimplePrinter.serverLog(sb.toString());
		
		ChannelUtils.pushForCtrl(ch, CtrlEventCode.CTRL_CONNECT_RESP, sb.toString().getBytes(), "1");

	}

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		if(msg instanceof DataProtoc.Data){
			DataProtoc.Data orginData = (DataProtoc.Data)msg;
			if(orginData.getMsgType() == MsgType.ONLY_CTRL_DATA.getTypeCode()){

			}else if(orginData.getMsgType() == MsgType.ONLY_GAME_DATA.getTypeCode()){

			}
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if(cause instanceof java.io.IOException) {
			clientOfflineEvent(ctx.channel());
		}else {
			SimplePrinter.serverLog("ERROR：" + cause.getMessage());
			cause.printStackTrace();
		}
	}
	
    @Override  
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {  
        if (evt instanceof IdleStateEvent) {  
            IdleStateEvent event = (IdleStateEvent) evt;  
            if (event.state() == IdleState.READER_IDLE) {  
                try{
                	clientOfflineEvent(ctx.channel());
                	ctx.channel().close();
                }catch(Exception e){
                }
            }  
        } else {  
            super.userEventTriggered(ctx, evt);  
        }  
    }  
	

    
    private void clientOfflineEvent(Channel channel){
    	int clientId = getId(channel);
    	ClientSide client = ServerContains.CLIENT_SIDE_MAP.get(clientId);
    	if(client != null) {
			SimplePrinter.serverLog("Has client exit to the server：" + clientId + " | " + client.getNickname());
			ServerEventListener.get(ServerEventCode.CODE_CLIENT_OFFLINE).call(client, null);
		}
    }

    private void processCtrlEvent(ChannelHandlerContext ctx, ControlDataProtoc.ControlData ctrlData){
		Channel ch = ctx.channel();
		int code = ctrlData.getMsgCode();
		String name = CtrlEventCode.getByCode(code).name();
		ServerEventListener.get(code, name).call();
	}
}
