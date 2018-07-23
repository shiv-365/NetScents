package com.wyds;

import com.wyds.PacketRepo.packetRepository;
import com.wyds.packets.Capture;
import com.wyds.packets.PacketParser;
import com.wyds.packets.yourPacket;
import org.pcap4j.core.*;

import java.io.IOException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class PacketTracker {
    public static void main(String[] args) throws PcapNativeException, NotOpenException, IOException {

       // SpringApplication.run(PacketTracker.class, args);
        Capture c = new Capture();
        PacketParser parser = new PacketParser();
        yourPacket packet = new yourPacket();

        //runners
        c.capturePack();
        parser.parseUDP();
        packet.packet();



       //<------------------------------------------------------>
        //mvn package
        //sudo java -jar target/uber-pcap-1.0.0.jar
        //mvn spring-boot:run

    }


}
