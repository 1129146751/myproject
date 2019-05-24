package com.newtouch.serviceImp;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.newtouch.mapperDao.TabTestMapper;
import com.newtouch.model.TabTest;
import com.newtouch.service.ExcelUploadDownloadSevice;
import com.newtouch.util.excel.AnalysisEventListenerImp;
import com.newtouch.util.excel.ExcelReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/8
 * Time:16:45
 **/
@Service
public class ExcelUploadDownloadSeviceImp implements ExcelUploadDownloadSevice {
    @Autowired
    private TabTestMapper tabTestMapper;

    @Override
    @Transactional
    public Object dealExcelDate(InputStream inputStream) throws Exception {

        try (InputStream in = inputStream) {
            AnalysisEventListener<TabTest> listener = new AnalysisEventListener<TabTest>() {
                List<TabTest> resultDate = new ArrayList<TabTest>();

                @Override
                public void invoke(TabTest object, AnalysisContext context) {
                    System.err.println("Row:" + context.getCurrentRowNum() + " Data:" + object);
                    resultDate.add(object);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    System.err.println("doAfterAllAnalysed...");
                    resultDate.forEach(f -> {
                        System.err.println("数据..." + f);
                        tabTestMapper.insert(f);
                        throw new RuntimeException("测试事务是否回滚");
                    });

                }
            };
            AnalysisEventListenerImp<TabTest> listener2 = new AnalysisEventListenerImp<TabTest>();
            ExcelReader excelReader = ExcelReaderFactory.getExcelReader(in, null, listener);
            // 第二个参数为表头行数，按照实际设置
            excelReader.read(new Sheet(1, 1, TabTest.class));
        }

        return null;
    }

    @Override
    public void ecxelDownload() throws Exception {

        try (OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\downlaod.xls");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");
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

        }
    }
}
