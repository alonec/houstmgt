package com.housemgt.mapper;

import com.housemgt.model.CountResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CountResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CountResult record);

    int insertSelective(CountResult record);

    CountResult selectByPrimaryKey(Integer id);

    /**
     *  通过员工代码、姓名、学院、公示次数来查询
     * @param entry
     * @return
     */
    List<CountResult> select(@Param("entry") Map entry);

    /**
     * 统计条数
     * @param entry
     * @return
     */
    int count(@Param("entry") Map entry);

    int updateByPrimaryKeySelective(CountResult record);

    int updateByPrimaryKey(CountResult record);
}