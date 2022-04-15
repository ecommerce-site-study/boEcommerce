package com.teckstudy.book.feature.lib.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UploadResult {

    private int code; // 100 성공
    private List<String> path;
}