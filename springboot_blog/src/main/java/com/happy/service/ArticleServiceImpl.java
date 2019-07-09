package com.happy.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happy.dao.ArticleMapper;
import com.happy.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> selectAll(int pageNum,int pageSize) {
        Page<Article> page = PageHelper.startPage(pageNum, pageSize);
        articleMapper.selectAll();
        return page.toPageInfo();
    }
}
