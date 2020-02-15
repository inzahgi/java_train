package com.inzahgi.game.server.bean;

import com.google.common.collect.Lists;
import com.inzahgi.game.entity.Player;
import com.inzahgi.game.entity.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RoomsSerice {

    private final Map<Integer, Room> map = new ConcurrentHashMap<>();
    private final AtomicInteger roomCnt = new AtomicInteger(0);
    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    private final ReentrantReadWriteLock.ReadLock rLock = rwlock.readLock();
    private final ReentrantReadWriteLock.WriteLock wLock = rwlock.writeLock();

    public List<Room> getRoomList(){
        List<Room> resList = Lists.newArrayListWithCapacity(128);
        try {
            rLock.lock();
            for (Map.Entry<Integer, Room> entry : map.entrySet()) {
                resList.add(entry.getValue());
                if (resList.size() == 100) {
                    break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rLock.unlock();
        }
        return resList;
    }

    public Room addRoom(Integer roomNo, Player player){

        Room room = null;
        if(roomNo.equals(0)){
            int id = roomCnt.getAndIncrement();
            room = new Room();
            room.setId(id);
            room.addPlayer(player);
            map.put(id, room);
        }else if(map.containsKey(roomNo)){
            Room roomTmp = map.get(roomNo);
            if(roomTmp.getPlayerList().size() < 3) {
                roomTmp.addPlayer(player);
                //room = roomTmp;
            }
        }

        return room;
    }


}
