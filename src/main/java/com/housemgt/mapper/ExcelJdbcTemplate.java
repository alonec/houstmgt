package com.housemgt.mapper;

import com.housemgt.entity.Excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class ExcelJdbcTemplate {

    private JdbcTemplate jdbcTemplate;

    /**
     * 初始化
     * @param jdbcTemplate
     */
    public ExcelJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 批量插入
     * @param excelList
     */
    public void insertBatchByJdbcTemplate(List<Excel> excelList){
        String prefix = "insert delayed into `element`(`buildingNumber`, `elementNumber`, `floorNumber`, `households`, `elevatorstatus`, `elementPicture`) values";

        StringBuilder suffix  = new StringBuilder();

        for (Excel excel : excelList) {
            // 需要注意根据 字段的类型修改 单引号 '
            suffix .append("('").append(excel.getBuildingNumber()).append("','");
            suffix .append(excel.getElementNumber()).append("',");
            suffix .append(excel.getFloorNumber()).append(",");
            suffix .append(excel.getHouseholds()).append(",");
            suffix .append(excel.getElevatorstatus()).append(",'");
            suffix .append(excel.getElementPicture()).append("'),");
        }

        // 需要去除最后一个 ','
        jdbcTemplate.batchUpdate(prefix+suffix .substring(0,suffix .length()-1));
    }


    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    public List<Excel> selectExcel(Integer start, Integer rows){
        StringBuilder sql = new StringBuilder();
        sql.append("select `buildingNumber`,`elementNumber`,`floorNumber`,`households`,`elevatorstatus`,`elementPicture` from `element` ")
                .append("limit ?,? ");

        List<Excel> excels =  jdbcTemplate.query(sql.toString(),new Object[]{start,rows}, new BeanPropertyRowMapper<>(Excel.class));

        return excels;
    }
}
