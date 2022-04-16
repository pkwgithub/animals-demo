package com.animals.animalsdemo.controller.base;

import com.animals.animalsdemo.allService.outService.base.BaseService;
import com.animals.animalsdemo.domain.query.base.BaseTypeDictQuery;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/8/27
 */

@RestController
@RequestMapping("/baseController")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping(value = "/searchBaseTypeDict")
    @ResponseBody
    public Response searchBaseTypeDict(@RequestBody(required = false) BaseTypeDictQuery baseTypeDictQuery){
        return  baseService.listByCondition(baseTypeDictQuery);
    }

    @PostMapping(value = "/addPetsType")
    @ResponseBody
    public Response
    addPetsType(@RequestBody(required = false) List<PetsTypeDictReqDTO> petsTypeDictList){
        return  baseService.addPetsBaseTypeDict(petsTypeDictList);
    }


    @PostMapping(value = "/deletePetsType")
    @ResponseBody
    public Response deletePetsType(@RequestBody(required = false)PetsTypeDictReqDTO petsTypeDictReqDTO){
        return  baseService.deletePetsBaseTypeDict(petsTypeDictReqDTO);
    }

    @PostMapping(value = "/savePetsType")
    @ResponseBody
    public Response savePetsType(@RequestBody(required = false)PetsTypeDictReqDTO petsTypeDictReqDTO){
        return  baseService.savePetsBaseTypeDict(petsTypeDictReqDTO);
    }
}
