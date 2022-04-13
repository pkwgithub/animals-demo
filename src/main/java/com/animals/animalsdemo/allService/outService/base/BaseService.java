package com.animals.animalsdemo.allService.outService.base;

import com.animals.animalsdemo.domain.query.base.BaseTypeDictQuery;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.domain.response.base.BaseTypeDictRespDTO;
import com.animals.animalsdemo.exception.Response;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/9/2
 */
public interface BaseService {

    /**
     * 根据条件查询基础字典
     * @param baseTypeDictQuery
     * @return
     */
    Response<List<BaseTypeDictRespDTO>> listByCondition(BaseTypeDictQuery baseTypeDictQuery);

    /**
     * 添加宠物字典
     * @param petsTypeDictList
     * @return
     */
    Response<Void> addPetsBaseTypeDict(List<PetsTypeDictReqDTO> petsTypeDictList);

}
