package com.hello.mybatis.controller;

import com.hello.mybatis.service.interf.UserService;
import com.hello.mybatis.service.message.GetUserResp;
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
    @RequestMapping(value = "/count-account-by-name", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public GetUserResp countAccountByName(@RequestParam int id) {
        return userService.getUserById(id);
    }
}
