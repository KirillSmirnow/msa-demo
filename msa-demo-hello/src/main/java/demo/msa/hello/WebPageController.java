package demo.msa.hello;

import demo.msa.hello.client.IpAddressClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;

@RestController
@RequiredArgsConstructor
public class WebPageController {

    private final IpAddressClient ipAddressClient;

    private final String template = readResource("/static/index.html");

    @SneakyThrows
    private String readResource(String name) {
        try (var reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name)))) {
            return reader.lines().collect(joining("\n"));
        }
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getWebPage() {
        var myIpAddress = ipAddressClient.getMyIpAddress();
        return template.replace("{{ serverAddress }}", myIpAddress);
    }
}
