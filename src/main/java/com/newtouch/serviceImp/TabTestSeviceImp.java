package com.newtouch.serviceImp;

import com.newtouch.controller.LoginController;
import com.newtouch.mapperDao.TabTestMapper;
import com.newtouch.model.TabTest;
import com.newtouch.service.TabTestSevice;
import com.newtouch.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/26
 * Time:16:00
 **/
@Service
public class TabTestSeviceImp implements TabTestSevice {
    private Logger logger = LoggerFactory.getLogger(TabTestSeviceImp.class);
    @Resource
    private TabTestMapper tabTestMapper;
    @Autowired
    private RedisUtil rRedisUtil;
    @Autowired(required = false)
    private LoginController loginController;

    @Override
    @Cacheable(value = "sfsnfksjjkfskfjskjf", key = "'login'+1001")
    public Object method() {
        logger.info("ALL--------------" + tabTestMapper.selectAll().toString());
        logger.info("使用example");
        rRedisUtil.set("method", "method");
        Example example = new Example(TabTest.class);
        Example.Criteria cri = example.createCriteria();
        cri.andEqualTo("id", 2);
        List<TabTest> list = tabTestMapper.selectByExample(example);
        list.forEach(f -> {
            logger.info(f.toString());
        });
        //loginController.method12();
        return "123";
    }
}
