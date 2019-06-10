/*
package com.newtouch.util.excel.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.fasterxml.jackson.annotation.JsonFormat;


import javafx.scene.transform.Translate;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.URLEncoder;
import java.util.*;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static final int BIG_DATA_EXPORT_MIN = 50000;

    public static final int BIG_DATA_EXPORT_MAX = 2000000;


    //excel处理注解set集合
    public static HashSet<String> transClassSet = new HashSet();

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, title, sheetName);
    }

    */
/**
     * 导出函数
     *
     * @param list      导出集合
     * @param title     标题
     * @param sheetName sheet名
     * @param pojoClass 映射实体
     * @param fileName  文件名
     * @param response  httpresponce
     *                  size如果过大 需采用poi SXSSF
     *//*

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
        //判断该类是否已经处理过excel注解
        long startTime = System.currentTimeMillis();
        if (!transClassSet.contains(String.valueOf(pojoClass))) {
            initProperties(pojoClass);
            transClassSet.add(String.valueOf(pojoClass));
        }
        defaultExport(list, pojoClass, fileName, response, title, sheetName);
        log.info("此文件[{}]导出耗时：{}ms", fileName, (System.currentTimeMillis() - startTime));
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, String title, String sheetName) {
        Workbook workbook = null;
        ExportParams exportParams = new ExportParams(title, sheetName);
        if (list != null && list.size() > BIG_DATA_EXPORT_MAX) {
            sizeBeyondError(response);
            return;
        } else if (list != null && list.size() > BIG_DATA_EXPORT_MIN) {
            log.info("文件过大采用大文件导出：" + list.size());
            for (int i = 0; i < (list.size() / BIG_DATA_EXPORT_MIN + 1) && list.size() > 0; i++) {
                log.info("当前切片：" + i * BIG_DATA_EXPORT_MIN + "-" + (i + 1) * BIG_DATA_EXPORT_MIN);
                List<?> update = list.stream().skip(i * BIG_DATA_EXPORT_MIN).limit(BIG_DATA_EXPORT_MIN).collect(Collectors.toList());
                exportParams.setCreateHeadRows(true);
                exportParams.setMaxNum(BIG_DATA_EXPORT_MIN * 2 + 2);
                workbook = ExcelExportUtil.exportBigExcel(exportParams, pojoClass, update);
            }
            ExcelExportUtil.closeExportBigExcel();
        } else {
            workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), pojoClass, list);
        }
        if (workbook == null) {return;}
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // workbooks.forEach(e -> e.write(response.getOutputStream()));

            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            try {
                response.getWriter().println("{\"code\":597,\"message\":\"Export error!\",\"data\":\"\"}");
                response.getWriter().flush();
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                closeIo(response);
            }
        }
    }


    */
/**
     * 文件过大，不允许导出
     *
     * @param response
     *//*

    private static void sizeBeyondError(HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            response.getWriter().println("{\"code\":599,\"message\":\"文件过大!\",\"data\":\"\"}");
            response.getWriter().flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            closeIo(response);
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse
            response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    public static <
            T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("模版为空");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <
            T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("文件为空");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    */
/**
     * 代理初始化该类的注解
     *
     * @param cl
     *//*

    public synchronized static void initProperties(Class cl) {
        try {
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Excel.class)) {
                    field.setAccessible(true);
                    Excel excel = field.getAnnotation(Excel.class);
                    InvocationHandler h = Proxy.getInvocationHandler(excel);
                    Field hField = h.getClass().getDeclaredField("memberValues");
                    // 因为这个字段事 private final 修饰，所以要打开权限
                    hField.setAccessible(true);
                    // 获取 memberValues
                    Map memberValues = (Map) hField.get(h);
                    //判断是否有转义注解，将字典添加到excel replace属性中
                    if (field.isAnnotationPresent(Translate.class)) {
                        Translate translate = field.getAnnotation(Translate.class);
                        String dicName = translate.dicName();
                        Map dicMap = DictCache.getProperties(dicName);
                        if (dicMap == null) {
                            continue;
                        }
                        String[] replace = new String[dicMap.size()];
                        List<String> replaceList = new ArrayList<>();
                        dicMap.forEach((key, val) -> {
                            replaceList.add(val + "_" + key);
                        });
                        for (int i = 0; i < dicMap.size(); i++) {
                            replace[i] = replaceList.get(i);
                        }
                        memberValues.put("replace", replace);
                    }
                    //json格式化与JsonFormat统一，目前暂用于时间
                    if (field.isAnnotationPresent(JsonFormat.class)) {
                        JsonFormat jsonFormat = field.getAnnotation(JsonFormat.class);
                        if (StringUtils.isNotEmpty(jsonFormat.pattern())) {
                            memberValues.put("format", jsonFormat.pattern());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 关闭writer
     *
     * @param response
     *//*

    private static void closeIo(HttpServletResponse response) {
        try {
            if (response.getWriter() != null) {
                response.getWriter().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
