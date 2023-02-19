package com.rbq.controller;

import com.rbq.entity.User;
import com.rbq.service.UserService;
import com.rbq.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2023年02月07日 16:52
 * @Description
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        log.info("用户名和密码" + user.getName() + user.getPassword());
        Map<String, Object> map = new HashMap<>();
        User login = userService.login(user);
        if (login != null) {
            map.put("msg", "登陆成功");
            map.put("code", 200);
            //生成token
            Map<String, String> payload = new HashMap<>();
            payload.put("id", user.getId());
            payload.put("name", user.getName());
            String token = JWTUtils.getToken(payload);
            map.put("token", token);
            return map;
        } else {
            map.put("msg", "登录失败");
            return map;
        }
    }

    @RequestMapping("/user/test")
    public String demo(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println(token);
        System.out.println("测试速狙");
        return "hello";
    }

}
