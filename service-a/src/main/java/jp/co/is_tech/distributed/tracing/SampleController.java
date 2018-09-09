package jp.co.is_tech.distributed.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class SampleController {
    private static final String SERVICE_NAME = "service-a";
    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/scenario-a", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioA() {
        String response = SERVICE_NAME + " => " + restTemplate.getForObject("http://localhost:8082/scenario-a", String.class);
        return response;
    }

    @GetMapping(value = "/scenario-b", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioB() {
        String response = SERVICE_NAME + " => " + restTemplate.getForObject("http://localhost:8084/scenario-b", String.class);
        return response;
    }

    @GetMapping(value = "/scenario-c", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioC() {
        String response = SERVICE_NAME + " => " + restTemplate.getForObject("http://localhost:8084/scenario-c", String.class);
        return response;
    }

    @GetMapping(value = "/scenario-d", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioD() {
        String response = SERVICE_NAME + " => " + restTemplate.getForObject("http://localhost:8084/scenario-d", String.class);
        return response;
    }
}
