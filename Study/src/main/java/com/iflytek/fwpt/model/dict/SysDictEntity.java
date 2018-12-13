package com.iflytek.fwpt.model.dict;

import java.io.Serializable;

/**
 * tbl_sys_dict
 * @author 
 */
public class SysDictEntity implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 字典类型编码
     */
    private String dictTypeCode;

    /**
     * 字典类型名称
     */
    private String dictTypeName;

    /**
     * 字典编码值
     */
    private String dictCode;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典序号
     */
    private Integer sort;

    /**
     * 备注信息
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public SysDictEntity() {
    }

    private SysDictEntity(Builder builder) {
        setId(builder.id);
        setDictTypeCode(builder.dictTypeCode);
        setDictTypeName(builder.dictTypeName);
        setDictCode(builder.dictCode);
        setDictName(builder.dictName);
        setSort(builder.sort);
        setRemark(builder.remark);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public static final class Builder {

        private Integer id;
        private String dictTypeCode;
        private String dictTypeName;
        private String dictCode;
        private String dictName;
        private Integer sort;
        private String remark;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder dictTypeCode(String val) {
            dictTypeCode = val;
            return this;
        }

        public Builder dictTypeName(String val) {
            dictTypeName = val;
            return this;
        }

        public Builder dictCode(String val) {
            dictCode = val;
            return this;
        }

        public Builder dictName(String val) {
            dictName = val;
            return this;
        }

        public Builder sort(Integer val) {
            sort = val;
            return this;
        }

        public Builder remark(String val) {
            remark = val;
            return this;
        }

        public SysDictEntity build() {
            return new SysDictEntity(this);
        }
    }
}