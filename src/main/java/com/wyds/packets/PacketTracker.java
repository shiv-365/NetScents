package com.wyds.packets;

import org.pcap4j.core.*;
import org.pcap4j.util.NifSelector;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import java.io.IOException;


import org.pcap4j.core.BpfProgram.BpfCompileMode;


public class PacketTracker {
    public static void main(String[] args) throws PcapNativeException, NotOpenException {

        PacketTracker p = new PacketTracker();
        p.capturePack();

    }

    private void capturePack() throws PcapNativeException, NotOpenException {

        int snapShotLength = 65536;
        int timeOut = 50;
        final PcapHandle handle;
        final PcapNetworkInterface device = deviceCheck();

        handle = device.openLive(snapShotLength, PromiscuousMode.PROMISCUOUS, timeOut);


        String filter = "";
        handle.setFilter(filter, BpfCompileMode.OPTIMIZE);

        PcapDumper dumper = handle.dumpOpen("output.pcap");

        //anonymous class
        PacketListener listener = packet -> {

            System.out.println(handle.getTimestamp());
            System.out.println(packet);
            //System.out.println(packet.toString());



            try {
                dumper.dump(packet, handle.getTimestamp());
            } catch (NotOpenException e) {
                e.printStackTrace();
            }

        };
        try {
            int maxPackets = 40;
            handle.loop(maxPackets, listener);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        PcapStat stats = handle.getStats();

        System.out.println("Packets received: " + stats.getNumPacketsReceived());
        System.out.println("Packets dropped: " + stats.getNumPacketsDropped());
        System.out.println("Packets captured: "+ stats.getNumPacketsCaptured());


        dumper.close();
        handle.close();



    }


    private PcapNetworkInterface deviceCheck() {

        PcapNetworkInterface device = null;

        try {
            device = new NifSelector().selectNetworkInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Device: " + device);

        if (device == null) {
            System.out.println("no device chosen.");
            System.exit(1);
        }

        return device;
    }

}
