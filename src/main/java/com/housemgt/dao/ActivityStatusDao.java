package com.housemgt.dao;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
    public interface ActivityStatusDao {


        String TABLE_NAME = "status";

    String INSERT_NAME = "name,staffCode,status";

    String IN_NAME ="(#{name},#{staffCode},#{status})";

    //审核中
    @Insert({"insert into",TABLE_NAME,"(",INSERT_NAME,") values",IN_NAME })
    void addStatus(@Param("name") String name,@Param("staffCode") String staffCode,@Param("status") int status);

    //更新状态
    @Update({"update",TABLE_NAME,"set status=#{name} where name=#{staffCode} and staffCode = #{status}"})
    void updateStatus(@Param("name") String name,@Param("staffCode") String staffCode,@Param("status") int status);

    //查询操作
    @Select({"select status from",TABLE_NAME,"where  staffCode= #{staffCode}"})
    int selectStatus(@Param("staffCode") String staffCode);
}
