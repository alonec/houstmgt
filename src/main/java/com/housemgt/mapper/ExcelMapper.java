package com.housemgt.mapper;

import com.housemgt.entity.Excel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface ExcelMapper extends Mapper<Excel> {

    /**
     *  批量插入 数据
     * @param excelList
     */
    @Insert({
            "<script>",
            " insert into `element`(`buildingNumber`,`elementNumber`,`floorNumber`,`households`,`elevatorstatus`,`elementPicture`) ",
            "values",
            " <foreach collection='excelList' item='element' separator=','> ",
            "     (#{element.buildingNumber}, #{element.elementNumber}, #{element.floorNumber}, #{element.households},  #{element.elevatorstatus}, #{element.elementPicture}) ",
            " </foreach>",
            "</script>"
    })
    void insertBatch(@Param("excelList") List<Excel> excelList);


}
