package az.shopery.backoffice_ms.utils.common;

import az.shopery.backoffice_ms.client.FilenetClient;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilenetClientHelper {

    private final FilenetClient filenetClient;

    public byte[] getFile(UUID fileId) {
        var response = filenetClient.getFile(fileId);

        if (Objects.isNull(response.getBody()) || Objects.isNull(response.getBody().getData())) {
            return null;
        }

        return response.getBody().getData().getContent();
    }
}

