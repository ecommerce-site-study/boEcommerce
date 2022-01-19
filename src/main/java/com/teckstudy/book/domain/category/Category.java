package com.teckstudy.book.domain.category;


import com.teckstudy.book.domain.base.BaseEntity;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@NoArgsConstructor
//public class Category extends BaseEntity {
public class Category  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String displayName;

    private Long parentId;
    private Long order;

    public Category(Long categoryId, String displayName, Long parentId, Long order) {
        this.categoryId = categoryId;
        this.displayName = displayName;
        this.parentId = parentId;
        this.order = order;
    }

    public Long categoryId() {
        return this.categoryId;
    }
    public String displayName() {
        return this.displayName;
    }
    public Long parentId() {
        return this.parentId;
    }
    public Long order(){return this.order;}

}