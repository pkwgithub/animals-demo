package com.animals.animalsdemo.allService.outService.base.impl;

import com.animals.animalsdemo.allService.inService.base.BaseInService;
import com.animals.animalsdemo.allService.outService.base.BaseService;
import com.animals.animalsdemo.domain.query.base.BaseTypeDictQuery;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.domain.response.base.BaseTypeDictRespDTO;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/9/2
 */
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseInService baseInService;

    @Override
    public Response<List<BaseTypeDictRespDTO>> listByCondition(BaseTypeDictQuery baseTypeDictQuery) {
        try{
            return setSuccess(baseInService.listByCondition(baseTypeDictQuery));
        }catch (Exception e){
            return setFail(e);
        }

    }

    @Override
    public Response<Void> addPetsBaseTypeDict(List<PetsTypeDictReqDTO> petsTypeDictList) {
        try {
            baseInService.addBaseTypeDict(petsTypeDictList);
            return setSuccess(null);
        }catch (Exception e){
            return setFail(e);
        }
    }

    @Override
    public Response<Void> deletePetsBaseTypeDict(PetsTypeDictReqDTO petsTypeDictReqDTO) {
        try {
            baseInService.deleteBaseTypeDictById(petsTypeDictReqDTO.getId());
            return setSuccess(null);
        }catch (Exception e){
            return setFail(e);
        }
    }

    @Override
    public Response<Void> savePetsBaseTypeDict(PetsTypeDictReqDTO petsTypeDictReqDTO) {
        try {
            baseInService.saveBaseTypeDictById(petsTypeDictReqDTO);
            return setSuccess(null);
        }catch (Exception e){
            return setFail(e);
        }
    }

    private Response setSuccess(Object o){
        Response rs = new Response();
        rs.setMsg("成功");
        rs.setCode(200);
        rs.setResult(o);
        rs.setStatus(true);
        return rs;
    }

    private Response setFail(Exception e){
        Response rs = new Response();
        rs.setMsg("失败:"+e);
        rs.setCode(-1);
        rs.setStatus(false);
        return rs;
    }
}
