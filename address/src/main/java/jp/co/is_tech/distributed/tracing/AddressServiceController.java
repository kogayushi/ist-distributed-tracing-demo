package jp.co.is_tech.distributed.tracing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AddressServiceController {

    @GetMapping(value = "/addresses/me/default", produces = MediaType.TEXT_PLAIN_VALUE)
    public String defaultAddress() {
        return "default-address";
    }

    @GetMapping(value = "/addresses/me", produces = MediaType.TEXT_PLAIN_VALUE)
    public String addresses() {
        return "addresses";
    }
}
