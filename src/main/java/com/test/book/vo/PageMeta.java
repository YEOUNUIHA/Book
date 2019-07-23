package com.test.book.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageMeta {
    private boolean is_end;
    private int pageable_count;
    private int total_count;
}
