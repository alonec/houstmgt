package com.housemgt.common.utils;

import com.housemgt.entity.Excel;
import com.housemgt.mapper.ExcelJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.concurrent.Callable;


public class ThreadQuery implements Callable<List<Excel>> {


    private ExcelJdbcTemplate excelJdbcTemplate;

    private int start;//当前页数

    private int rows;//每页查询多少条


    public ThreadQuery(JdbcTemplate jdbcTemplate, int start, int rows) {
        this.start = start;
        this.rows = rows;

        excelJdbcTemplate = new ExcelJdbcTemplate(jdbcTemplate);

    }


    @Override
    public List<Excel> call() throws Exception {
        //分页查询数据库数据
        return excelJdbcTemplate.selectExcel(start, rows);
    }
}
