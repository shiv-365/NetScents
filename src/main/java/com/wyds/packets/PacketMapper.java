package com.wyds.packets;

import java.io.IOException;
import java.util.*;

public class PacketMapper {

    private PacketParser parser = new PacketParser();
    //private Map<Integer, String> packetMap = new HashMap<>();
    private static List<String> packetLst = new ArrayList<>();

    /*public Map<Integer, String> packet() throws IOException {
        parser.parseUDP();

        for (int i = 0; i < parser.getPacketList().size(); i++) {
            packetMap.put(i, parser.getPacketList().get(i));


        }
        //System.out.println(packetMap);
        return packetMap;
    }*/


    public List<String> packetL() throws IOException {
        parser.parseUDP();
        packetLst.add(0, "not null");
        packetLst.addAll(parser.getPacketList());
        System.out.println(packetLst);
        return packetLst;
    }

}
