package com.lovevol.mysite.controller.other;

import com.lovevol.mysite.service.ProfileTestService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/other/")
public class OtherController {

    @Autowired
    ProfileTestService profileTestService;

    @GetMapping("/error")
    public String errorTest(){
        int a = 1 / 0;
        return "error";
    }

    @GetMapping("/include")
    public String includePage(){
        return "/default/include";
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true ,dataType = "string")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "it always returns OK"),
    })
    @ResponseBody
    @GetMapping("/testProfile")
    public Map<String,String> testProfile(){
        Map<String, String> map = new HashMap<>();
        map.put("profile",profileTestService.testProfile());
        return map;
    }
}
