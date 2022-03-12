package me.carbonpackethandler.packet;

import me.carbonpackethandler.packet.out.PacketOutMessage;

import java.util.Arrays;

public enum Packets {
    MESSAGE(PacketOutMessage.class, 0);

    public Class<? extends Packet<?>> packetClass;
    public int id;

    Packets(Class<? extends Packet<?>> packetClass, int id){
        this.packetClass = packetClass;
        this.id = id;
    }

    public static int getPacketID(Packet<?> packet){
        return Arrays.stream(Packets.values())
                .filter(p -> p.packetClass == packet.getClass())
                .findFirst().get().id;
    }

}
