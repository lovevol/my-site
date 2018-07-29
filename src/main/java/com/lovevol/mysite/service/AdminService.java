package com.lovevol.mysite.service;

import com.lovevol.mysite.model.Article;
import com.lovevol.mysite.model.Category;
import com.lovevol.mysite.model.Content;

public interface AdminService {
    /**
     *
     * @param category
     * @return
     */
    int saveCategory(Category category);

    int saveArticle(Article article, Content content);
}
