package demo.msa.names;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NamesController {

    @PostMapping("/names")
    public NameNormalizationResponse normalizeName(@RequestBody NameNormalizationRequest request) {
        var originalName = request.getOriginalName();
        var trimmedName = originalName.trim();
        var normalizedName = Character.toUpperCase(trimmedName.charAt(0)) + trimmedName.substring(1).toLowerCase();
        return NameNormalizationResponse.builder()
                .normalizedName(normalizedName)
                .build();
    }
}
