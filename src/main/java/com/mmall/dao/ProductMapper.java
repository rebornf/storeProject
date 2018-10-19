package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectList();

    List<Product> selectByNameAndProductId(@Param(value = "productName") String productName, @Param(value = "productId") String productId);

    List<Product> selectByKeywordAndCategoryId(@Param(value = "categoryId") Integer categoryId, @Param(value = "keyword") String keyword,
                                               @Param(value = "sortField") String sortField,@Param(value = "sortOrder") String sortOrder);

}