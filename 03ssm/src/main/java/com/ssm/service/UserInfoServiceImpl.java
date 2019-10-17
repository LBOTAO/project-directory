package com.ssm.service;

import com.ssm.dao.IUserInfoDAO;
import com.ssm.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDAO userInfoDAO;

    @Override
    public UserInfo isLogin(UserInfo userInfo) {
        return userInfoDAO.isLogin(userInfo);
    }
}
