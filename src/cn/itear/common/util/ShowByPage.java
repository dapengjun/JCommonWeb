package cn.itear.common.util;

public class ShowByPage {

    private String param = null;
    private int page = 0;// 第几页
    private int rows = 0;// 一页有多少行
    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
}
