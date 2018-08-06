package com.wyds.PacketRepo;


import com.wyds.packets.PacketEntity;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface PacketRepository extends CrudRepository<PacketEntity, String> {

}
