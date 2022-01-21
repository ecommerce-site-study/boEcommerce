package com.teckstudy.book.domain.category;


import com.teckstudy.book.domain.base.types.YesNoStatus;
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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String displayName;

    private Long parentId;
    private Long ordering;

    private YesNoStatus useYn;
    private YesNoStatus displayYn;

    private Category( String displayName, Long parentId, Long ordering, YesNoStatus useYn, YesNoStatus displayYn) {
        this.displayName = displayName;
        this.parentId = parentId;
        this.ordering = ordering;
        this.useYn = useYn;
        this.displayYn = displayYn;
    }

    public static Category newCategory(String displayName, Long parentId, Long ordering, YesNoStatus useYn, YesNoStatus displayYn) {
        return new Category(displayName,parentId,ordering,useYn,displayYn);
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
    public Long ordering(){return this.ordering;}
    public YesNoStatus useYn() {return this.useYn;}
    public YesNoStatus displayYn() {return this.displayYn;}

}