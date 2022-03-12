package me.carbonpackethandler.packet;

import java.io.ByteArrayOutputStream;

public class SerializedPacket <T extends Packet<?>>{

    public byte[] packet;

    public SerializedPacket(ByteArrayOutputStream byteStream){
        this.packet = byteStream.toByteArray();
    }

    public PacketDataContainer deserialize(){
        try {
            return PacketData.getContainer(this);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
