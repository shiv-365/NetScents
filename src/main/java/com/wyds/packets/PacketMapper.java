package com.wyds.packets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PacketMapper {

    private PacketParser parser = new PacketParser();
    private Map<Integer, String> packetMap = new HashMap<>();

    public Map<Integer, String> packet() throws IOException {
        parser.parseUDP();

        for (int i = 0; i < parser.getPacketList().size(); i++) {
            packetMap.put(i, parser.getPacketList().get(i));

            //use this in a POST method?
            // packetRepository.save(packetMap.get(i));

        }
        System.out.println(packetMap);
        return packetMap;
    }

}
