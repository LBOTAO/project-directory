package com.happy.smp.controller;


import com.happy.smp.service.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
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
//用在类上，说明该类的作用
@Api(value = "BookController图书管理控制器")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/selectPage",method= RequestMethod.POST)
    //给方法增加说明，notes是补充的说明
    @ApiOperation(value = "分页查询图书信息",notes = "按照指定图书名分页查询")
    //给方法入参增加说明，name：参数名，value：说明参数的意思，dataType：参数类型，required：参数是否必须传
    //paramType：指定参数放在哪个地方，
    //header：请求参数放置于Request Header，使用@RequestHeader获取
    //query：请求参数放置于请求地址，使用@RequestParam获取
    //path：（用于restful接口）-->请求参数的获取：@PathVariable
    //body：（不常用）
    //form（不常用）
    //用在方法上包含一组参数说明
    @ApiImplicitParams({
            //如果paramType与方法参数获取使用的注解不一致，会直接影响到参数的接收。
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页数",required = true,dataType = "long"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页显示数据条数",required = true,dataType = "long"),
            @ApiImplicitParam(paramType = "query",name = "name",value = "图书名称",required = true,dataType = "String")
    })
    public Object selectPage(Long pageNum,Long pageSize,String name){
        Map<String,Object> map=new HashMap<>();
        map.put("current",pageNum);
        map.put("size",pageSize);
        map.put("name",name);
        return bookService.selectListByLimit(map);
    }

}

