package com.fitperformsync.fitperformsync.service;

import com.fitperformsync.fitperformsync.DTO.UserDTO;
import com.fitperformsync.fitperformsync.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    User getUserById(Long id);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
