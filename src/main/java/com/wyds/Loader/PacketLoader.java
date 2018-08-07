package com.wyds.Loader;

import com.wyds.PacketRepo.PacketRep;
import com.wyds.packets.PacketEntity;
import com.wyds.packets.PacketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PacketLoader implements ApplicationRunner {

    private PacketRep pr;

    private PacketMapper pm;

    @Autowired
    public PacketLoader(PacketRep pr){
        this.pr=pr;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {


        List<PacketEntity> pel = new ArrayList<>();

        pel.add(new PacketEntity("test1",99990,"testPacket"));
        pel.add(new PacketEntity("test2", 99991,"thisisapacket"));
        pel.add( new PacketEntity("test3", 99992, "mary had a little lamb that wasa very sad"));
        pel.add( new PacketEntity("test4", 99993, "a"));
        //pel.add(new PacketEntity(pm.packetL().get(0)));


       /*for(int i = 0; i < pm.packetL().size(); i++){
            pel.add(new PacketEntity(pm.packetL().get(i)));
       }*/


      for (PacketEntity e: pel) {
          this.pr.save(e);
      }




    }
}
