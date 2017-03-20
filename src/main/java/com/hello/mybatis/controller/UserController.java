package com.hello.mybatis.controller;

import com.hello.mybatis.service.interf.UserService;
import com.hello.mybatis.service.message.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by ligaozhao on 19/03/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/get-user-by-id", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public GetUserResp getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public BaseResp createUser(@RequestBody CreateUserReq req) {
        return userService.createUser(req);
    }

    @ResponseBody
    @RequestMapping(value = "/list-user-by-id-list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ListUserResp createUser(@RequestBody ListUserReq req) {
        return userService.listUserByIdList(req);
    }
}
