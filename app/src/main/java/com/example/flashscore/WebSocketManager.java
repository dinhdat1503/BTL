package com.example.flashscore;

import android.util.Log;

import okhttp3.*;

public class WebSocketManager {

    private static WebSocket webSocket;
    private static final String SOCKET_URL = "wss://your-sniffed-url"; // Thay URL bạn sniff được

    public static void startWebSocket(Listener listener) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(SOCKET_URL).build();

        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                Log.d("WebSocket", "Connected");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                listener.onMessageReceived(text);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Log.e("WebSocket", "Error: " + t.getMessage());
            }
        });
    }

    public interface Listener {
        void onMessageReceived(String message);
    }
}
