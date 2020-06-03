package com.housemgt.Dao;


import com.housemgt.model.Element;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ElementDao {
    String TABLE_NAME = "element";//表名

    String INSET_FIELDS = "buildingNumber,elementNumber,floorNumber,households,elevatorstatus,elementPicture";

    //添加操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{buildingNumber},#{elementNumber},#{floorNumber},#{households},#{elevatorstatus},#{elementPicture})" })
    void addElement(Element element);

    //删除操作
    @Delete({"delete from",TABLE_NAME,"where buildingNumber=#{arg0} and elementNumber=#{arg1} "})
    void deleteHome(String buildingNumber, String elementNumber);

    //删除所有单元操作
    @Delete({"delete from",TABLE_NAME,"where buildingNumber=#{arg0}"})
    void deleteAllElement(String buildingNumber);

    //更新单元信息
    @Update({"update",TABLE_NAME,"set floorNumber=#{floorNumber},households=#{households},elevatorstatus=#{elevatorstatus},elementPicture=#{elementPicture} where elementNumber=#{elementNumber} and buildingNumber=#{buildingNumber}"})
    void updateMessage(Element element);
}
