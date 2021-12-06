import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 8080;
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Кто-то хочет узнать число!");
            final int input = Integer.parseInt(in.readLine());

            out.println(String.format("Привет!, твое число: %s", calculateFibonacci(input)));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculateFibonacci(int input) {
        if (input <= 1) {
            return 0;
        } else if (input == 2) {
            return 1;
        } else {
            return calculateFibonacci(input - 1) + calculateFibonacci(input - 2);
        }
    }

}
