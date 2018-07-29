package com.lovevol.mysite.serviceImp;

import com.lovevol.mysite.dao.CategoryMapper;
import com.lovevol.mysite.model.Category;
import com.lovevol.mysite.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminServiceImp implements AdminService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int saveCategory(Category category) {
        return categoryMapper.insert(category);
    }
}
