package jp.co.is_tech.distributed.tracing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CartServiceController {

    private final RestTemplate restTemplate;


    @GetMapping(value = "/cart/me/total-count", produces = MediaType.TEXT_PLAIN_VALUE)
    public String totalCount() {
        return "cart total count";
    }

    @GetMapping(value = "/cart/me/detail", produces = MediaType.TEXT_PLAIN_VALUE)
    public String detail() {
        return "cart detail";
    }

    @GetMapping(value = "/cart/me/checkout", produces = MediaType.TEXT_PLAIN_VALUE)
    public String checkout() {
        String response = restTemplate.getForObject("http://localhost:8082/addresses/me", String.class);
        log.info("addresses response => {}", response);
        return "checkout cart";
    }
}
