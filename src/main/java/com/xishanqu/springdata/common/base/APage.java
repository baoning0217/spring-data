package com.xishanqu.springdata.common.base;

import com.xishanqu.springdata.common.utils.BeanUtil;
import com.xishanqu.springdata.common.utils.ListUtils;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class APage<E> implements BasePage, Serializable {
    public static final int MAX_SIZE = 999999;
    public static final Integer DEFAULT_PAGE_SIZE = 20;//默认分20页
    public static final Integer DEFAULT_PAGE_NO = 1;
    public static final String DEFAULT_PAGE_SIZE_STRING;
    public static final String DEFAULT_PAGE_NO_STRING;
    public static final Integer DEFAULT_OFFSET_ID;
    public int order;
    private int pageNo;
    private int totalCount;//总数
    private int pageSize;
    private int offset;
    private Integer offsetId;
    private Boolean haveNextPage;
    private boolean isAll;
    private boolean visible;
    private String sortName;
    private String sort;
    private String sortOrder;
    private int id;
    private Map<String, Object> params;
    private E element;
    private List<E> list;
    private boolean requireCnt;

    public APage() {
        this.pageNo = DEFAULT_PAGE_NO;
        this.totalCount = 0;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.offset = 0;
        this.offsetId = DEFAULT_OFFSET_ID;
        this.isAll = false;
        this.visible = false;
        this.sortName = "id";
        this.sortOrder = "desc";
        this.params = new HashMap();
        this.requireCnt = false;
    }

    @Override
    public boolean visible() {
        return this.visible;
    }
    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    @Override
    public void setParam(String name, Object value) {
        if (this.params == null) {
            this.params = new HashMap();
        }

        this.params.put(name, value);
    }
    @Override
    public Object getParam(String name) {
        return this.params == null ? null : this.params.get(name);
    }

    public void prepare() {
        int pageNo = this.getPageNo();
        int offset = 0;
        if (pageNo != 0) {
            offset = (pageNo - 1) * this.getPageSize();
        }

        this.setOffset(offset);
    }

    public APage addParam(String name, Object value) {
        if (value == null) {
            return this;
        } else {
            if (this.params == null) {
                this.params = new HashMap();
            }

            if (value instanceof String) {
                value = ((String) value).trim();
            }

            this.params.put(name, value);
            return this;
        }
    }

    public APage removeParam(String name) {
        if (name == null) {
            return this;
        } else {
            if (this.params == null) {
                this.params = new HashMap();
            }

            this.params.remove(name);
            return this;
        }
    }

    public APage addParam(Object object) {
        if (object == null) {
            return this;
        } else {
            if (this.params == null) {
                this.params = new HashMap();
            }

            Map<String, Object> objectMap = BeanUtil.transBean2Map(object);
            this.params.putAll(objectMap);
            return this;
        }
    }

    public APage initPage(Integer pageNo, Integer pageSize) {
        if (!StringUtils.isEmpty(pageSize)) {
            this.setPageSize(pageSize);
        }

        if (!StringUtils.isEmpty(pageNo)) {
            this.setPageNo(pageNo);
        }

        this.prepare();
        return this;
    }

    public APage initOffset(Integer offsetId, Integer pageSize) {
        if (!StringUtils.isEmpty(pageSize)) {
            this.setPageSize(pageSize);
        }

        if (!StringUtils.isEmpty(offsetId)) {
            this.setOffsetId(offsetId);
        }

        return this;
    }

    public APage nextPageCheckInit() {
        if (!StringUtils.isEmpty(this.getPageSize())) {
            this.setPageSize(this.getPageSize() + 1);
        }

        return this;
    }

    public APage nextPageCheck() {
        if (!StringUtils.isEmpty(this.getPageSize())) {
            this.setPageSize(this.getPageSize() - 1);
        }

        this.setHaveNextPage(false);
        if (ListUtils.isNotEmpty(this.getList()) && this.getList().size() > this.getPageSize()) {
            this.setHaveNextPage(true);
            this.setList(this.getList().subList(0, this.pageSize));
        }

        return this;
    }

    static {
        DEFAULT_PAGE_SIZE_STRING = String.valueOf(DEFAULT_PAGE_SIZE);
        DEFAULT_PAGE_NO_STRING = String.valueOf(DEFAULT_PAGE_NO);
        DEFAULT_OFFSET_ID = -1;
    }
}