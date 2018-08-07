package com.wyds.packets;



//import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.HashMap;

//@Entity
///@Table(name = "pcap")
@RedisHash("Packet")
public class PacketEntity implements Serializable {
    private PacketMapper pm = new PacketMapper();

   // @Id
    private String id;

    @Indexed
    private String packet;

    //@Indexed
    private Integer packetID;



    public PacketEntity(String id, Integer packetID, String packet) {
        this.id = id;
        this.packetID = packetID;
        this.packet = packet;
    }

    public PacketEntity() {
    }
    public PacketEntity(String packet){
        this.packet = packet;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPacketID() {
        return packetID;
    }

    public void setPacketID(Integer packetID) {
        this.packetID = packetID;
    }


    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }

    public String concatPacket(){
        return id + " " + packet;
    }

}
