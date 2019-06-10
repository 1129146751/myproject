package com.newtouch.controller.teacher;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.github.pagehelper.PageInfo;
import com.newtouch.controller.LoginController;
import com.newtouch.mapperDao.TabTeacherMapper;
import com.newtouch.model.Employee;
import com.newtouch.model.TabTeacher;
import com.newtouch.util.resultjson.ResultJson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/6/10
 * Time:15:45
 **/
@Controller
@RequestMapping("/teacher")
public class teacherController {
    @Autowired
    private TabTeacherMapper tabTeacherMapper;
    @PostMapping("/queryTeacherInf")
    @ResponseBody
    public ResultJson queryTeacherInf(@RequestParam Map<String,Object> map){
        Example example=new Example(TabTeacher.class);
        Example.Criteria c=example.createCriteria();
        if(!StringUtils.isEmpty( map.get("teacherName"))) {
            c.andLike("teacherName", "%" +map.get("teacherName")+ "%");
        }
        if(!StringUtils.isEmpty(map.get("teacherCourse"))){
            c.andLike("teacherCourse","%"+map.get("teacherCourse")+"%");
        }
        if(!StringUtils.isEmpty(map.get("teacherSex"))){
            c.andEqualTo("teacherSex",map.get("teacherSex"));
        }
        if(!StringUtils.isEmpty(map.get("ids"))){
            String[] idStr=map.get("ids").toString().split(",");
            List<String> idList= Arrays.asList(idStr);
            c.andEqualTo("teacherCourse",idList);
        }
       List<TabTeacher> list= tabTeacherMapper.selectByExample(example);
        PageInfo page=new PageInfo(list,100);
        return ResultJson.success(page,"tabTeacher");
    }
    /**
     * 文件下载（非excel）
     * @return
     */
    @GetMapping("/dowloadFile")
    @ResponseBody
    public ResponseEntity<byte[]> dowloadFile() throws  Exception{
        File file=new File("D:\\IdeaWorkSpace\\myproject\\src\\main\\resources\\file\\20190610164003.xls");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "hhh.xls");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

    }
    @RequestMapping("importExcel")
    @ResponseBody
    public void importExcel(MultipartFile file) throws  Exception{

        //解析excel，
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<TabTeacher> personList = ExcelImportUtil.importExcel(file.getInputStream(),TabTeacher.class,params);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        personList.forEach(f->{
            tabTeacherMapper.insert(f);
        });

        //TODO 保存数据库
    }
}
