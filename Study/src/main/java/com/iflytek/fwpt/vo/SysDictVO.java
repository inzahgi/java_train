package com.iflytek.fwpt.vo;


/**
 * <p>
 * 字典表VO
 * </p>
 *
 * @author conghuang
 * @version 1.0
 * @since 2018年8月23日上午9:50:54
 **/
public class SysDictVO {

    private String id;
    private String dictTypeCode;
    private String dictTypeName;
    private String dictCode;
    private String dictName;
    private String sort;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
