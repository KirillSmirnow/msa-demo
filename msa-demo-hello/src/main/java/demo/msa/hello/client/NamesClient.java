package demo.msa.hello.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "names", url = "http://names")
public interface NamesClient {

    @PostMapping("/names")
    NameNormalizationResponse normalizeName(NameNormalizationRequest request, @RequestHeader String dest);
}
