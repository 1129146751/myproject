package com.newtouch.service;

import java.io.InputStream;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/8
 * Time:16:35
 **/
public interface ExcelUploadDownloadSevice {
    public Object dealExcelDate(InputStream inputStream) throws Exception;

    public void ecxelDownload() throws Exception;
}
