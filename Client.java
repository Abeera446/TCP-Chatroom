package tcpPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String ip;
    int port;
    String name;

    public Client(String ip, int port, String name) {  //constructor
        this.ip = ip;
        this.port = port;
        this.name = name;
    }

    public void send() {  //send and receive messages

        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            out.println(name);  //send the name to server

            String message;
            while (true) {
                System.out.print("You: ");
                message = sc.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("quit")) {
                    System.out.println("You left the chat.");
                    break;
                }

                String response = in.readLine();
                System.out.println("Server: " + response);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}