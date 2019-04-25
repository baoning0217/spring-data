package com.xishanqu.springdata.common.base;


public interface BasePage {

    void setPageNo(int var1);
    int getPageNo();
    void setTotalCount(int var1);
    int getTotalCount();
    void setSortName(String var1);
    String getSortName();
    void setSortOrder(String var1);
    String getSortOrder();
    int getOffset();
    void setOffset(int var1);
    int getPageSize();
    void setPageSize(int var1);
    boolean visible();
    void setVisible(boolean var1);
    void setParam(String var1, Object var2);
    Object getParam(String var1);

}
