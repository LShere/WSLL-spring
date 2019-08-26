package spring.pojo;

import java.util.List;

public class Page<T> {
    private int currentPage;    //当前页数
    private int totalPages;       //总页数
    private int totalUsers;            //记录总行数
    private int pageSize=10;    //每页记录行数
    private int nextPage;        //下一页
    private int prefPage;       //前一页
    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        totalPages = totalUsers % pageSize == 0 ? totalUsers / pageSize : totalUsers / pageSize + 1;
        return totalPages;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPage() {
/*        if (currentPage < totalPages) {
            nextPage = currentPage + 1;
        } else {
            nextPage = currentPage;
        }*/
        return nextPage;
    }

    public int getPrefPage() {
/*        if (currentPage > 1) {
            prefPage = currentPage - 1;
        } else {
            prefPage = currentPage;
        }*/
        return prefPage;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setPrefPage(int prefPage) {
        this.prefPage = prefPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}