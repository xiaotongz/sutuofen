package com.zjweu.sutuofen.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author swithin
 * @since 2023-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;

    @ApiModelProperty(value = "最多21个字")
    private String name;

    private String nickname;


    private String password;

    @ApiModelProperty(value = "1为学生，2为活动管理者，3为团干，4为终极管理员")
    private Integer status;

    private Integer grade;

    @ApiModelProperty(value = "真为男，假为女")
    private Boolean sex;

    @ApiModelProperty(value = "1为钱塘，2为南浔")
    private Integer campus;

    @ApiModelProperty(value = "外键表示学院")
    private Integer college;

    @ApiModelProperty(value = "头像地址")
    private String profile;

    private String telephone;

    @ApiModelProperty(value = "外键表示为班级")
    @TableField("class")
    private Integer clas;

    @ApiModelProperty(value = "是否可以忽略黑名单限制")
    private Boolean isVip;

    @ApiModelProperty(value = "剩余退活动（违规）次数")
    private Integer remainingStrikes;

    @ApiModelProperty(value = "外键表本|专科")
    private Integer academicStatus;


}
