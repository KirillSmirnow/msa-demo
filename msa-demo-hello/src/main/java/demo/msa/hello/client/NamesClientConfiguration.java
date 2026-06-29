package demo.msa.hello.client;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@RequiredArgsConstructor
public class NamesClientConfiguration {

    private final HttpServletRequest request;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return interceptor -> {
            Set.of("Dest").forEach(header -> {
                interceptor.header(header, request.getHeader(header));
            });
        };
    }
}
