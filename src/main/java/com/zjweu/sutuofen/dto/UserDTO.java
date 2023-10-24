package com.zjweu.sutuofen.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zjweu.sutuofen.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * author：Swithin
 * date：2023/10/24 14:40
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserDTO", description="给前端返回的user对象，不返回password，添加token")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String nickname;

    @JsonIgnore
    private String password;

    private Integer status;

    private Integer grade;

    private Boolean sex;

    private Integer campus;

    private Integer college;

    private String profile;

    private String telephone;

    private Integer clas;

    private Boolean isVip;

    private Integer remainingStrikes;

    private Integer academicStatus;

    private String token;
    
    public UserDTO(User u){
        this.id = u.getId();
        this.name = u.getName();
    }
}
