package com.gabbriellps.jpa.specification.api.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;


public class PaginationHelper {
    public static <T> List<T> getPage(List<T> list, Pageable pageable) {

        return list.stream()
                .skip((long) pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .collect(Collectors.toList());
    }

    public static <T> Page<T> getPagination(List<T> list, Pageable pageable) {

        List<T> pageList = getPage(list, pageable);

        return new PageImpl<>(pageList, pageable, list.size());
    }

}