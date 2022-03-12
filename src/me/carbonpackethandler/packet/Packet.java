package me.carbonpackethandler.packet;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public abstract class Packet<T extends Packet<?>> {

    protected Packet(){
        // do not initialize
    }

    public SerializedPacket<T> serialize(){
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
            PacketDataContainer container = new PacketDataContainer();
            container.addPacketData(new PacketID(this)); // assigns id to packet
            container.addPacketData(PacketData.getAllData(this));
            outputStream.writeObject(container);
            SerializedPacket<T> serialized = new SerializedPacket<T>(byteStream);
            return serialized;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
