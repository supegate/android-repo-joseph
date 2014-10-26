

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public final class EchoServer extends Thread {

    private static final int PORT = 8889;

    private EchoServer() {
    }

    public static void main(final String args[]) {
        EchoServer echoServer = new EchoServer();
        if (echoServer != null) {
            echoServer.start();
        }
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(PORT, 1);

            while (true) {
                System.out.println("JAVA EchoServer start...");
            	Socket client = server.accept();
                
                System.out.println(client);

                while (true) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(),"utf-8"));
                    System.out.print("Read from client:");
                    String textLine = reader.readLine() + "\n";
                    System.out.println(textLine);	
                    if (textLine.equalsIgnoreCase("EXIT\n")) {
                        System.out.println("EXIT invoked, closing client");
                        break;
                    }

                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"utf-8"));
                    System.out.println("Echo input to client");
                    writer.write("ECHO from server: " + textLine, 0, textLine.length() + 18);
                    writer.flush();
                }
                client.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
