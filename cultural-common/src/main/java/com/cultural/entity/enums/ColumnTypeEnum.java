package com.cultural.entity.enums;

public enum ColumnTypeEnum {

    ORDINARY(0, "普通栏目"),
    POSTER(1, "海报栏目"),
    LINK(2, "链接栏目");


    private Integer type;
    private String desc;

    ColumnTypeEnum(Integer status, String desc) {
        this.type = status;
        this.desc = desc;
    }

    public static ColumnTypeEnum getByType(Integer type) {
        for (ColumnTypeEnum item : ColumnTypeEnum.values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
