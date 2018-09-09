package jp.co.is_tech.distributed.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Slf4j
@RestController
public class SampleController {
    private static final String SERVICE_NAME = "service-c";
    private static final Random RANDOM = new Random();
    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/scenario-a", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioA() {
        throwExceptionRandomly();
        String response = SERVICE_NAME;
        return response;
    }

    @GetMapping(value = "/scenario-c", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioC() {
        throwExceptionRandomly();
        String response = SERVICE_NAME;
        return response;
    }

    private void throwExceptionRandomly() {
        if (RANDOM.nextInt(20) == 0) {
            throw new RuntimeException("caos monkey!");
        }
    }
}
