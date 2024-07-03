package com.cultural.entity.enums;


public enum ColumnStatusEnum {

    DISABLE(0, "禁用"),
    ENABLE(1, "启用");


    private Integer status;
    private String desc;

    ColumnStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static ColumnStatusEnum getByStatus(Integer status) {
        for (ColumnStatusEnum item : ColumnStatusEnum.values()) {
            if (item.getStatus().equals(status)) {
                return item;
            }
        }
        return null;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
