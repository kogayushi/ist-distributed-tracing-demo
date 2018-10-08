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
public class OrderHistoryServiceController {
    private static final Random RANDOM = new Random();
    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/order-history/me", produces = MediaType.TEXT_PLAIN_VALUE)
    public String myOrderHistory() {
        stopTheWorld();
        return "order history me";
    }
    public void stopTheWorld() {
        if(RANDOM.nextInt(30) == 0) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
