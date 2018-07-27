package hello.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.reactivex.Flowable;

@Client("spring-cloud-test")
public interface SpringHelloClient {

    @Get(value = "/hello")
    Flowable<String> handleRemoteInfo();

    @Get(value = "/hello")
    String handleRemoteInfo2();
}
