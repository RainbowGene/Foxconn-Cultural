package com.cultural.entity.enums;

/**
 * 试用一下 easy_job 项目里的上传图片接口
 */
public enum NewUploadFileEnum {
    CATEGORY(0, 150, "分类图片"),  
    CAROUSEL(1, 400, "轮播图"),  // 只用了这个
    SHARE_LARGE(2, 400, "分享大图"),
    SHARE_SMALL(3, 400, "分享小图");


    private Integer type;
    private Integer maxWidth;
    private String descripton;

    NewUploadFileEnum(Integer type, Integer maxWidth, String descripton) {
        this.type = type;
        this.maxWidth = maxWidth;
        this.descripton = descripton;
    }

    public Integer getType() {
        return type;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public String getDescripton() {
        return descripton;
    }

    public static NewUploadFileEnum getType(Integer type) {
        for (NewUploadFileEnum at : NewUploadFileEnum.values()) {
            if (at.type.equals(type)) {
                return at;
            }
        }
        return null;
    }
}
