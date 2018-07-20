package com.wyds.packets;

import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.packet.Packet;
import io.pkts.protocol.Protocol;

import java.io.IOException;

public class PacketParser {

    public static void main(String[] args) throws IOException {

        final Pcap pcap = Pcap.openStream("output.pcap");

        pcap.loop(new PacketHandler() {
            @Override
            public boolean nextPacket(Packet packet) throws IOException {
                if(packet.hasProtocol(Protocol.ARP)){

                }
                if(packet.hasProtocol(Protocol.TCP)){

                }
                if(packet.hasProtocol(Protocol.UDP)){

                }
                if(packet.hasProtocol(Protocol.TLS)){

                }
                if(packet.hasProtocol(Protocol.IPv4)){

                }
                if(packet.hasProtocol(Protocol.)){

                }



                return false;
            }
        });

    }



}
