package com.wyds;

import com.wyds.packets.Capture;
import com.wyds.packets.PacketMapper;
import com.wyds.packets.PacketParser;
import com.wyds.packets.PacketEntity;
import org.pcap4j.core.*;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PacketTracker {
    public static void main(String[] args) throws PcapNativeException, NotOpenException, IOException {

        Capture c = new Capture();
        PacketParser parser = new PacketParser();
        PacketMapper pm = new PacketMapper();

        //runners
        SpringApplication.run(PacketTracker.class, args);
        c.capturePack();
        parser.parseUDP();
        pm.packet();



       //<------------------------------------------------------>
        //mvn package
        //sudo java -jar target/uber-pcap-1.0.0.jar
        //mvn spring-boot:run

    }


}
