package com.lovevol.mysite.controller;

import com.github.pagehelper.PageHelper;
import com.lovevol.mysite.util.PageParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lh
 */
@Controller
public class BaseController {
    public void setPageParam(PageParam pageParam){
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
    }

    public void setPageParam(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/admin/goIndex";
    }
}
