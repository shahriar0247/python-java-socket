import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public void main() {

        Socket sock = null;
        try {
            sock = new Socket("193.161.193.99", 44313);
            send(sock, "hello");
            String lol = recv(sock);
            System.out.println(lol);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void send(Socket sock, String text) throws IOException {
        PrintWriter outs = new PrintWriter(sock.getOutputStream(), true);
        outs.println(text);
    }

    String recv(Socket sock) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String str = br.readLine();
        return str;
    }
}
