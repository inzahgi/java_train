package com.inzahgi.game.server.handler;

import com.google.inject.Inject;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.ServerTransferData;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientStatus;
import com.inzahgi.game.enums.CtrlEventCode;
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
		
		//init client info
//		ClientSide clientSide = new ClientSide(getId(ctx.channel()), ClientStatus.TO_CHOOSE, ch);
//		//clientSide.setNickname(String.valueOf(clientSide.getId()));
//		clientSide.setRole(ClientRole.PLAYER);
//
//		ServerContains.CLIENT_SIDE_MAP.put(clientSide.getId(), clientSide);

		InetSocketAddress insocket = (InetSocketAddress) ch.remoteAddress();
		String clientIP = insocket.getAddress().getHostAddress();
		int port = insocket.getPort();

		SimplePrinter.serverLog("Has client connect to the server：IP=" + clientIP + "\tport=" + port);
		
		ChannelUtils.pushToClientForCtrl(ch, CtrlEventCode.CTRL_CONNECT_SUCCESS, CONNECT_SUCCESS.getBytes(), "1");
		//ChannelUtils.pushToClient(ch, ClientEventCode.CODE_CLIENT_NICKNAME_SET, null);
	}

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if(msg instanceof ServerTransferData.ServerTransferDataProtoc) {
			ServerTransferData.ServerTransferDataProtoc serverTransferData = (ServerTransferData.ServerTransferDataProtoc) msg;
			ServerEventCode code = ServerEventCode.valueOf(serverTransferData.getCode());
			if(code != null && code != ServerEventCode.CODE_CLIENT_HEAD_BEAT) {
				ClientSide client = ServerContains.CLIENT_SIDE_MAP.get(getId(ctx.channel()));
				SimplePrinter.serverLog(client.getId() + " | " + client.getNickname() + " do:" + code.getMsg());
				ServerEventListener.get(code).call(client, serverTransferData.getData());
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
	
    private int getId(Channel channel){
    	String longId = channel.id().asLongText();
    	Integer clientId = ServerContains.CHANNEL_ID_MAP.get(longId);
    	if(null == clientId){
    		clientId = ServerContains.getClientId();
    		ServerContains.CHANNEL_ID_MAP.put(longId, clientId);
    	}
    	return clientId;
    }
    
    private void clientOfflineEvent(Channel channel){
    	int clientId = getId(channel);
    	ClientSide client = ServerContains.CLIENT_SIDE_MAP.get(clientId);
    	if(client != null) {
			SimplePrinter.serverLog("Has client exit to the server：" + clientId + " | " + client.getNickname());
			ServerEventListener.get(ServerEventCode.CODE_CLIENT_OFFLINE).call(client, null);
		}
    }
}
