package com.jim.swg.controller;

import com.jim.swg.domain.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo")
//@Api(value="demo", description="这是一个Swagger demo的服务")
@Api(tags = {"这是一个Swagger demo的服务"})
public class DemoController {

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value="新增一个用户", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功保存"),
            @ApiResponse(code = 401, message = "你没权限"),
            @ApiResponse(code = 403, message = "你被禁止访问了"),
            @ApiResponse(code = 404, message = "没找到，哈哈哈")
    })
    @ApiImplicitParam(name = "user",
    value = "要新增的用户",
            dataType = "User",
            required = true,
            paramType = "body"
    )
    public User addUser(@RequestBody @Valid User user){
        user.setDescription("had been dealed");
        return  user;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除一个用户", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功保存"),
            @ApiResponse(code = 401, message = "你没权限"),
            @ApiResponse(code = 403, message = "你被禁止访问了"),
            @ApiResponse(code = 404, message = "没找到，哈哈哈")
    })
    @ApiImplicitParam(name = "id",
    value = "要删除的用户id",
    dataType = "int",
    required = true,
    paramType = "path")
    public ResponseEntity delete(@PathVariable Integer id){

        return new ResponseEntity("User had been deleted", HttpStatus.OK);
    }

    @RequestMapping(value="/show", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "显示一个用户", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功保存"),
            @ApiResponse(code = 401, message = "你没权限"),
            @ApiResponse(code = 403, message = "你被禁止访问了"),
            @ApiResponse(code = 404, message = "没找到，哈哈哈")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",
            value = "要显示的用户id",
            dataType = "int",
            required = true,
            paramType = "query"),
            @ApiImplicitParam(name = "param",
            value = "其他参数",
            dataType = "String",
            required = true,
            paramType = "query")
    })
    public User showUser(@RequestParam("id") Integer id, @RequestParam("param") String otherParam){
        User user = new User();
        user.setId(1);
        user.setDescription("show user");
        user.setAge(100);
        user.setUserName("test");
        return user;
    }
}
