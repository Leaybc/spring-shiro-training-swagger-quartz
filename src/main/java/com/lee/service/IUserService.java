package com.lee.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.lee.model.User;
import com.lee.commons.result.PageInfo;
import com.lee.model.vo.UserVo;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends IService<User> {

    List<User> selectByLoginName(UserVo userVo);

    void insertByVo(UserVo userVo);

    UserVo selectVoById(Long id);

    void updateByVo(UserVo userVo);

    void updatePwdByUserId(Long userId, String md5Hex);

    void selectDataGrid(PageInfo pageInfo);

    void deleteUserById(Long id);
}