package demo.msa.hello.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameNormalizationResponse {
    private final String normalizedName;
}
