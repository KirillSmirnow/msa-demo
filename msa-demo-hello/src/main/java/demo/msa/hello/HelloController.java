package demo.msa.hello;

import demo.msa.hello.client.IpAddressClient;
import demo.msa.hello.client.NameNormalizationRequest;
import demo.msa.hello.client.NamesClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final NamesClient namesClient;
    private final IpAddressClient ipAddressClient;

    @Value("${feature:none}")
    private String feature;

    @PostMapping("/hello")
    @SneakyThrows
    public HelloResponse sayHello(@RequestBody HelloRequest request, @RequestHeader Map<String, String> headers) {
        var name = request.getName();
        var normalizedName = normalizeName(name, headers);
        var localHostAddress = InetAddress.getLocalHost();
        var myIpAddress = ipAddressClient.getMyIpAddress();
        return HelloResponse.builder()
                .message("Hello to %s from %s at %s [%s] 👋".formatted(normalizedName, localHostAddress, myIpAddress, feature))
                .build();
    }

    private String normalizeName(String name, Map<String, String> headers) {
        var dest = headers.get("dest");
        return namesClient.normalizeName(NameNormalizationRequest.builder().originalName(name).build(), dest).getNormalizedName();
    }
}
