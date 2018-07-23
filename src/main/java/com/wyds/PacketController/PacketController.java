package com.wyds.PacketController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacketController {


    @RequestMapping("/")
    public String whatUp(){
        return " Packet sniffing is awesome. Hello!";
    }


    @RequestMapping("/wyd")
    public String wydHere(){
        return "Show me ur packets";
    }


}
