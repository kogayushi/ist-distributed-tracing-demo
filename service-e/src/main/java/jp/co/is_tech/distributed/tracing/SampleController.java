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
    private static final String SERVICE_NAME = "service-e";
    private static final Random RANDOM = new Random();
    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/scenario-c", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioC() {
        stopTheWorld();
        String response = SERVICE_NAME + " => " + restTemplate.getForObject("http://localhost:8083/scenario-c", String.class);
        return response;
    }

    @GetMapping(value = "/scenario-d", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioD() {
        stopTheWorld();
        String response = SERVICE_NAME + " => " + restTemplate.getForObject("http://localhost:8086/scenario-d", String.class);
        return response;
    }

    public void stopTheWorld() {
        if(RANDOM.nextInt(30) == 0) {
            try {
                Thread.sleep(250L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
