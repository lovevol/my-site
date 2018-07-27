package com.lovevol.mysite.controller.admin;

import com.lovevol.mysite.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lh
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @RequestMapping("/goAddArticle")
    public String goAddArticle(){
        return "/admin/addArticle";
    }
}
