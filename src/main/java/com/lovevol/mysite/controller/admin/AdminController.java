package com.lovevol.mysite.controller.admin;

import com.lovevol.mysite.controller.BaseController;
import com.lovevol.mysite.dao.CategoryMapper;
import com.lovevol.mysite.dao.LabelMapper;
import com.lovevol.mysite.model.*;
import com.lovevol.mysite.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

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

    @RequestMapping(value = "/goIndex",method = RequestMethod.GET)
    public String goindex(){
        logger.info("start go addArticle");
        return "/admin/adminIndex";
    }

    @GetMapping("/addArticlePage")
    public String goAddArticle(Model model){
        model.addAttribute("categorys", categoryMapper.selectByExample(new CategoryExample()));
        model.addAttribute("labels", labelMapper.selectByExample(new LabelExample()));
        return "/admin/addArticle";
    }


    @GetMapping("/editCategoryPage")
    public String editCategoryPage(Model model){
        model.addAttribute("categorys", categoryMapper.selectByExample(new CategoryExample()));
        return "/admin/editCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category){
        adminService.saveCategory(category);
        return "/admin/adminIndex";
    }

    @GetMapping("/editLabelPage")
    public String editLabelPage(Model model){
        model.addAttribute("categorys", categoryMapper.selectByExample(new CategoryExample()));
        model.addAttribute("labels", labelMapper.selectByExample(new LabelExample()));
        return "/admin/editLabel";
    }

    @PostMapping("/addLabel")
    public String addLabel(Label label){
        labelMapper.insert(label);
        return "/admin/adminIndex";
    }

    @PostMapping(value = "/addArticle")
    public String addArticle(Article article, Content content, HttpServletRequest request, MultipartFile image) throws IOException {
        if (article.getTitle() != null && !"".equals(article.getTitle())
                && article.getIdLabel() != null && !"".equals(article.getIdLabel())
                && article.getIdCategory() != null && !"".equals(article.getIdCategory())) {
            if (image != null && !image.isEmpty()) {
                //String path = "/home/mysite_image/";
                String path = request.getServletContext().getRealPath("/static/image/");
                String imageName = image.getOriginalFilename();
                //文件重命名，解决中文文件名问题
                imageName = UUID.randomUUID().toString()+imageName.substring(imageName.lastIndexOf("."));
                File filePath = new File(path, imageName);
                if (!filePath.getParentFile().exists()) {
                    filePath.getParentFile().mkdirs();
                }
                image.transferTo(new File(path + File.separator + imageName));
                article.setImagePath(imageName);
            }
            article.setDate(new Date(System.currentTimeMillis()));
            adminService.saveArticle(article, content);
            return "redirect:/admin/goIndex";
        } else {
            request.setAttribute("errorMsg", "添加文章数据不正确！");
            return "redirect:/admin/goIndex";
        }
    }
}
