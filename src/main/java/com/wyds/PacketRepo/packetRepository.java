package com.wyds.PacketRepo;

import org.pcap4j.packet.Packet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface packetRepository extends JpaRepository<Packet, Long> {
}
