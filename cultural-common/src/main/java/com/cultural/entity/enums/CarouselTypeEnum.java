package com.cultural.entity.enums;

public enum CarouselTypeEnum {
    APP(0, "移动端"), PC(1, "PC端"), SUBJECT(2, "专题"), LINK(3, "外链");
    private Integer type;
    private String desc;

    CarouselTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CarouselTypeEnum getMenuTypeByType(Integer type) {
        if (null == type) {
            return null;
        }
        for (CarouselTypeEnum item : CarouselTypeEnum.values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
