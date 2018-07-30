package com.lovevol.mysite.controller.other;

import com.lovevol.mysite.service.ProfileTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/other/")
public class OtherController {

    @Autowired
    ProfileTestService profileTestService;

    @RequestMapping("/error")
    public String errorTest(){
        int a = 1 / 0;
        return "error";
    }

    @RequestMapping("/include")
    public String includePage(){
        return "/default/include";
    }


    @ResponseBody
    @RequestMapping("/testProfile")
    public Map<String,String> testProfile(){
        Map<String, String> map = new HashMap<>();
        map.put("profile",profileTestService.testProfile());
        return map;
    }
}
