package com.atlantico.auth.http.controller;

import com.atlantico.auth.commons.response.Response;
import com.atlantico.auth.gateway.client.UserClient;
import com.atlantico.auth.http.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "Auth")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ApiOperation(value = "list")
    public ResponseEntity<Response<List<UserDTO>>> list() {
        Response<List<UserDTO>> response = new Response<List<UserDTO>>();
        System.out.println(userClient.list());
//        List<User> list = service.list();
//        response.setData(mapper.map(list));

        return ResponseEntity.ok().body(response);
    }
}
