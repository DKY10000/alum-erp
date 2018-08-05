package com.dky.eureka.controller;

import com.dky.eureka.domain.user.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlcloud.commons.core.constant.ConstantCode;
import com.zlcloud.commons.core.convert.AjaxResult;
import com.zlcloud.commons.core.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(value = "/AppVersionController", description = "App版本", tags = "AppVersionController")
@RestController
@RequestMapping(value = "/AppVersion")
public class AppVersionController {

    @ApiOperation(value = "查询App版本号", httpMethod = "get", notes = "直接查询出数据字典中的版本号")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNo", value = "分页索引"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "分页大小"),
    })
    @GetMapping(value = "Version")
    public AjaxResult<List<User>> getVersion(Integer pageNo, Integer pageSize) {
        try {
            pageNo = pageNo == null ? 0 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;
            PageHelper.startPage(pageNo, pageSize, true);
            List<User> userList = new ArrayList<>();
            User results = new User();
            userList.add(results);
            results.setFname("dky");
            if (results == null) {
                return new AjaxResult().error("没有找到相关客户资料数据");
            }
            PageHelper.clearPage();
            return new AjaxResult().success(new PageInfo(userList));
        } catch (Exception e) {
            return new AjaxResult().error(ConstantCode.ERROR_CODE, BeanUtils.getErrorInfoFromException(e), "获取数据时发生异常.");
        }
    }
}