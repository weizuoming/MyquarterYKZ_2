package com.example.hello.myquarterykz.model.bean;

import java.util.List;

/**
 * Created by 韦作铭 on 2018/4/22.
 */

public class SouSuoHaoYouBean {

    /**
     * msg : 查询成功
     * code : 0
     * data : []
     * page : -1
     */

    private String msg;
    private String code;
    private int page;
    private List<?> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
