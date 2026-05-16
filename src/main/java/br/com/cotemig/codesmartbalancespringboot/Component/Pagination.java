package br.com.cotemig.codesmartbalancespringboot.Component;

public class Pagination {
    private final long pageSize = 10L;
    private final long page;
    private final long rows;
    private final long pages;

    public Pagination(long page, long rows) {
        this.page = page;
        this.rows = rows;
        this.pages = (rows / pageSize) + ((rows % pageSize > 0) ? 1 : 0);
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getPage() {
        return page;
    }

    public long getRows() {
        return rows;
    }

    public long getPages() {
        return pages;
    }

    public long getOffset() {
        return (page - 1) * pageSize;
    }
}
