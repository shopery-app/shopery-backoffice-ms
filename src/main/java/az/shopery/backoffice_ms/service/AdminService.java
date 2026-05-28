package az.shopery.backoffice_ms.service;

import az.shopery.backoffice_ms.model.dto.request.ShopCreationRequestRejectDto;
import az.shopery.backoffice_ms.model.dto.response.AdminShopResponseDto;
import az.shopery.backoffice_ms.model.dto.response.UserProfileResponseDto;
import az.shopery.backoffice_ms.model.dto.response.task.TaskResponseDto;
import az.shopery.backoffice_ms.model.dto.shared.SuccessResponse;
import az.shopery.backoffice_ms.utils.enums.TaskCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {
    SuccessResponse<Page<UserProfileResponseDto>> getUsers(Pageable pageable);
    SuccessResponse<Void> closeUser(String id);
    SuccessResponse<Void> closeSupportTicket(String id, String userEmail);
    SuccessResponse<Void> approve(String id, String userEmail);
    SuccessResponse<Void> reject(String id, String userEmail, ShopCreationRequestRejectDto shopCreationRequestRejectDto);
    SuccessResponse<Page<TaskResponseDto>> getTasks(TaskCategory taskCategory, Pageable pageable, String userEmail);
    SuccessResponse<Page<AdminShopResponseDto>> getShops(Pageable pageable);
}
