package com.atlantico.user.http.mapper;

import com.atlantico.user.commons.util.EntityToDtoMapper;
import com.atlantico.user.gateway.database.entity.User;
import com.atlantico.user.http.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper extends EntityToDtoMapper<User, UserDTO> {
    @Override
    protected UserDTO convert(User tab) {
        UserDTO dto = new UserDTO();
        dto.setId(tab.getId());
        dto.setName(tab.getName());
        dto.setEmail(tab.getEmail());
        dto.setPassword(tab.getPassword());
        dto.setLogin(tab.getLogin());
        dto.setCreatedDate(tab.getCreatedDate());
        dto.setUpdatedDate(tab.getUpdatedDate());
        dto.setAdmin(tab.isAdmin());
        return dto;
    }

    @Override
    protected User convert(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setLogin(dto.getLogin());
        user.setCreatedDate(dto.getCreatedDate());
        user.setUpdatedDate(dto.getUpdatedDate());
        user.setAdmin(dto.isAdmin());
        return user;
    }
}
