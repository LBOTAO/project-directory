package com.happy.dao;

import com.happy.entity.Catalog;

import java.util.List;

public interface CatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    List<Catalog> selectAll();

    Catalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKeyWithBLOBs(Catalog record);

    int updateByPrimaryKey(Catalog record);
}