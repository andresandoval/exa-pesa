package com.exa.pesa.core.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Andres on 10/22/2017.
 */
public class PageWrapperView<T> {

    private Long totalItems;
    private Integer numOfPages;
    private Integer pageSize;
    private List<T> pageContent;

    public PageWrapperView() {
        this.totalItems = 0L;
        this.numOfPages = 0;
        this.pageSize = 0;
        this.pageContent = new ArrayList<>();
    }

    public PageWrapperView(Long totalItems, Integer numOfPages, Integer pageSize, List<T> pageContent) {
        this.totalItems = totalItems;
        this.numOfPages = numOfPages;
        this.pageSize = pageSize;
        this.pageContent = pageContent;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageContent() {
        return pageContent;
    }

    public void setPageContent(List<T> pageContent) {
        this.pageContent = pageContent;
    }
}
