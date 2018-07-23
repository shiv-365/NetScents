package com.wyds.packets;

import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.PcapOutputStream;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.packet.TCPPacket;
import io.pkts.packet.UDPPacket;
import io.pkts.protocol.Protocol;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PacketParser {





    /**
     * @param arrayList for storing udp packet buffers
     */
     private List<String> packetList;

    public List<String> parseUDP() throws IOException {

        final Pcap pcap = Pcap.openStream("output.pcap");
        packetList = new ArrayList<>();


        pcap.loop(packet -> {


            if (packet.hasProtocol(Protocol.UDP)) {

                UDPPacket udpPacket = (UDPPacket) packet.getPacket(Protocol.UDP);
                Buffer buffer = udpPacket.getPayload();
                if (buffer != null) {
                    packetList.add(buffer.toString());
                }
            }

            return true;
        });

        return packetList;
    }

    /**
     * @return packet list of decrypted UDP packets
     */
    public List<String> getPacketList() {
        return packetList;
    }

}
