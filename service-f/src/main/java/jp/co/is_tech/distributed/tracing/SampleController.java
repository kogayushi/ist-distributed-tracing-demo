package jp.co.is_tech.distributed.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {
    private static final String SERVICE_NAME = "service-f";


    @GetMapping(value = "/scenario-d", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioD() {
        String response = SERVICE_NAME;
        return response;
    }
}
