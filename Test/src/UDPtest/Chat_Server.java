package UDPtest;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Chat_Server {
    private static final int DEST_PORT = 8888;
    private static final int SEND_PORT = 10001;
    private static final int RECE_PORT = 9000;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Send_Thread send_thread = null;
            Receive_Thread receive_thread = null;
            InetSocketAddress address = null;
            address = new InetSocketAddress(IP, DEST_PORT);
            DatagramSocket sendsocket = new DatagramSocket(SEND_PORT);
            DatagramSocket recesocket = new DatagramSocket(RECE_PORT);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的用户名");
            String username = sc.next();
            System.out.println("输入成功，可以进行聊天");
            send_thread = new Send_Thread(sendsocket, address, username);
            receive_thread = new Receive_Thread(recesocket);
            send_thread.start();
            receive_thread.start();

        } catch (Exception e) {
            System.out.println("错了");
        }
    }
}
