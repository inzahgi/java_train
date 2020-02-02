package com.inzahgi.game.utils;

import com.google.common.collect.Maps;
import com.inzahgi.game.enums.CtrlEventCode;

import java.util.Map;

import static com.inzahgi.game.enums.CtrlEventCode.CTRL_JOIN_ROOM_RESP;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_LOGIN_REQ;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_LOGIN_RESP;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_SELECT_GAME_REQ;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_SELECT_ROOM_REQ;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_SHOW_GAME_HALL_RESP;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_START_GAME_RESP;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_USER_LOGOUT_RESP;

public class FlowUtils {



    public static CtrlEventCode getNext(CtrlEventCode ctrlEventCode){

        switch (ctrlEventCode){
            case CTRL_CONNECT_RESP:
                return CTRL_LOGIN_REQ;
            case CTRL_LOGIN_REQ:
                    return CTRL_LOGIN_RESP;
            case CTRL_LOGIN_RESP:
                return CTRL_SELECT_GAME_REQ;
            case CTRL_SELECT_GAME_REQ:
                return CTRL_SHOW_GAME_HALL_RESP;
            case CTRL_SHOW_GAME_HALL_RESP:
                return CTRL_SELECT_ROOM_REQ;
            case CTRL_SELECT_ROOM_REQ:
                return CTRL_JOIN_ROOM_RESP;
            case CTRL_JOIN_ROOM_RESP:
                return CTRL_START_GAME_RESP;
            case CTRL_EXIT_ROOM_REQ:
                return CTRL_USER_LOGOUT_RESP;
            case CTRL_EXIT_GAME_REQ:
                return CTRL_USER_LOGOUT_RESP;

            case CTRL_START_GAME_RESP:break;
            case CTRL_USER_LOGOUT_RESP:break;
            case CTRL_USER_TIME_OUT_RESP:break;
            case CTRL_GAME_OVER_RESP:break;
            case CTRL_INVAILD_CMD_RESP:
                default:


        }

        return null;

    }
}
