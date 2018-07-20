package com.wyds;

import com.wyds.packets.Capture;
import org.pcap4j.core.*;
import org.pcap4j.util.NifSelector;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import java.io.IOException;


import org.pcap4j.core.BpfProgram.BpfCompileMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class PacketTracker {
    public static void main(String[] args) throws PcapNativeException, NotOpenException {

        //SpringApplication.run(PacketTracker.class, args);
        Capture c = new Capture();
        c.capturePack();



    }

    @RequestMapping(value="/")
    public String register(){
        return "login here";
    }


}
