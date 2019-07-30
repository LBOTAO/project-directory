package com.happy.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happy.dao.CatalogMapper;
import com.happy.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public PageInfo<Catalog> selectAll(int pageNum,int pageSize) {
        Page<Catalog> page = PageHelper.startPage(pageNum, pageSize);
        catalogMapper.selectAll();
        return page.toPageInfo();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return catalogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Catalog record) {
        return catalogMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertSelective(Catalog record) {
        return catalogMapper.insertSelective(record);
    }
}
