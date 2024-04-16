package com.xunhuan.java.algorithm.geekbang.design_model.day_48;

import com.xunhuan.java.algorithm.geekbang.design_model.day_48.model.UserVo;

/**
 * @author tianh
 * @description:
 * @date 2020-05-09 11:22
 */
public interface IUserController {
    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
