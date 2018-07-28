package hello.controller;

import hello.client.SpringHelloClient;
import hello.entity.User;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.micronaut.http.client.RxHttpClient;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

@Controller("/client")
public class StringController {

    private Logger logger = LoggerFactory.getLogger(StringController.class);

    @Inject
    private SpringHelloClient springHelloClient;

    @Client("http://localhost:8761/")
    @Inject
    RxHttpClient httpClientDirect;

    @Client("spring-cloud-test")
    @Inject
    RxHttpClient httpClientServiceDiscovery;

    // diclarative client -------------------------------------------------------------------------------------------------------------
    @Get("/declarativeClient/string")
    public String declarativeClientString() {
        return springHelloClient.string();
    }

    // Error occurred writing stream response: Unexpected character ('s' (code 115)): expected a valid value (number, String, array, object, 'true', 'false' or 'null')
    @Get("/declarativeClient/stringFlowable")
    public Flowable<String> declarativeClientStringFlowable() {
        return springHelloClient.stringFlowable();
    }

    @Get("/declarativeClient/stringJsonUtf8")
    public String declarativeClientStringJsonUtf8() {
        return springHelloClient.stringJsonUtf8();
    }

    // Error occurred writing stream response: Unexpected character ('s' (code 115)): expected a valid value (number, String, array, object, 'true', 'false' or 'null')
    @Get("/declarativeClient/stringJsonUtf8Flowable")
    public Flowable<String> declarativeClientStringJsonUtf8Flowable() {
        return springHelloClient.stringJsonUtf8Flowable();
    }

    // {"message":"Internal Server Error: Error occurred reading HTTP response: Cannot decode byte buffer with value [{\"key\" : \"value\"}] to type: Map Map"}
    @Get("/declarativeClient/map")
    public Map declarativeClientMap() {
        return springHelloClient.map();
    }

    @Get("/declarativeClient/mapFlowable")
    public Flowable<Map> declarativeClientMapFlowable() {
        return springHelloClient.mapFlowable();
    }

    @Get("/declarativeClient/mapJsonUtf8")
    public Map declarativeClientMapJsonUtf8() {
        return springHelloClient.mapJsonUtf8();
    }

    @Get("/declarativeClient/mapJsonUtf8Flowable")
    public Flowable<Map> declarativeClientMapJsonUtf8Flowable() {
        return springHelloClient.mapJsonUtf8Flowable();
    }

    // direct client -------------------------------------------------------------------------------------------------------------
    @Get("/directClient/string")
    public String directClientString() {
        return httpClientDirect.retrieve(HttpRequest.GET("/string")).blockingFirst();
    }

    @Get("/directClient/stringFlowable")
    public Flowable<String> directClientStringFlowable() {
        return httpClientDirect.retrieve(HttpRequest.GET("/string"));
    }

    @Get("/directClient/stringJsonUtf8")
    public String directClientStringJsonUtf8() {
        return httpClientDirect.retrieve(HttpRequest.GET("/stringJsonUtf8")).blockingFirst();
    }

    @Get("/directClient/stringJsonUtf8Flowable")
    public Flowable<String> directClientStringJsonUtf8Flowable() {
        return httpClientDirect.retrieve(HttpRequest.GET("/stringJsonUtf8"));
    }

    // {"message":"Internal Server Error: Error occurred reading HTTP response: Cannot decode byte buffer with value [{\"key\" : \"value\"}] to type: Map map"}
    @Get("/directClient/map")
    public Map directClientMap() {
        return httpClientDirect.retrieve(HttpRequest.GET("/map"), Map.class).blockingFirst();
    }

    // Error occurred writing stream response: Error occurred reading HTTP response: Cannot decode byte buffer with value [{"key" : "value"}] to type: Map map
    @Get("/directClient/mapFlowable")
    public Flowable<Map> directClientMapFlowable() {
        return httpClientDirect.retrieve(HttpRequest.GET("/map"), Map.class);
    }

    @Get("/directClient/mapJsonUtf8")
    public Map directClientMapJsonUtf8() {
        return httpClientDirect.retrieve(HttpRequest.GET("/mapJsonUtf8"), Map.class).blockingFirst();
    }

    @Get("/directClient/mapJsonUtf8Flowable")
    public Flowable<Map> directClientMapJsonUtf8Flowable() {
        return httpClientDirect.retrieve(HttpRequest.GET("/mapJsonUtf8"), Map.class);
    }

    @Get("/directClient/user")
    public User directClientUser() {
        return httpClientDirect.retrieve(HttpRequest.GET("/user"), User.class).blockingFirst();
    }

    @Get("/directClient/userFlowable")
    public Flowable<User> directClientUserFlowable() {
        return httpClientDirect.retrieve(HttpRequest.GET("/user"), User.class);
    }

    @Get("/directClient/userJsonUtf8")
    public User directClientUserJsonUtf8() {
        return httpClientDirect.retrieve(HttpRequest.GET("/userJsonUtf8"), User.class).blockingFirst();
    }

    @Get("/directClient/userJsonUtf8Flowable")
    public Flowable<User> directClientUserJsonUtf8Flowable() {
        return httpClientDirect.retrieve(HttpRequest.GET("/userJsonUtf8"), User.class);
    }

    @Get("/directClient/userToMap")
    public Map directClientUserToMap() {
        return httpClientDirect.retrieve(HttpRequest.GET("/user"), Map.class).blockingFirst();
    }


    // ServiceDiscovery client -------------------------------------------------------------------------------------------------------------
    @Get("/serviceDiscoveryClient/string")
    public String serviceDiscoveryClientString() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/string")).blockingFirst();
    }

    @Get("/serviceDiscoveryClient/stringFlowable")
    public Flowable<String> serviceDiscoveryClientStringFlowable() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/string"));
    }

    @Get("/serviceDiscoveryClient/stringJsonUtf8")
    public String serviceDiscoveryClientStringJsonUtf8() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/stringJsonUtf8")).blockingFirst();
    }

    @Get("/serviceDiscoveryClient/stringJsonUtf8Flowable")
    public Flowable<String> serviceDiscoveryClientStringJsonUtf8Flowable() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/stringJsonUtf8"));
    }

    // {"message":"Internal Server Error: Error occurred reading HTTP response: Cannot decode byte buffer with value [{\"key\" : \"value\"}] to type: Map map"}
    @Get("/serviceDiscoveryClient/map")
    public Map serviceDiscoveryClientMap() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/map"), Map.class).blockingFirst();
    }

    // Error occurred writing stream response: Error occurred reading HTTP response: Cannot decode byte buffer with value [{"key" : "value"}] to type: Map map
    @Get("/serviceDiscoveryClient/mapFlowable")
    public Flowable<Map> serviceDiscoveryClientMapFlowable() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/map"), Map.class);
    }

    @Get("/serviceDiscoveryClient/mapJsonUtf8")
    public Map serviceDiscoveryClientMapJsonUtf8() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/mapJsonUtf8"), Map.class).blockingFirst();
    }

    @Get("/serviceDiscoveryClient/mapJsonUtf8Flowable")
    public Flowable<Map> serviceDiscoveryClientMapJsonUtf8Flowable() {
        return httpClientServiceDiscovery.retrieve(HttpRequest.GET("/mapJsonUtf8"), Map.class);
    }
}
