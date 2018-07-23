package com.wyds.packets;



import javax.persistence.*;

@Entity
@Table(name = "pcap")
public class PacketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "packet")
    private String packet;

    @Column(name = "packetID")
    private Integer packetID;





    public PacketEntity(Long id, Integer packetID, String packet) {
        this.id = id;
        this.packetID = packetID;
        this.packet = packet;
    }

    public PacketEntity() {
    }




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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


}
