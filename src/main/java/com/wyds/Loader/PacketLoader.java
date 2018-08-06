package com.wyds.Loader;

import com.wyds.PacketRepo.PacketRepository;
import com.wyds.packets.PacketEntity;
import com.wyds.packets.PacketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@Service
public class PacketLoader implements ApplicationRunner {

    private  PacketRepository pr;

    private PacketMapper pm;

    @Autowired
    public PacketLoader(PacketRepository pr){
        this.pr=pr;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {



        PacketEntity[] pe = new PacketEntity[]{new PacketEntity("1",2,"testPacket")
        ,new PacketEntity("1", 2,"thisisapacket"), new PacketEntity("3", 3, "mary had a little lamb that wasa very sad")


        };



        for (PacketEntity e : pe){
            this.pr.save(e);
        }
    }
}
