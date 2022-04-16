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
        Response<List<BaseTypeDictRespDTO>> rs = new Response<>();
        rs.setMsg("成功");
        rs.setCode(200);
        rs.setResult(baseInService.listByCondition(baseTypeDictQuery));
        rs.setStatus(true);
        return rs;
    }

    @Override
    public Response<Void> addPetsBaseTypeDict(List<PetsTypeDictReqDTO> petsTypeDictList) {
        Response<Void> rs = new Response<>();
        rs.setMsg("成功");
        rs.setCode(200);
        baseInService.addBaseTypeDict(petsTypeDictList);
        rs.setStatus(true);
        return rs;
    }

    @Override
    public Response<Void> deletePetsBaseTypeDict(PetsTypeDictReqDTO petsTypeDictReqDTO) {
        Response<Void> rs = new Response<>();
        rs.setMsg("成功");
        rs.setCode(200);
        baseInService.deleteBaseTypeDictById(petsTypeDictReqDTO.getId());
        rs.setStatus(true);
        return rs;
    }

    @Override
    public Response<Void> savePetsBaseTypeDict(PetsTypeDictReqDTO petsTypeDictReqDTO) {
        Response<Void> rs = new Response<>();

        try {
            baseInService.saveBaseTypeDictById(petsTypeDictReqDTO);
            rs.setMsg("成功");
            rs.setCode(200);
            rs.setStatus(true);

        }catch (Exception e){
            rs.setMsg("失败");
            rs.setCode(-1);
            rs.setStatus(false);

        }
        return rs;
    }
}
