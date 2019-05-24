package com.newtouch.serviceImp;

import com.newtouch.mapperDao.StudentMapper;
import com.newtouch.model.Student;
import com.newtouch.service.StudentSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/25
 * Time:17:33
 **/
@Service
public class StudentSeviceImp implements StudentSevice {
    private Logger logger = LoggerFactory.getLogger(StudentSeviceImp.class);
    @Resource
    private StudentMapper studentMapper;

    public void method() {
        List<Student> list = studentMapper.selectAll();

        //Student s=studentMapper.selectByPrimaryKey(1);
        Student s = list.get(0);
        s.setName("mapper");
        //studentMapper.insertSelective(s);
        studentMapper.updateByPrimaryKey(s);
        System.out.println(list);
        logger.info("selectByPrimaryKey------------------------------" + studentMapper.selectByPrimaryKey(1).toString());

    }

    public void method2() {
        Example example = new Example(Student.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", 1);
        List<Student> list = studentMapper.selectByExample(example);
        logger.info("-----------------------" + list.get(0).toString());

    }
}
