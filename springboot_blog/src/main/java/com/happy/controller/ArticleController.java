package com.happy.controller;

import com.github.pagehelper.PageInfo;
import com.happy.entity.Article;
import com.happy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getAbout")
    public String getAbout(){
        return "/about";
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectArticleAll(@RequestParam(required = true,defaultValue = "0")int pageNum,@RequestParam(required = true,defaultValue = "3")int pageSize){
        PageInfo<Article> articlePageInfo = articleService.selectAll(pageNum, pageSize);
        return articlePageInfo;
    }

    @RequestMapping("/selectArticByPrimaryKey")
    @ResponseBody
    public ModelAndView selectArticByPrimaryKey(Integer id){
        Article article = articleService.selectByPrimaryKey(id);
        Article lastArticle = articleService.selectLastArticle(id);
        Article nextArticle = articleService.selectNextArticle(id);
        ModelAndView modelAndView=new ModelAndView("/detail");
        modelAndView.addObject("article",article);
        modelAndView.addObject("lastArticle",lastArticle);
        modelAndView.addObject("nextArticle",nextArticle);
        return modelAndView;
    }
}
