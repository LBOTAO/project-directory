package com.happy.smp.controller;


import com.happy.smp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author happy
 * @since 2019-10-16
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("/selectPage")
    public Object selectPage(Long pageNum,Long pageSize,String name){
        Map<String,Object> map=new HashMap<>();
        map.put("current",pageNum);
        map.put("size",pageSize);
        map.put("name",name);
        return bookService.selectListByLimit(map);
    }

}

