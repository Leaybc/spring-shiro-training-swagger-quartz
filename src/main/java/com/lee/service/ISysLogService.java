package com.lee.service;

import com.baomidou.mybatisplus.service.IService;
import com.lee.model.SysLog;
import com.lee.commons.result.PageInfo;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends IService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}