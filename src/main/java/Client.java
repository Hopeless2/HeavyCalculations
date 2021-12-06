import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             Scanner scanner = new Scanner(System.in);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Введите номер в ряде Фибоначчи");
            String input = scanner.nextLine();
            out.println(input);
            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
