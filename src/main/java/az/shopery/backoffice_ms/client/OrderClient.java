package az.shopery.backoffice_ms.client;

import az.shopery.model.dto.response.OrderResponseDto;
import az.shopery.model.dto.shared.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "order-ms", url = "${feign.client.config.order-ms.url}")
public interface OrderClient {

    @GetMapping("/api/v1/users/me/orders")
    ResponseEntity<SuccessResponse<List<OrderResponseDto>>> getMyOrders(@RequestParam String email);
}
