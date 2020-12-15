/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author HP
 */
public class SocketServer {

    private int port;
    private Socket socket;
    private OutputStreamWriter osw;
    private BufferedWriter bw;
    private PrintWriter out;
    private InputStreamReader isr;
    private BufferedReader in;

    public SocketServer(int port) {
        this.port = port;
    }

    public void IniziaComunicazione() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        osw = new OutputStreamWriter(socket.getOutputStream());
        bw = new BufferedWriter(osw);
        out = new PrintWriter(bw, true);
        isr = new InputStreamReader(socket.getInputStream());
        in = new BufferedReader(isr);
    }

    public void Scrivere(String mex) {
        System.out.println(mex);
        out.println(mex);
      
    }

    public String leggere() throws IOException {
        String mex = "";
        mex = in.readLine();
        return mex;
    }

    public void ChiudiComunicazione() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
