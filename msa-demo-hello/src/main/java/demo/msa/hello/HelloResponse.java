package demo.msa.hello;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloResponse {
    private final String message;
}
