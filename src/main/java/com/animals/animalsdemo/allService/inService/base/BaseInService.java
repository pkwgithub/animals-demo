package com.animals.animalsdemo.allService.inService.base;

import com.animals.animalsdemo.domain.query.base.BaseTypeDictQuery;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.domain.response.base.BaseTypeDictRespDTO;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/9/2
 */
public interface BaseInService {

    /**
     * 根据条件查询基础字典列表
     * @param baseTypeDictQuery
     * @return
     */
    List<BaseTypeDictRespDTO> listByCondition(BaseTypeDictQuery baseTypeDictQuery);

    /**
     * 添加宠物字典
     * @param petsTypeDictList
     */
    void addBaseTypeDict(List<PetsTypeDictReqDTO> petsTypeDictList);


    void deleteBaseTypeDictById(Integer id);

    void saveBaseTypeDictById(PetsTypeDictReqDTO petsTypeDictReqDTO);
}
