package com.housemgt.Dao;


import com.housemgt.model.Community;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//小区信息
@Mapper
@Repository
public interface CommunityDao {
    String TABLE_NAME = "community";//表名

    String INSET_FIELDS = "name,doorNumber,mailingAddress,postcode,linkman,phoneNumber,policeStation,policeman,policePhonenum,buildingPicture";

    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{name},#{doorNumber},#{mailingAddress},#{postcode},#{linkman},#{phoneNumber},#{policeStation},#{policeman},#{policePhonenum},#{buildingPicture})" })
    void addCommunity(Community community);

    @Delete({"delete from",TABLE_NAME,"where name=#{name} and doorNumber=#{name} "})
    void deleteCommunity(@Param("name") String name, @Param("doorNumber") String doorNumber);

    //更新操作
    @Update({"update",TABLE_NAME,"set mailingAddress=#{mailingAddress},postcode=#{postcode},linkman=#{linkman},phoneNumber=#{phoneNumber},policeStation=#{policeStation},policeman=#{policeman},policePhonenum=#{policePhonenum},buildingPicture=#{buildingPicture} where name=#{name} and doorNumber=#{doorNumber}"})
    void updateMessage(Community community);




}
