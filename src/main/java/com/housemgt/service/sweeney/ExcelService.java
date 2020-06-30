package com.housemgt.service.sweeney;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.housemgt.common.utils.DataListListener;
import com.housemgt.common.utils.ThreadQuery;
import com.housemgt.entity.Excel;
import com.housemgt.mapper.ExcelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;



@Slf4j
@Service
public class ExcelService {

    @Resource
    private ExcelMapper excelMapper;

    @Resource
    private JdbcTemplate jdbcTemplate;


    /**
     * 读取Excel，  并传入数据库
     * @param file
     * @return 是否成功导入数据库
     */
    public boolean importExcelByEasyExcel(MultipartFile file){
        try {
            EasyExcel.read(file.getInputStream(), Excel.class, new DataListListener(jdbcTemplate)).doReadAll();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 导出excel
     */
    public void exportExcelByEasyExcel(HttpServletResponse response, String filename) throws ExecutionException, InterruptedException {
        //List<Excel> excelList = excelMapper.selectAll();
        List<Excel> excelList = queryExcelByThread();

        try {
            ExcelWriter writer = EasyExcel.write(getOutputStream(filename, response),Excel.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
            writer.write(excelList, writeSheet);

            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出文件头信息 设置
     *
     * @param filename
     * @param response
     * @return
     * @throws Exception
     */
    public static OutputStream getOutputStream(String filename, HttpServletResponse response) throws Exception {
        try {
            filename = URLEncoder.encode(filename, "UTF-8");
            response.setContentType("application/vnd.ms-housemgt");
            response.setCharacterEncoding("utf8");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e) {
            throw new Exception("导出excel表格失败!", e);
        }
    }


    /**
     * 查询数据
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public List<Excel> queryExcelByThread() throws InterruptedException, ExecutionException {
        List<Excel> excelList = new ArrayList<>();

        int count = 600000;

        // 一次查询多少条
        int rows = 8000;

        //需要查询的次数
        int times = count / rows;

        int start = 1;

        List<Callable<List<Excel>>> tasks = new ArrayList<>();

        for (int i=0;i<times;i++){
            Callable<List<Excel>> listCallable = new ThreadQuery(jdbcTemplate,start,rows);
            tasks.add(listCallable);

            start += rows;
        }

        //定义固定长度的线程池  防止线程过多
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        List<Future<List<Excel>>> futures = executorService.invokeAll(tasks);

        if (futures.size() > 0){
            for (Future<List<Excel>> future : futures) {
                excelList.addAll(future.get());
            }
        }

        executorService.shutdown();

        return excelList;
    }
}
