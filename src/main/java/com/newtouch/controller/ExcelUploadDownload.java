package com.newtouch.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.newtouch.service.ExcelUploadDownloadSevice;
import com.newtouch.util.resultjson.ResultJson;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * 对Excel文件上传下载
 *
 * @author:fengxu Date:2019/5/8
 * Time:16:32
 **/
@Controller
public class ExcelUploadDownload {
    @Autowired
    ExcelUploadDownloadSevice excelUploadDownloadSevice;

    @RequestMapping(value = "ecxelUpload", method = RequestMethod.POST)
    public Object ecxelUpload(MultipartFile file) throws Exception {
        InputStream input = file.getInputStream();
        excelUploadDownloadSevice.dealExcelDate(input);
        return null;
    }

    @RequestMapping(value = "ecxelDownload")
    @ResponseBody
    public void ecxelDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .getBytes(), "UTF-8");
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        writer.write0(data, sheet1);
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        out.flush();
        out.close();
    }

    @RequestMapping(value = "ecxelDownload2")
    @ResponseBody
    public ResultJson ecxelDownload2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //模板导出
        Workbook workbook = null;
        OutputStream outstream = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            String newsNo = df.format(new Date());
            String fileName = "测试_" + newsNo;
            String filePro = 1233 + fileName + ".xls";
            //dowlandUrl为配置文件中下载到电脑的路径
            // excel文件流输出到浏览器，选择下载路径
            File f = new File(request.getSession().getServletContext().getRealPath("/") + fileName);
            List<TestEntity> list = new ArrayList<TestEntity>();
            //TestEntity为模板下载的实体
            list.add(new TestEntity("sss", "XXX"));
            list.add(new TestEntity("sss22", "XXX"));
            list.add(new TestEntity("sssEE", "XXX"));
            list.add(new TestEntity("sss33", "XXX"));
            //为实体赋值
            workbook = ExcelExportUtil.exportExcel(new ExportParams(), TestEntity.class, list);

            outstream = response.getOutputStream();

            /**这段代码可以实现Excel以文件流的形式到浏览器中,浏览器左下角出现Excel的下载提示，
             *new String(fileName.getBytes(),"iso-8859-1")可是实现文件名为中文，不是乱码  */
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(), "iso-8859-1") + ".xls");
            response.setContentType("application/x-download");
            workbook.write(outstream);
            outstream.close();
        } catch (Exception e) {// 发生不可预知异常，在此截获异常信息，并返回客户操作不成功

            return ResultJson.success("失败");
        }
        return ResultJson.success("成功");
    }
}

class TestEntity {
    @Excel(name = "姓名", orderNum = "0")
    private String name;
    @Excel(name = "地址", orderNum = "1")
    private String add;
    private String jj;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public TestEntity(String name, String add) {
        this.name = name;
        this.add = add;
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }
}


