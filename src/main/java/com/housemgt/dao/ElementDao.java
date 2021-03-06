package com.housemgt.dao;


import com.housemgt.model.Element;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ElementDao {
    String TABLE_NAME = "element";//表名

    String INSET_FIELDS = "buildingNumber,elementNumber,floorNumber,households,elevatorstatus,elementPicture";

    //添加操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{buildingNumber},#{elementNumber},#{floorNumber},#{ho" +
            "useholds},#{elevatorstatus},#{elementPicture})" })
    void addElement(Element element);

    //删除操作
    @Delete({"delete from",TABLE_NAME,"where buildingNumber=#{buildingNumber} and elementNumber=#{elementNumber} "})
    void deleteHome(@Param("buildingNumber") String buildingNumber, @Param("elementNumber") String elementNumber);

    //删除所有单元操作
    @Delete({"delete from",TABLE_NAME,"where buildingNumber=#{buildingNumber}"})
    void deleteAllElement(@Param("buildingNumber") String buildingNumber);

    //更新单元信息
    @Update({"update",TABLE_NAME,"set floorNumber=#{floorNumber},households=#{households},elevatorstatus=#{elevatorstatu" +
            "s},elementPicture=#{elementPicture} where elementNumber=#{elementNumber} and buildingNumber=#{buildingNumbe" +
            "r}"})
    void updateMessage(Element element);
}
