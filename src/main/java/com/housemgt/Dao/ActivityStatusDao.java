package com.housemgt.Dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ActivityStatusDao {


    String TABLE_NAME = "status";

    String INSERT_NAME = "name,staffCode,status";

    String IN_NAME ="(#{arg0},#{arg1},#{arg2})";
    //审核中
    @Insert({"insert into",TABLE_NAME,"(",INSERT_NAME,") values",IN_NAME })
    void addStatus(String name,String staffCode,int status);


    //更新状态
    @Update({"update",TABLE_NAME,"set status=#{arg2} where name=#{arg0} and staffCode = #{arg1}"})
    void updateStatus(String name,String staffCode,int status);



    //查询操作
    @Select({"select status from",TABLE_NAME,"where staffCode= #{arg0}"})
    int selectStatus(String staffCode);
}
