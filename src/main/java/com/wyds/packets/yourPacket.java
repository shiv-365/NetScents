package com.wyds.packets;


import com.wyds.PacketRepo.packetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "pcap")
public class yourPacket {

    PacketParser parser = new PacketParser();
    Map<Integer,String> packetMap = new HashMap<>();

    @Autowired
    packetRepository packetRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "packet")
    String packet;

    @Column(name = "packetID")
    private Integer packetID;

    public yourPacket(Long id, Integer packetID, String packet) {
        this.id = id;
        this.packetID= packetID;
        this.packet = packet;
    }

    public yourPacket() { }


    public Map<Integer, String> packet() throws IOException {
        parser.parseUDP();

        for (int i = 0; i < parser.getPacketList().size(); i++) {
            /*for (String p : parser.getPacketList()) {
                packetMap.put(i, p);
                System.out.println(p);
                //packetRepository.save(p);
            }*/
            packetMap.put(i,parser.getPacketList().get(i));

        }
        System.out.println(packetMap);
        return packetMap;
    }

}
