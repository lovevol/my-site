package com.lovevol.mysite.controller;

import com.github.pagehelper.PageHelper;
import com.lovevol.mysite.util.PageParam;

/**
 * @author lh
 */
public class BaseController {
    public void setPageParam(PageParam pageParam){
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
    }

    public void setPageParam(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
    }
}
