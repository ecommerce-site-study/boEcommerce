package com.teckstudy.book.ui.category.dto;

import com.teckstudy.book.application.category.dto.CategoryWrapper;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryRequest {


    @Getter
    @NoArgsConstructor
    public static class RegisterCategory {
        private Long parentId;
        private String displayName;
        private Long ordering;
        private String useYn;
        private String displayYn;

        public CategoryWrapper.PersistCategory toWrapper() {
            return CategoryWrapper.PersistCategory.builder()
                    .parentId(this.parentId)
                    .displayName(this.displayName)
                    .ordering(this.ordering)
                    .useYn(this.useYn)
                    .displayYn(this.displayYn)
                    .build();
        }
    }
}
