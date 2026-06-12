package demo.msa.hello.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ip-address", url = "https://api.ipify.org")
public interface IpAddressClient {

    @GetMapping
    String getMyIpAddress();
}
