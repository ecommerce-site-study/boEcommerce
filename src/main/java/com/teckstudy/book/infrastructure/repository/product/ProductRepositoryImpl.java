package com.teckstudy.book.infrastructure.repository.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.domain.product.repository.ProductRepositoryCustom;
import com.teckstudy.book.ui.product.ProductsResponseDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<ProductsResponseDto> findAllDesc(Long id) throws Exception  {
        return null;
//                queryFactory
//                .select(new QProductsResponseDto(
//                          productOption.product_option_sn.as("product_option_sn")
//                        , product.product_sn.as("product_sn")
//                        , productOption.plus_price.as("plus_price")
//                        , productOption.product_option_name.as("product_option_name")
//                        , product.price.as("price")
//                        , product.product_name.as("product_name")
//                        , product.product_option.as("product_option")
//                        , productOption.stock_cnt.as("stock_cnt")
//
//                ))
//                .from(productOption)
//                .leftJoin(product).on(product.product_sn.eq(productOption.product.product_sn))
//                .where(product.product_sn.eq(id))
//                .fetch();
    }

}
