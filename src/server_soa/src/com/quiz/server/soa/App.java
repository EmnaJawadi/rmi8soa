package server_soa.src.com.quiz.server.soa;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import java.net.URI;

public class App {

    public static void main(String[] args) {
        URI baseUri = URI.create("http://0.0.0.0:8080/");
        ResourceConfig config = new ResourceConfig()
                .packages("com.quiz.server.soa.controllers");

        JettyHttpContainerFactory.createServer(baseUri, config);

        System.out.println("REST server started at " + baseUri);
    }
}
