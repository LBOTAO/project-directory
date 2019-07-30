package com.happy.service;


import com.github.pagehelper.PageInfo;
import com.happy.entity.Article;

import java.util.List;

public interface ArticleService {
    PageInfo<Article> selectAll(int pageNum,int pageSize);

    Article selectByPrimaryKey(Integer id);

    Article selectLastArticle(Integer id);

    Article selectNextArticle(Integer id);
}
