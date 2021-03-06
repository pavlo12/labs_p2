
import ua.diamant.FileHeandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Created by stas on 21.08.2017.
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6666)) {
            FileHeandler BFH = new FileHeandler();
            Path path = Paths.get("file.txt");
            byte [] bytes = BFH.fileRead(path);
            OutputStream outputStream = socket.getOutputStream();
//            for (int i = 0; i < bytes.length ; i++) {
                outputStream.write(bytes);
//                outputStream.write(bytes[i]);
//            }
            outputStream.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
