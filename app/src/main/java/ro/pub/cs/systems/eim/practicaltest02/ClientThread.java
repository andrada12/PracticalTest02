package ro.pub.cs.systems.eim.practicaltest02;


import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientThread extends Thread {

    private String address;
    private int port;
    private String informationType;
    private TextView rateTextView;

    private Socket socket;

    public ClientThread(String address, int port,  String informationType, TextView rateTextView) {
        this.address = address;
        this.port = port;
        this.informationType = informationType;
        this.rateTextView = rateTextView;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(address, port);
            if (socket == null) {
                Log.e(Constants.TAG, "[CLIENT THREAD] Could not create socket!");
                return;
            }
            BufferedReader bufferedReader = Utilities.getReader(socket);
            PrintWriter printWriter = Utilities.getWriter(socket);
            if (bufferedReader == null || printWriter == null) {
                Log.e(Constants.TAG, "[CLIENT THREAD] Buffered Reader / Print Writer are null!");
                return;
            }
            printWriter.println(informationType);
            printWriter.flush();
            printWriter.println(informationType);
            printWriter.flush();
            String rateInformation;
            while ((rateInformation = bufferedReader.readLine()) != null) {
                final String finalizedRateInformation = rateInformation;
                rateTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        rateTextView.setText(finalizedRateInformation);
                    }
                });
            }
        } catch (IOException ioException) {
            Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
            if (Constants.DEBUG) {
                ioException.printStackTrace();
            }
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
                    if (Constants.DEBUG) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }

}

