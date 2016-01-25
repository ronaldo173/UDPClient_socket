/**
 * Created by Alex on 26.01.2016.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelExample {

    public static void main(String[] args) throws IOException,
            InterruptedException {
        int port = 6666;
        SocketChannel channel = SocketChannel.open();

        // we open this channel in non blocking mode
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", port));

        while (!channel.finishConnect()) {
            // System.out.println("still connecting");
        }
        while (true) {
            // see if any message has been received
            ByteBuffer bufferA = ByteBuffer.allocate(20);
            int count = 0;
            String message = "";
            while ((count = channel.read(bufferA)) > 0) {
                // flip the buffer to start reading
                bufferA.flip();
                message += Charset.defaultCharset().decode(bufferA);
            }
           if (message.length()!=0){
               System.out.println(message);
           }

        }
    }
}