package com.exa.pesa.core.model;

import java.util.ArrayList;
import java.util.List;

public class PageWrapper<T> {
    private Long totalItems;
    private Integer numOfPages;
    private Integer pageSize;
    private List<T> pageContent;

    public PageWrapper() {
        super();
    }

    public PageWrapper(Long totalItems, Integer numOfPages, Integer pageSize, List<T> pageContent) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageWrapper<?> pageWrapper = (PageWrapper<?>) o;

        if (totalItems != null ? !totalItems.equals(pageWrapper.totalItems) : pageWrapper.totalItems != null) return false;
        if (numOfPages != null ? !numOfPages.equals(pageWrapper.numOfPages) : pageWrapper.numOfPages != null) return false;
        if (pageSize != null ? !pageSize.equals(pageWrapper.pageSize) : pageWrapper.pageSize != null) return false;
        return pageContent != null ? pageContent.equals(pageWrapper.pageContent) : pageWrapper.pageContent == null;
    }

    @Override
    public int hashCode() {
        int result = totalItems != null ? totalItems.hashCode() : 0;
        result = 31 * result + (numOfPages != null ? numOfPages.hashCode() : 0);
        result = 31 * result + (pageSize != null ? pageSize.hashCode() : 0);
        result = 31 * result + (pageContent != null ? pageContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageWrapper{" +
                "totalItems=" + totalItems +
                ", numOfPages=" + numOfPages +
                ", pageSize=" + pageSize +
                ", pageContent=" + pageContent +
                '}';
    }
}
