package me.carbonpackethandler.packet;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacketData implements Serializable {
    private String key;
    private Object value;

    public PacketData(String key, Object value){
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return this.key;
    }

    public Object getValue(){
        return this.value;
    }

    public static PacketData[] getAllData(Packet<?> packet){
        List<PacketData> dataList = new ArrayList<>();
        Arrays.stream(packet.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(PacketField.class))
                .forEach(f -> {
                    f.setAccessible(true);
                    try {
                        dataList.add(new PacketData(f.getName(), f.get(packet)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return dataList.toArray(new PacketData[0]);
    }

    public static PacketDataContainer getContainer(SerializedPacket<?> packet){
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(packet.packet);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            return (PacketDataContainer) objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
