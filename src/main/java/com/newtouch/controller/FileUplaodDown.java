package com.newtouch.controller;

import com.newtouch.mapperDao.SysAttachMapper;
import com.newtouch.model.SysAttach;
import com.newtouch.util.Uuid;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IDEA
 * 文件的上传下载
 *
 * @author:fengxu Date:2019/5/7
 * Time:13:32
 **/
@Controller
public class FileUplaodDown {
    @Resource
    private SysAttachMapper sysAttachMapper;

    /**
     * 文件上传
     * 得到文件流  判断服务器上面是否存在指定的文件夹  创建文件
     *
     * @param uploadeFiles
     * @return
     * @throws Exception
     */
    @RequestMapping("upFileMethod")
    public ModelAndView upload(MultipartFile uploadeFiles) throws Exception {
        InputStream fip = FileUplaodDown.class.getResourceAsStream("/uploadurl.properties");
        Properties p = new Properties();
        p.load(fip);
        //系统指定的文件路径
        String uploadurl = p.getProperty("uploadurl");
        //1:判断系统自定的文件路径是否存在 不存在 创建文件夹
        File sysDir = new File(uploadurl);
        if (!sysDir.exists()) {
            sysDir.mkdirs();
        }
        //2:指定文件名 创建文件
        //--1得到文件全名
        String originalFilename = uploadeFiles.getOriginalFilename();
        //--2得到文件后缀
        String fileSufix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //--3创建上传文件命名 随机数+文件后缀
        File sysFileName = new File(sysDir + File.separator + Uuid.getUUid() + fileSufix);
        if (!sysFileName.exists()) {
            sysFileName.createNewFile();
        }
        uploadeFiles.transferTo(sysFileName);

        //文件信息传保存到数据库中
        SysAttach attach = new SysAttach();
        attach.setFileOldName(originalFilename);
        attach.setFileSysName(Uuid.getUUid() + fileSufix);
        attach.setFilePath(sysDir + File.separator + Uuid.getUUid() + fileSufix);
        attach.setOperateUser("张三");
        sysAttachMapper.insertSelective(attach);
        ModelAndView mv = new ModelAndView();
        mv.addObject("ggg", "hh");
        mv.setViewName("success2");
        return mv;
    }

    @RequestMapping(value = "laodFile")
    public ResponseEntity<byte[]> laodFile() throws Exception {
        SysAttach attach = sysAttachMapper.selectByPrimaryKey(4);
        File file = new File(attach.getFilePath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", attach.getFileSysName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/html", method = RequestMethod.GET)
    public ModelAndView userLogin10() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success2");
        return mv;
    }
}
