package az.shopery.backoffice_ms.client;

import az.shopery.backoffice_ms.model.dto.response.GetFileResponseDto;
import az.shopery.backoffice_ms.model.dto.shared.SuccessResponse;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "filenet-ms", url = "${feign.client.config.filenet-ms.url}")
public interface FilenetClient {

    @GetMapping("/api/v1/files/{id}")
    ResponseEntity<SuccessResponse<GetFileResponseDto>> getFile(@PathVariable("id") UUID id);
}
