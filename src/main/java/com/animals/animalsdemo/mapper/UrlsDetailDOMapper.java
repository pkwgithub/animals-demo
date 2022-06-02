package com.animals.animalsdemo.mapper;


import com.animals.animalsdemo.dbdo.UrlsDetailDO;

import java.util.List;

public interface UrlsDetailDOMapper {
    int insert(UrlsDetailDO urlsDetailDO);

    int insertSelective(UrlsDetailDO urlsDetailDO);

    int insertBatch(List<UrlsDetailDO> urlsDetailDOList);

    List<UrlsDetailDO> getByUid(String id);

    int deleteByUid(String id);
}