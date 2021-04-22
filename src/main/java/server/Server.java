package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void run() throws Exception {

        ServerSocket serverSocket = new ServerSocket(6789 );
        System.out.println("Listening for connections...\r\n");

        while(true) {

            Socket connectionSocket = serverSocket.accept();
            Thread connectionThread = new Thread(new Connection(connectionSocket));
            connectionThread.start();
            System.out.println("New connection on port 6789...\r\n");
        }
    }
}

