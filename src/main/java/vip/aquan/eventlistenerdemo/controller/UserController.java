package vip.aquan.eventlistenerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.aquan.eventlistenerdemo.pojo.User;
import vip.aquan.eventlistenerdemo.service.UserService;

/**
 * @author: wcp
 * @date: 2021/8/11 23:28
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/insert")
    public String insert(){
        User user = new User();
        user.setName("张三");
        user.setAge(22);
        userService.userRegister(user);
        return "success";
    }

}
