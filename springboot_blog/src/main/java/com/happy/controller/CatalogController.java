package com.happy.controller;

import com.github.pagehelper.PageInfo;
import com.happy.dao.CatalogMapper;
import com.happy.entity.Catalog;
import com.happy.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @Autowired
    private CatalogMapper catalogMapper;

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(){
        return catalogMapper.selectAll();
    }

    @RequestMapping("/selectCatalogAll")
    @ResponseBody
    public Map<String, Object> selectAll(@RequestParam("page")int pageNum, @RequestParam("limit")int pageSize){
        PageInfo<Catalog> catalogPageInfo = catalogService.selectAll(pageNum, pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("count",catalogPageInfo.getTotal());
        map.put("data",catalogPageInfo.getList());
        return map;
    }

    @RequestMapping("/delCatalogById")
    @ResponseBody
    public int delCatalogById(int id){
        int count = catalogService.deleteByPrimaryKey(id);
        if (count>0) {
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/updateCatalogById")
    @ResponseBody
    public int updateCatalogById(Catalog catalog){
        int count = catalogService.updateByPrimaryKey(catalog);
        if (count>0){
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/insertCatalog")
    @ResponseBody
    public int insertCatalog(Catalog catalog){
        int count = catalogService.insertSelective(catalog);
        if (count>0){
            return 1;
        }else {
            return 0;
        }
    }
}
