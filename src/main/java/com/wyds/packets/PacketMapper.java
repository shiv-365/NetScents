package com.wyds.packets;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PacketMapper {

    private PacketParser parser = new PacketParser();
    private Map<Integer, String> packetMap = new HashMap<>();
    private List<String> packetLst = new LinkedList<>();

    public Map<Integer, String> packet() throws IOException {
        parser.parseUDP();

        for (int i = 0; i < parser.getPacketList().size(); i++) {
            packetMap.put(i, parser.getPacketList().get(i));


        }
        //System.out.println(packetMap);
        return packetMap;
    }


   /* public List<String> packet1() throws IOException {
        parser.parseUDP();
        packetLst.addAll(parser.getPacketList());
        return packetLst;
    }*/

}
