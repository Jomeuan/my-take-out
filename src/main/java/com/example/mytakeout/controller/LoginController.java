package com.example.mytakeout.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("login")
public class LoginController {
    @GetMapping()
    public R<String> successLogin() {return R.success("登录成功");
    }

    @GetMapping("/error")
    public R<String> errorLogin() {
        return R.fail("login errer","账号名或密码错误");
    }
}
