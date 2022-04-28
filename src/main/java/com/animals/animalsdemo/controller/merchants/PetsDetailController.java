package com.animals.animalsdemo.controller.merchants;

import com.animals.animalsdemo.allService.outService.merchants.PetsDetailService;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.request.merchants.AddPetsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.EditPetsDetailReqDTO;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 宠物区的controller
 */
@RestController
@RequestMapping("/petsController")
public class PetsDetailController {


    @Autowired
    private PetsDetailService petsDetailService;

    /**
     * 获取宠物信息
     * @param pagePetsQuery
     * @return
     */
    @PostMapping(value = "/getPetsInfoPage")
    @ResponseBody
    public Response getDogsInfoPage(@RequestBody(required = false) PagePetsQuery pagePetsQuery){
        return petsDetailService.pageInfo(pagePetsQuery);
    }

    /**
     * 保存宠物信息
     * @param addPetsDetailReqDTO
     * @return
     */
    @PostMapping(value = "/savePetsInfo")
    @ResponseBody
    public Response savePetsInfo(@RequestBody(required = false) AddPetsDetailReqDTO addPetsDetailReqDTO){
        return petsDetailService.savePetsInfo(addPetsDetailReqDTO);
    }


    /**
     * 编辑宠物信息
     * @param editPetsDetailReqDTO
     * @return
     */
    @PostMapping(value = "/editPetsInfo")
    @ResponseBody
    public Response savePetsInfo(@RequestBody(required = false) EditPetsDetailReqDTO editPetsDetailReqDTO){
        return petsDetailService.editPetsInfo(editPetsDetailReqDTO);
    }


    /**
     * 删除宠物信息
     * @param editPetsDetailReqDTO
     * @return
     */
    @PostMapping(value = "/deletePetsInfo")
    @ResponseBody
    public Response deletePetsInfo(@RequestBody(required = false) EditPetsDetailReqDTO editPetsDetailReqDTO){
        return petsDetailService.deletePetsInfo(editPetsDetailReqDTO);
    }


}
