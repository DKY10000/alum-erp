package com.dky.eureka.controller;

import com.dky.eureka.action.UserAction;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(value = "/UserController", description = "用户信息", tags = "UserController")
@RestController
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    private UserAction userAction;

    @ApiOperation(value = "查询用户", httpMethod = "get", notes = "直接查询出用户信息")
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

            List<User> results = userAction.getByQueryModel();
            if (results.size() == 0) {
                return new AjaxResult().error("没有找到相关用户");
            }
            PageHelper.clearPage();
            return new AjaxResult().success(new PageInfo<>(results));
        } catch (Exception e) {
            return new AjaxResult().error(ConstantCode.ERROR_CODE, BeanUtils.getErrorInfoFromException(e), "获取数据时发生异常.");
        }
    }
}
