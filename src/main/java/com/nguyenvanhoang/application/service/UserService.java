package com.nguyenvanhoang.application.service;


import com.nguyenvanhoang.application.model.dto.UserDTO;
import com.nguyenvanhoang.application.model.request.ChangePasswordRequest;
import com.nguyenvanhoang.application.model.request.CreateUserRequest;
import com.nguyenvanhoang.application.model.request.UpdateProfileRequest;
import com.nguyenvanhoang.application.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getListUsers();

    Page<User> adminListUserPages(String fullName, String phone, String email, Integer page);

    User createUser(CreateUserRequest createUserRequest);

    void changePassword(User user, ChangePasswordRequest changePasswordRequest);

    User updateProfile(User user, UpdateProfileRequest updateProfileRequest);
}
