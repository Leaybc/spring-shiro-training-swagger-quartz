package com.lee.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.lee.model.Resource;
import com.lee.commons.result.Tree;
import com.lee.commons.shiro.ShiroUser;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);

}