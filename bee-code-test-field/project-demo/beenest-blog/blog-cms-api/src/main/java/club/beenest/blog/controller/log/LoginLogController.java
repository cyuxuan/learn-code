/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.controller.log;

import club.beenest.blog.support.common.entity.log.LoginLog;
import club.beenest.blog.support.common.service.log.LoginLogService;
import club.beenest.blog.support.request.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录日志后台管理
 *
 * @author 陈玉轩
 * @since　1.0
 */
@RestController
@RequestMapping("/admin")
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;

    /**
     * 分页查询登录日志列表
     *
     * @param date     按操作时间查询
     * @param pageNum  页码
     * @param pageSize 每页个数
     * @return
     */
    @GetMapping("/loginLogs")
    public Result loginLogs(@RequestParam(defaultValue = "") String[] date,
                            @RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "10") Integer pageSize) {
        String startDate = null;
        String endDate = null;
        if (date.length == 2) {
            startDate = date[0];
            endDate = date[1];
        }
        String orderBy = "create_time desc";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        PageInfo<LoginLog> pageInfo = new PageInfo<>(loginLogService.getLoginLogListByDate(startDate, endDate));
        return Result.ok("请求成功", pageInfo);
    }

    /**
     * 按id删除登录日志
     *
     * @param id 日志id
     * @return
     */
    @DeleteMapping("/loginLog")
    public Result delete(@RequestParam Long id) {
        loginLogService.deleteLoginLogById(id);
        return Result.ok("删除成功");
    }
}
