package tcpPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;

    public void start(int port) throws IOException {

            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();  //handle each client in its own thread
            }
    }

    class ClientHandler implements Runnable {  //handles each connected client

        Socket socket;
        String name;

        public ClientHandler(Socket socket) {  //constructor
            this.socket = socket;
        }

        @Override
        public void run() {  //send and receive messages

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                name = in.readLine();  //get name of client first
                System.out.println(name + " has joined the chat!");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("quit")) {
                        System.out.println(name + " has left the chat!");
                        break;
                    }

                    System.out.println(name + ": " + message);
                    out.println("Message received");
                }

            } 
            catch (IOException e) {
                System.out.println("Connection error with " + name);
            }
            finally {
                try {
                    socket.close();
                }
                catch (IOException e) {
                    // Ignore
                }
            }
        }
    }
}