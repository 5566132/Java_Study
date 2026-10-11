package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.TProduct;

/**
* @author lijinhan
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2026-10-09 22:44:37
* @Entity com.atguigu.mybatis.bean.TProduct
*/
//这个无Mapper注解
public interface TProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);

}
