package hello.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.reactivex.Flowable;

import java.util.Map;

@Client("spring-cloud-test")
public interface SpringHelloClient {

    @Get(value = "/hello")
    Flowable<String> handleRemoteInfo();

    @Get(value = "/hello")
    String handleRemoteInfo2();

    @Get(value = "/string")
    String string();

    @Get(value = "/string")
    Flowable<String> stringFlowable();

    @Get(value = "/stringJsonUtf8")
    String stringJsonUtf8();

    @Get(value = "/stringJsonUtf8")
    Flowable<String> stringJsonUtf8Flowable();

    @Get(value = "/map")
    Map map();

    @Get(value = "/map")
    Flowable<Map> mapFlowable();

    @Get(value = "/mapJsonUtf8")
    Map mapJsonUtf8();

    @Get(value = "/mapJsonUtf8")
    Flowable<Map> mapJsonUtf8Flowable();
}
