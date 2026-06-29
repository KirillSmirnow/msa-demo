package demo.msa.hello.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "names", url = "http://names", configuration = NamesClientConfiguration.class)
public interface NamesClient {

    @PostMapping("/names")
    NameNormalizationResponse normalizeName(NameNormalizationRequest request);
}
