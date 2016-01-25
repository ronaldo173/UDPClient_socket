import jdk.net.Sockets;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

/**
 * Created by Alex on 25.01.2016.
 */
public class Connect {
    public static void main(String[] args) throws IOException, InterruptedException {

        DatagramSocket socket = new DatagramSocket();
        InetAddress ipAddres = InetAddress.getByName("127.0.0.1");
        int port = 6666;
        int bufSize = 63 * 1024;


        byte[] buff = new byte[bufSize];
        DatagramPacket packet = new DatagramPacket(buff, bufSize, ipAddres, port);

        Socket socket6 = new Socket(ipAddres, port);
        socket.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 7777));


        socket6.close();

    }
}
