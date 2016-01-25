import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alex on 25.01.2016.
 */
public class TCPClient {
    private static int input;

    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket echoSocket = new Socket("192.168.0.101", 6666);
        Timer timer = new Timer();
        input = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    input = input + 1;
                    doTime(echoSocket, input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 1000);
    }

    private static void doTime(Socket echoSocket, int input) throws IOException {
        try {
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            //the next 2 lines resume like: if you have to die, die fast
            int value = input;//ensure that input is an Integer
//            assert (value >= 0 && value <= 255);// ensure that the Integer is in the Delphi's Byte range
//            System.out.println("getSendBufferSize: " +echoSocket.getSendBufferSize());
            System.out.println("sending server reply number : " + value);
            out.println(value);
            System.out.println("server replies: " + in.readLine());

        } finally {
//              echoSocket.close();
        }
    }
}