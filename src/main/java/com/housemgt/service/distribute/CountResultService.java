package com.housemgt.service.distribute;

import com.housemgt.model.CountResult;
import java.util.List;
import java.util.Map;

public interface CountResultService {

    /**
     *  通过员工代码、姓名、学院、公示次数来查询 --- 分页
     * @param entry
     * @return
     */
    List<CountResult> select(Map entry, Integer pageNumber , Integer pageSize);

    /**
     * 统计条数
     * @param entry
     * @return
     */
    int count(Map entry);

    /**
     * 更新计分统计结果
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CountResult record);

    /**
     * 添加计分统计结果
     * @param record
     * @return
     */
    int insertSelective(CountResult record);
}
