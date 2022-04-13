package com.animals.animalsdemo.model.base;

import com.animals.animalsdemo.dbdo.BaseTypeDictDO;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.domain.response.base.BaseTypeDictRespDTO;
import com.animals.animalsdemo.model.factory.base.BaseTypeDictFactory;

/**
 * @author pankewei
 * @date 2021/9/2
 */
public class BaseTypeDictModel {
    private BaseTypeDictDO baseTypeDictDO;
    public BaseTypeDictModel(BaseTypeDictDO baseTypeDictDO){
        this.baseTypeDictDO = baseTypeDictDO;
    }
    public BaseTypeDictRespDTO toResp(){
        return BaseTypeDictFactory.toResp(baseTypeDictDO);
    }

    private PetsTypeDictReqDTO petsTypeDictReqDTO;
    public BaseTypeDictModel(PetsTypeDictReqDTO petsTypeDictReqDTO){
        this.petsTypeDictReqDTO = petsTypeDictReqDTO;
    }
    public BaseTypeDictDO petsTypeReqDTOToDo(){
        return BaseTypeDictFactory.petsTypeReqDTOToDo(petsTypeDictReqDTO);
    }
}
