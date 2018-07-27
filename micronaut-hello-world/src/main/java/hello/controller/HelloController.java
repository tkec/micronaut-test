package hello.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.micronaut.http.client.RxHttpClient;
import io.reactivex.Flowable;
import hello.client.SpringHelloClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller("/")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Inject
    private SpringHelloClient springHelloClient;

    @Client("http://localhost:8761/")
    @Inject
    RxHttpClient httpClientLocal;

    @Get("/helloSpringCloud")
    public Flowable<String> helloSpring() {
        return springHelloClient.handleRemoteInfo();
    }

    @Get("/helloSpringCloud2")
    public String helloSpring2() {
        return springHelloClient.handleRemoteInfo2();
    }

    @Get("/helloSpringWithIp")
    public String helloSpringWithIp() {
        return httpClientLocal.retrieve(HttpRequest.GET("/hello")).blockingFirst();
    }
}
