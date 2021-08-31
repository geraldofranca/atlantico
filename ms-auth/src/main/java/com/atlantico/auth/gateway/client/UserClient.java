package com.atlantico.auth.gateway.client;

import com.atlantico.auth.http.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user")
public interface UserClient {

    @RequestMapping("/api/user")
    UserDTO list();
}
