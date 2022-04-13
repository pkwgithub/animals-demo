package com.animals.animalsdemo.allService.inService.base.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.animals.animalsdemo.allService.inService.base.BaseInService;
import com.animals.animalsdemo.dbdo.BaseTypeDictDO;
import com.animals.animalsdemo.domain.query.base.BaseTypeDictQuery;
import com.animals.animalsdemo.domain.request.base.PetsTypeDictReqDTO;
import com.animals.animalsdemo.domain.response.base.BaseTypeDictRespDTO;
import com.animals.animalsdemo.mapper.BaseTypeDictDOMapper;
import com.animals.animalsdemo.model.base.BaseTypeDictModel;
import com.animals.animalsdemo.model.factory.base.BaseTypeDictFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pankewei
 * @date 2021/9/2
 */
public class BaseInServiceImpl implements BaseInService {

    @Autowired
    private BaseTypeDictDOMapper baseTypeDictDOMapper;

    @Autowired
    private TransactionTemplate animalTransactionTemplate;

    @Override
    public List<BaseTypeDictRespDTO> listByCondition(BaseTypeDictQuery baseTypeDictQuery) {
        List<BaseTypeDictDO> baseTypeDictDOList = baseTypeDictDOMapper.listByCondition(BaseTypeDictFactory.baseTypeDictQueryToModel(baseTypeDictQuery));
        if(CollectionUtils.isNotEmpty(baseTypeDictDOList)){
            return baseTypeDictDOList.stream().map(x->new BaseTypeDictModel(x).toResp()).collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }

    /**
     * 批量添加基础字典表
     * @param petsTypeDictList
     */
    @Override
    public void addBaseTypeDict(List<PetsTypeDictReqDTO> petsTypeDictList) {
        animalTransactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                petsTypeDictList.stream().forEach(x->{
                    baseTypeDictDOMapper.insertSelective(new BaseTypeDictModel(x).petsTypeReqDTOToDo());
                });
                return  true;
            }
        });
    }
}
