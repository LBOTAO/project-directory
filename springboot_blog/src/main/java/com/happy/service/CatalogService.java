package com.happy.service;

import com.github.pagehelper.PageInfo;
import com.happy.entity.Catalog;

import java.util.List;

public interface CatalogService {
    PageInfo<Catalog> selectAll(int pageNum,int pageSize);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(Catalog record);
    int insertSelective(Catalog record);
}
