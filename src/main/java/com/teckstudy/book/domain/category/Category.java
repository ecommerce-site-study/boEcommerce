package com.teckstudy.book.domain.category;


import com.teckstudy.book.domain.base.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String displayName;

    private Long parentId;

    public Long categoryId() {
        return this.categoryId;
    }

    public String displayName() {
        return this.displayName;
    }
    public Long parentId() {
        return this.parentId;
    }

}