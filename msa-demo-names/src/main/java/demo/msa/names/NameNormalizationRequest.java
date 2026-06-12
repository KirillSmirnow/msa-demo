package demo.msa.names;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameNormalizationRequest {
    private final String originalName;
}
