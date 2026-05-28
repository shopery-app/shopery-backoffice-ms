package az.shopery.backoffice_ms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "aws-ms", url = "${feign.client.config.aws-ms.url}")
public interface AwsClient {

    @GetMapping("/api/v1/aws/presigned-url")
    ResponseEntity<String> getPresignedUrl(@RequestParam String fileKey);
}
