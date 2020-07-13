package com.yht.springcloud.mapper;

import com.yht.springcloud.entities.TStorage;
import com.yht.springcloud.entities.TStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStorageMapper {
    long countByExample(TStorageExample example);

    int deleteByExample(TStorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TStorage record);

    int insertSelective(TStorage record);

    List<TStorage> selectByExample(TStorageExample example);

    TStorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TStorage record, @Param("example") TStorageExample example);

    int updateByExample(@Param("record") TStorage record, @Param("example") TStorageExample example);

    int updateByPrimaryKeySelective(TStorage record);

    int updateByPrimaryKey(TStorage record);
}