package com.happy.smp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.happy.smp.entity.Book;
import com.happy.smp.mapper.BookMapper;
import com.happy.smp.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author happy
 * @since 2019-10-16
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public IPage<Book> selectListByLimit(Map<String, Object> map) {
        long current = (long) map.get("current");
        long size = (long) map.get("size");
        Page<Book> page=new Page<>(current,size);
        return bookMapper.selectPage(page,new QueryWrapper<Book>().eq("name",map.get("name")));
    }
}
