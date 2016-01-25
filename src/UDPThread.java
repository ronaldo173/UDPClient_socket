import sun.plugin.com.Utils;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;

/**
 * Created by Alex on 25.01.2016.
 */
public class UDPThread extends Thread {
    private DatagramSocket socket = null;

    public UDPThread(DatagramSocket socket) {
        super("UDPThread");
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//            socket.receive(packet);

        try {
            socket.connect(InetAddress.getByName("0.0.0.0"),6666);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DatagramChannel channel = socket.getChannel();
        System.out.println(channel);

        String inputLine = new String(buffer);


        socket.close();
    }

    public static void main(String[] args) throws SocketException, UnknownHostException {
        new UDPThread(new DatagramSocket(6666, InetAddress.getByName("0.0.0.0"))).start();
    }
}