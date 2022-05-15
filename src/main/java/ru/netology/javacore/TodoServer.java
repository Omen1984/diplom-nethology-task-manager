package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    Todos todos;
    Gson gson;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
        this.gson = new GsonBuilder().create();
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            final String inputJsonTask = in.readLine();

            final JsonObject root = JsonParser.parseString(inputJsonTask).getAsJsonObject();

            String type = root.get("type").toString().replaceAll("\"", "");
            String task = root.get("task").toString().replaceAll("\"", "");

            switch (type) {
                case "ADD":
                    todos.addTask(task);
                    break;
                case "REMOVE":
                    todos.removeTask(task);
                    break;
            }

            out.println("Задачи: " + todos.getAllTasks());
        }
    }
}
