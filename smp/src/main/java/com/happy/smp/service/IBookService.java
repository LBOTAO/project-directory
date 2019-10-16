package com.happy.smp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.happy.smp.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author happy
 * @since 2019-10-16
 */
public interface IBookService extends IService<Book> {

    public IPage<Book> selectListByLimit(Map<String,Object> map);

}
