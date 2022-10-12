package com.animals.animalsdemo.mapper;

import com.animals.animalsdemo.dbdo.BaseTypeDictDO;
import com.animals.animalsdemo.dbdo.BaseTypeDict;
import com.animals.animalsdemo.model.base.BaseTypeDictQueryModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author pankewei
 */
public interface BaseTypeDictDOMapper extends BaseMapper<BaseTypeDict> {

    /**
     * 根据id查询数据
     */
    BaseTypeDictDO getById(BaseTypeDictQueryModel baseTypeDictQueryModel);

    /**
     * 插入基础字典
     * @param baseTypeDictDO
     * @return
     */
    int insert(BaseTypeDictDO baseTypeDictDO);

    /**
     *按条件插入基础字典
     * @param baseTypeDictDO
     * @return
     */
    int insertSelective(BaseTypeDictDO baseTypeDictDO);

    /**
     * 根据条件查询基础字典
     * @param baseTypeDictQueryModel
     * @return
     */
    List<BaseTypeDictDO> listByCondition(BaseTypeDictQueryModel baseTypeDictQueryModel);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    int deleteById(Integer  id);

    int saveById(BaseTypeDictDO baseTypeDictDO);
}