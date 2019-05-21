package com.satchain.bean.vo;

import java.util.List;

public class PageVO<T> {
    private int total;//总记录数
    private List<T> list;//每页的显示的数据

    public PageVO() {
        super();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
