package jp.co.is_tech.distributed.tracing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@RestController
public class BffController {
    private final RestTemplate restTemplate;


    @GetMapping(value = "/top", produces = MediaType.TEXT_PLAIN_VALUE)
    public String top() {
        log.info("addresses response => {}", restTemplate.getForObject("http://localhost:8082/addresses/me/default", String.class));
        log.info("points response => {}", restTemplate.getForObject("http://localhost:8083/points/me", String.class));
        log.info("accounts response => {}", restTemplate.getForObject("http://localhost:8084/accounts/me", String.class));
        log.info("cart response => {}", restTemplate.getForObject("http://localhost:8086/cart/me/total-count", String.class));

        return "top";
    }

    @GetMapping(value = "/order-history/me", produces = MediaType.TEXT_PLAIN_VALUE)
    public String orderHistory() {
        log.info("order history response => {}", restTemplate.getForObject("http://localhost:8085/order-history/me", String.class));
        return "order history from top";
    }

    @GetMapping(value = "/cart/me/detail", produces = MediaType.TEXT_PLAIN_VALUE)
    public String myCart() {
        log.info("cart me detail response => {}", restTemplate.getForObject("http://localhost:8086/cart/me/detail", String.class));
        return "cart me detail from top";
    }

    @GetMapping(value = "/cart/me/checkout", produces = MediaType.TEXT_PLAIN_VALUE)
    public String scenarioD() {
        log.info("cart me checkout response => {}", restTemplate.getForObject("http://localhost:8086/cart/me/checkout", String.class));
        return "cart me checkout from top";
    }
}
