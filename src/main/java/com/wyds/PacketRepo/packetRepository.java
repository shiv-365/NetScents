package com.wyds.PacketRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface packetRepository extends JpaRepository<String, Long> {
    // String save(String p);
}
