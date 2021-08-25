package com.atlantico.user.http.controller;

import com.atlantico.user.commons.response.Response;
import com.atlantico.user.commons.util.EntityToDtoMapper;
import com.atlantico.user.gateway.database.entity.User;
import com.atlantico.user.gateway.service.UserService;
import com.atlantico.user.http.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Users")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private EntityToDtoMapper<User, UserDTO> mapper;

    @PostMapping
    @ApiOperation(value = "create")
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
        Response<UserDTO> response = new Response<UserDTO>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        User user = service.save(mapper.unmap(dto));
        response.setData(mapper.map(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @ApiOperation(value = "list")
    public ResponseEntity<Response<List<UserDTO>>> list() {
        Response<List<UserDTO>> response = new Response<List<UserDTO>>();
        List<User> list = service.list();
        response.setData(mapper.map(list));
        return ResponseEntity.ok().body(response);
    }
}
