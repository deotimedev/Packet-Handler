package me.carbonpackethandler.packet;

public class PacketID extends PacketData {
    public PacketID(Packet<?> packet){
        super("id", Packets.getPacketID(packet));
    }
}
