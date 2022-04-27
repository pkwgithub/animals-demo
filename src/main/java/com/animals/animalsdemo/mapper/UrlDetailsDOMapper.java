package com.animals.animalsdemo.mapper;


import com.animals.animalsdemo.dbdo.UrlDetailsDO;

import java.util.List;

public interface UrlDetailsDOMapper {
    int insert(UrlDetailsDO urlDetailsDO);

    int insertSelective(UrlDetailsDO urlDetailsDO);

    int insertBatch(List<UrlDetailsDO> urlDetailsDOList);

    List<UrlDetailsDO> getByUid(String id);

    int deleteByUid(String id);
}