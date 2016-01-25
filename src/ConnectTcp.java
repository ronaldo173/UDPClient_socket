import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Alex on 25.01.2016.
 */
public class ConnectTcp {

    public static void main(String[] args) throws IOException {
        Socket socket;
        InetAddress ipAddres = InetAddress.getByName("127.0.0.1");
        int port = 6666;
        socket = new Socket(ipAddres, port);

        byte buf[] = new byte[65536];

        System.out.println(socket.getInetAddress());
        System.out.println(socket.getPort());
        System.out.println(socket.getSendBufferSize());

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));

        System.out.println(reader.ready());

        reader.close();
        socket.close();
    }
}
