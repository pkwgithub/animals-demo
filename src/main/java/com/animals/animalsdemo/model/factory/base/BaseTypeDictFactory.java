package com.animals.animalsdemo.model.factory.base;

import com.animals.animalsdemo.dbdo.BaseTypeDictDO;
import com.animals.animalsdemo.domain.query.base.BaseTypeDictQuery;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.domain.response.base.BaseTypeDictRespDTO;
import com.animals.animalsdemo.model.base.BaseTypeDictQueryModel;

import java.util.Date;

/**
 * @author pankewei
 * @date 2021/9/2
 */
public class BaseTypeDictFactory {

    public static BaseTypeDictQueryModel baseTypeDictQueryToModel(BaseTypeDictQuery baseTypeDictQuery){
        BaseTypeDictQueryModel baseTypeDictQueryModel = new BaseTypeDictQueryModel();
        baseTypeDictQueryModel.setType(baseTypeDictQuery.getType());
        baseTypeDictQueryModel.setCodeTypeName(baseTypeDictQuery.getCodeTypeName());
        return baseTypeDictQueryModel;
    }

    public static BaseTypeDictRespDTO toResp(BaseTypeDictDO baseTypeDictDO) {
        BaseTypeDictRespDTO baseTypeDictRespDTO = new BaseTypeDictRespDTO();
        baseTypeDictRespDTO.setId(baseTypeDictDO.getId());
        baseTypeDictRespDTO.setCode(baseTypeDictDO.getCode());
        baseTypeDictRespDTO.setName(baseTypeDictDO.getName());
        baseTypeDictRespDTO.setSort(baseTypeDictDO.getSort());
        return baseTypeDictRespDTO;
    }

    public static BaseTypeDictDO petsTypeReqDTOToDo(PetsTypeDictReqDTO petsTypeDictReqDTO){
        Date date = new Date();
        BaseTypeDictDO baseTypeDictDO = new BaseTypeDictDO();
        if(petsTypeDictReqDTO != null){
            baseTypeDictDO.setId(petsTypeDictReqDTO.getId());
        }
        baseTypeDictDO.setType(petsTypeDictReqDTO.getType());
        baseTypeDictDO.setCode(petsTypeDictReqDTO.getCode());
        baseTypeDictDO.setName(petsTypeDictReqDTO.getName());
        baseTypeDictDO.setSort(petsTypeDictReqDTO.getSort());
        baseTypeDictDO.setCodeTypeName(petsTypeDictReqDTO.getCodeTypeName());
        baseTypeDictDO.setCreateBy(petsTypeDictReqDTO.getCreateBy());
        baseTypeDictDO.setCreateDate(date);
        baseTypeDictDO.setUpdateBy(petsTypeDictReqDTO.getUpdateBy());
        baseTypeDictDO.setUpdateDate(date);
//        baseTypeDictDO.setVersion(0);
        return baseTypeDictDO;
    }
}
