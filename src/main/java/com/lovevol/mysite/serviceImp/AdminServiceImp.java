package com.lovevol.mysite.serviceImp;

import com.lovevol.mysite.dao.ArticleMapper;
import com.lovevol.mysite.dao.CategoryMapper;
import com.lovevol.mysite.dao.ContentMapper;
import com.lovevol.mysite.dao.LabelMapper;
import com.lovevol.mysite.model.Article;
import com.lovevol.mysite.model.Category;
import com.lovevol.mysite.model.Content;
import com.lovevol.mysite.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AdminService")
public class AdminServiceImp implements AdminService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ContentMapper contentMapper;


    @Autowired
    LabelMapper labelMapper;

    @Override
    public int saveCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    @Transactional
    public int saveArticle(Article article, Content content){
        contentMapper.insert(content);
        article.setIdContent(content.getId());
        return articleMapper.insert(article);

    }
}
