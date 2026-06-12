package demo.msa.names;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameNormalizationResponse {
    private final String normalizedName;
}
