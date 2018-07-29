package com.lovevol.mysite.controller.admin;

import com.lovevol.mysite.controller.BaseController;
import com.lovevol.mysite.dao.CategoryMapper;
import com.lovevol.mysite.dao.LabelMapper;
import com.lovevol.mysite.model.Category;
import com.lovevol.mysite.model.CategoryExample;
import com.lovevol.mysite.model.Label;
import com.lovevol.mysite.model.LabelExample;
import com.lovevol.mysite.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lh
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AdminService adminService;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    LabelMapper labelMapper;

    @RequestMapping("/goIndex")
    public String goindex(){
        logger.info("start go addArticle");
        return "/admin/adminIndex";
    }

    @RequestMapping("/addArticlePage")
    public String goAddArticle(){
        return "/admin/addArticle";
    }


    @RequestMapping("/editCategoryPage")
    public String editCategoryPage(Model model){
        model.addAttribute("categorys", categoryMapper.selectByExample(new CategoryExample()));
        return "/admin/editCategory";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category category){
        adminService.saveCategory(category);
        return "/admin/adminIndex";
    }

    @RequestMapping("/editLabelPage")
    public String editLabelPage(Model model){
        model.addAttribute("categorys", categoryMapper.selectByExample(new CategoryExample()));
        model.addAttribute("labels", labelMapper.selectByExample(new LabelExample()));
        return "/admin/editLabel";
    }

    @RequestMapping("/addLabel")
    public String addLabel(Label label){
        labelMapper.insert(label);
        return "/admin/adminIndex";
    }
}
