package me.carbonpackethandler.packet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacketDataContainer implements Serializable {
    private List<PacketData> container = new ArrayList<>();

    public PacketDataContainer(){

    }

    public PacketDataContainer(PacketData[] data){
        this.container = Arrays.asList(data);
    }

    public PacketData[] getAll(){
        return this.container.toArray(new PacketData[0]);
    }

    public void addPacketData(PacketData data){
        this.container.add(data);
    }

    public void addPacketData(PacketData[] data){
        this.container.addAll(Arrays.asList(data));
    }
}
