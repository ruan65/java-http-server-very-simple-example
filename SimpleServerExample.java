import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleServerExample {

    public static void main(String[] args) throws IOException {

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8899), 0);

        httpServer.createContext("/awesome", exchange -> {

            String response = "This is freaking awesome!!!";

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream responseBody = exchange.getResponseBody();

            responseBody.write(response.getBytes());

            responseBody.close();
        });

        httpServer.createContext("/cool", exchange -> {

            String response = "This is freaking Coooooool!!!";

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream responseBody = exchange.getResponseBody();

            responseBody.write(response.getBytes());

            responseBody.close();
        });

        httpServer.createContext("/shutup", exchange -> {

            httpServer.stop(0);
        });

        httpServer.start();
    }
}
