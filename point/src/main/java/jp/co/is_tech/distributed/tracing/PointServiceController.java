package jp.co.is_tech.distributed.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class PointServiceController {
    private static final Random RANDOM = new Random();


    @GetMapping(value = "/points/me", produces = MediaType.TEXT_PLAIN_VALUE)
    public String myPoints() {
        throwExceptionRandomly();
        return "points";
    }

    private void throwExceptionRandomly() {
        if (RANDOM.nextInt(20) == 0) {
            throw new RuntimeException("caos monkey!");
        }
    }
}
