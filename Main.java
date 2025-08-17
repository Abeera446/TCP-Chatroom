import tcpPackage.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 's' if you're Server or 'c' if you're Client:");
        char ch = sc.next().charAt(0);

        if (ch == 's') {
            System.out.println("Enter port number:");
            int port = sc.nextInt();

            Server server = new Server();

            try {
                server.start(port);
            }
            catch (Exception e) {
                System.out.println("Server error: " + e.getMessage());
            }
        }

        else if (ch == 'c') {

            sc.nextLine();
            System.out.println("Enter IP address of server you want to connect with:");
            String IPAddress = sc.nextLine();

            System.out.println("Enter port number:");
            int port = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter your name:");
            String name = sc.nextLine();

            Client client = new Client(IPAddress, port, name);
            System.out.println("Type messages to send to server. Type 'quit' to exit.");

            try {
                client.send();
            }
            catch (Exception e) {
                System.out.println("Client error: " + e.getMessage());
            }
        }

        else {
            System.out.println("Invalid input.");
        }
    }
}