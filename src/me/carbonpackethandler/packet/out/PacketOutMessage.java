package me.carbonpackethandler.packet.out;


import me.carbonpackethandler.packet.PacketField;

// Example packet
public class PacketOutMessage extends PacketOut<PacketOutMessage> {

    @PacketField
    private String message;

    public PacketOutMessage(String message){
        this.message = message;
    }
}
