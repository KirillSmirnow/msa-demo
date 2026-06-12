package demo.msa.hello.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameNormalizationRequest {
    private final String originalName;
}
