package com.jim.swg.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class User implements Serializable {
    @ApiModelProperty(notes = "用户id", required = false, dataType = "Integer")
    private int id;

    @ApiModelProperty(notes = "描述", required = false, dataType = "String")
    private String description;

    @NotNull
    @Max(100)
    @Min(1)
    @ApiModelProperty(notes = "年龄", required = true, dataType = "Integer", allowableValues = "range[0,100]")
    private int age;
    @NotBlank
    @ApiModelProperty(notes = "用户名", required = true, dataType = "String")
    private  String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
