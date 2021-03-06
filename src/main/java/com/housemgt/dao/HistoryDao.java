package com.housemgt.dao;

import com.housemgt.model.History;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HistoryDao {
    /**表名*/
    String TABLE_NAME = "history";


    String INSET_FIELDS = "doorNumber,buildingNumber,elementnumber,housenumber,residentsToChange,infrastructureChanges,s" +
            "tructuremodify,time1,time2,time3";

    //String SELECT_FIELDS = "id"+INSET_FIELDS;
    //添加操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{doorNumber},#{buildingNumber},#{elementnumber},#{hou" +
            "senumber},#{residentsToChange},#{infrastructureChanges},#{structuremodify},#{time1},#{time2},#{time3})" })
    void addHistory(History history);

    //分页查询
    @Select({"select count(*) from",TABLE_NAME})
    int getAllHistoryNum();
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME," limit #{pageRange}, 10"})
    List<History> getAllHistory(@Param("pageRange") int pageRange);

    //编辑房屋历史修改信息
    @Update({"update",TABLE_NAME,"set residentsToChange=#{residentsToChange},infrastructureChanges=#{infrastructureChang" +
            "es},structuremodify=#{structuremodify},time1=#{time1},time2=#{time2},time3=#{time3} where doorNumber=#{door" +
            "Number} and buildingNumber=#{buildingNumber} and elementnumber=#{elementnumber} and housenumber=#{housenumb" +
            "er} "})
    void updateMessage(History history);

    //根据小区编号 楼宇编号  单元编号 房屋编号查询历史变更记录
    @Select({"select",INSET_FIELDS,"from",TABLE_NAME,"where doorNumber=#{doorNumber} and buildingNumber=#{buildingNumber} and elementnumber=#{elementnumber} and housenumber=#{housenumber}"})
    List<History> findHistory(@Param("doorNumber") String doorNumber,@Param("buildingNumber") String buildingNumber,@Param("elementnumber") String elementnumber,@Param("housenumber") String housenumber);

}
