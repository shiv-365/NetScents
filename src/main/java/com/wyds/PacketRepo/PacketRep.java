package com.wyds.PacketRepo;


import com.wyds.packets.PacketEntity;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableRedisRepositories
public interface PacketRep extends CrudRepository<PacketEntity, String> {
}
