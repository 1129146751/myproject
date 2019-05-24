package com.newtouch.serviceImp;

import com.newtouch.mapperDao.UserMapper;
import com.newtouch.model.User;
import com.newtouch.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/26
 * Time:10:22
 **/
@Service
public class UserSeviceImp implements UserSevice {
    @Resource
    private UserMapper userMapper;

    @Transactional
    public void add() throws Exception {
        User user = userMapper.selectByPrimaryKey(Long.parseLong("22"));
        user.setuId(null);
        userMapper.insertSelective(user);
        if (true) {
            throw new RuntimeException("回滚");
        }
    }

    @Override
    public void get() {

    }
}
