package demo.msa.hello;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloRequest {
    private final String name;
}
