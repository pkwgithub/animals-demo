package com.animals.animalsdemo.unit;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author pankewei
 * @date 2021/8/24
 */
@Data
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -5671169753612942647L;
    /**
     * 每页10条初始化
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 开始条数
     */
    private Integer startIndex;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 数据
     */
    private List<T> pageList;

    public Integer getStartIndex(){
        if(currentPage != null && pageSize != null){
            if(currentPage < 1){
                currentPage = 1;
            }
            startIndex = (currentPage-1) * pageSize;
        }
        return startIndex;
    }

    public Page(Integer totalCount, List<T> pageList) {
        this.totalCount = totalCount;
        this.pageList = pageList;
    }

    public Page() {

    }
}
