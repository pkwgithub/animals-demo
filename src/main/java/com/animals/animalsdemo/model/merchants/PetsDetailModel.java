package com.animals.animalsdemo.model.merchants;


import com.animals.animalsdemo.dbdo.PetsDetailDO;
import com.animals.animalsdemo.domain.request.merchants.AddPetsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.EditPetsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.domain.response.merchants.PetsDetailRespDTO;
import com.animals.animalsdemo.model.factory.merchants.PetsDetailModelFactory;

/**
 * @author pankewei
 * @date 2022年04月24日15:54:53
 */
public class PetsDetailModel {
    private AddPetsDetailReqDTO addPetsDetailReqDTO;
    public PetsDetailModel(AddPetsDetailReqDTO addPetsDetailReqDTO){
        this.addPetsDetailReqDTO = addPetsDetailReqDTO;
    }
    public PetsDetailDO addPetsDetailReqToDo(){
        return PetsDetailModelFactory.addPetsDetailReqToDo(addPetsDetailReqDTO);
    }

    private PetsDetailDO petsDetailDO;
    public PetsDetailModel(PetsDetailDO petsDetailDO){
        this.petsDetailDO = petsDetailDO;
    }
    public PetsDetailRespDTO doToResp(){
        return PetsDetailModelFactory.doToResp(petsDetailDO);
    }

    public PagePetsDetailRespDTO doToPageRespDTO(){
        return PetsDetailModelFactory.doToPageRespDTO(petsDetailDO);
    }


    private EditPetsDetailReqDTO editPetsDetailReqDTO;
    public PetsDetailModel(EditPetsDetailReqDTO editPetsDetailReqDTO){
        this.editPetsDetailReqDTO = editPetsDetailReqDTO;
    }
    public PetsDetailDO editPetsDetailReqToDo(){
        return PetsDetailModelFactory.editPetsDetailReqToDo(editPetsDetailReqDTO);
    }

}
