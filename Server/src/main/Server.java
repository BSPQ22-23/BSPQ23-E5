package main;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import api.*;

public class Server {
	public static void main(String[] args){
		try {
	        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	        server.createContext("/register", new RegisterHandler());
	        server.createContext("/login", new LoginHandler());
	        server.setExecutor(null); // creates a default executor
	        server.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
