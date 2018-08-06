package com.wyds.packets;

import org.pcap4j.core.*;
import org.pcap4j.util.NifSelector;

import java.io.IOException;

public class Capture {


    public void capturePack() throws PcapNativeException, NotOpenException {

        int snapShotLength = 65536;
        int timeOut = 50;
        final PcapHandle handle;
        final PcapNetworkInterface device = deviceCheck();

        handle = device.openLive(snapShotLength, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, timeOut);


        String filter = "";
        handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);

        PcapDumper dumper = handle.dumpOpen("output.pcap");

        /**
           @param anonymous class
         */
        PacketListener listener = packet -> {

            try {
                dumper.dump(packet, handle.getTimestamp());
            } catch (NotOpenException e) {
               e.printStackTrace();
            }


        };

        /**
         * @param maxPackets, change this to desired amount. maybe a while loop?
         */
        try {
            int maxPackets = 100;
            handle.loop(maxPackets, listener);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }


        PcapStat stats = handle.getStats();

        System.out.println("Packets received: " + stats.getNumPacketsReceived());

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
