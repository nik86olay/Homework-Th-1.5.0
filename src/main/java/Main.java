import java.io.*;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static final int PORT = 8080;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Start message");

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Received message from the client: " + msg);
                if(msg.equals("end")) break;
                msg  = String.valueOf(getNumberFibonacci(new BigInteger[Integer.parseInt(msg)]));
                out.println(msg);
                System.out.println("The sent message from the client: " + msg);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static BigInteger getNumberFibonacci(BigInteger[]arr) {
        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        return arr[arr.length-1];
    }
}
