package com.teckstudy.book.feature.domain.category;


import com.teckstudy.book.feature.domain.base.types.YesNoStatus;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String displayName;

    private Long parentId;
    private Long ordering;

    @Enumerated(EnumType.STRING)
    private YesNoStatus useYn;

    @Enumerated(EnumType.STRING)
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
    public String useYn() {return this.useYn.name();}
    public String displayYn() {return this.displayYn.name();}

    public void update(String displayName, Long parentId, Long ordering, YesNoStatus useYn, YesNoStatus displayYn) {
        this.displayName = displayName;
        this.parentId = parentId;
        this.ordering = ordering;
        this.useYn = useYn;
        this.displayYn = changeDisplay(useYn,displayYn);
    }

    private YesNoStatus changeDisplay(YesNoStatus useYn, YesNoStatus displayYn) {
        if (YesNoStatus.N == useYn) return YesNoStatus.N;
        return displayYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}