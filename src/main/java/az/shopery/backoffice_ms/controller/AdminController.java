package az.shopery.backoffice_ms.controller;

import az.shopery.backoffice_ms.model.dto.request.ShopCreationRequestRejectDto;
import az.shopery.backoffice_ms.model.dto.response.AdminShopResponseDto;
import az.shopery.backoffice_ms.model.dto.response.UserProfileResponseDto;
import az.shopery.backoffice_ms.model.dto.response.task.TaskResponseDto;
import az.shopery.backoffice_ms.model.dto.shared.SuccessResponse;
import az.shopery.backoffice_ms.service.AdminService;
import az.shopery.backoffice_ms.utils.enums.TaskCategory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admins")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<SuccessResponse<Page<UserProfileResponseDto>>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(adminService.getUsers(pageable));
    }

    @PatchMapping("/users/{id}/close")
    public ResponseEntity<SuccessResponse<Void>> closeUser(@PathVariable String id) {
        return ResponseEntity.ok(adminService.closeUser(id));
    }

    @GetMapping("/shops")
    public ResponseEntity<SuccessResponse<Page<AdminShopResponseDto>>> getShops(Pageable pageable) {
        return ResponseEntity.ok(adminService.getShops(pageable));
    }

    @GetMapping("/tasks")
    public ResponseEntity<SuccessResponse<Page<TaskResponseDto>>> getTasks(@RequestParam(required = false) TaskCategory taskCategory, Pageable pageable, @RequestParam String email) {
        return ResponseEntity.ok(adminService.getTasks(taskCategory, pageable, email));
    }

    @PatchMapping("/tasks/{id}/close")
    public ResponseEntity<SuccessResponse<Void>> closeSupportTicket(@PathVariable String id, @RequestParam String email) {
        return ResponseEntity.ok(adminService.closeSupportTicket(id, email));
    }

    @PostMapping("/tasks/{id}/approve")
    public ResponseEntity<SuccessResponse<Void>> approve(@PathVariable String id, @RequestParam String email) {
        return ResponseEntity.ok(adminService.approve(id, email));
    }

    @PostMapping("/tasks/{id}/reject")
    public ResponseEntity<SuccessResponse<Void>> reject(@PathVariable String id, @Valid @RequestBody ShopCreationRequestRejectDto shopCreationRequestRejectDto, @RequestParam String email) {
        return ResponseEntity.ok(adminService.reject(id, email, shopCreationRequestRejectDto));
    }
}
