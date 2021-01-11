package com.sulai.aop.dict;

/**
 * @author :sulai
 * @version :1.0.0
 * @date :2021/1/9 9:18
 * @description: description
 */
public enum DictEnumValue {
    DICT_ENUM_VALUE1(1,"channel1"),
    DICT_ENUM_VALUE2(1,"channel2"),
    DICT_ENUM_VALUE3(1,"channel3"),
    DICT_ENUM_VALUE4(1,"channel4"),
    ;

    DictEnumValue(Integer dictId, String mappingDic) {
        this.dictId = dictId;
        this.mappingDic = mappingDic;
    }

    private Integer dictId;

    private String mappingDic;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getMappingDic() {
        return mappingDic;
    }

    public void setMappingDic(String mappingDic) {
        this.mappingDic = mappingDic;
    }

    public static String getDictName(Integer dictId) {
        for (DictEnumValue dict:DictEnumValue.values()) {
            if (dict.getDictId().equals(dictId)) {
                return dict.getMappingDic();
            }
        }
        throw new IllegalArgumentException("can't get dictName");
    }
}
