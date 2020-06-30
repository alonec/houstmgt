package com.housemgt.dao;


import com.housemgt.model.CoupleBack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoupleBackDao {

    String TABLE_NAME = "couple_back";
    String INSET_FIELDS = "no,name,staffCode,message";

    //用户提交反馈信息
    @Insert({"insert into ",TABLE_NAME,"(",INSET_FIELDS,") values (#{no},#{name},#{staffCode},#{message})"})
    void addBack(CoupleBack c);

    //管理员查看所有反馈信息
    @Select({"select count(*) from",TABLE_NAME})
    int getAllBackNum();
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"limit #{page},10"})
    List<CoupleBack> getBackMessage(int page);

    //管理员根据公示次数查看反馈信息
    @Select({"select count(*) from",TABLE_NAME,"where no=#{no}"})
    int getAllBackNumByNO(int no);
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where no=#{no}"})
    List<CoupleBack> getBackMessageByNo(int no);

    //管理员根据反馈人查看反馈信息
    @Select({"select count(*) from",TABLE_NAME,"where name=#{name}"})
    int getAllBackNumByName(String name);
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where name=#{name} "})
    List<CoupleBack> getBackMessageByName(String name);

}
