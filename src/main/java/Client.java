import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String HOST = "localhost";

        try (Socket clientSocket = new Socket(HOST, Main.PORT);
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String msg;
            while (true) {
                System.out.print("Press your Fibonacci number: ");
                msg = scanner.nextLine();
                out.println(msg);
                if (msg.equals("end")) break;
                System.out.println("Answer: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

