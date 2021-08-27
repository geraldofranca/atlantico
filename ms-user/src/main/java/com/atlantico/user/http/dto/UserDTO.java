package com.atlantico.user.http.dto;

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import java.sql.Timestamp;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("User")
public class UserDTO {

    private Long id;

    @NotNull
    @Email
    private String email;

    @Length(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
    private String name;

    @Length(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
    private String login;

    @NotNull
    @Length(min=6, message="A senha deve conter no mínimo 6 caracteres")
    private String password;

    private Timestamp createdDate;

    private Timestamp updatedDate;

    private boolean admin = false;
}
