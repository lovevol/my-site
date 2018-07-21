package com.lovevol.mysite.controller.user;

import com.lovevol.mysite.config.Resource;
import com.lovevol.mysite.model.User;
import com.lovevol.mysite.redis.StringRedisService;
import com.lovevol.mysite.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Resource resource;

    @Autowired
    StringRedisService stringRedisService;

    @RequestMapping("/save")
    public String saveUser(){
        stringRedisService.incr("userCount", (long)1);
        User user = new User();
        user.setLoginName("loginname");
        user.setUserName("name");
        user.setPassword("pass");
        user.setRoleType((byte)1);
        user.setEmail("email");
        user.setStatus(1);
        userService.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/all")
    public String allUser(Model model){
        model.addAttribute("num", stringRedisService.getString("userCount"));
        model.addAttribute("users", userService.getAllUser());
        return "/user/allUser";
    }

    @GetMapping("/resource")
    public Resource getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return bean;
    }
}
