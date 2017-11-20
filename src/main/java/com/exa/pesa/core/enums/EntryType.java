package com.exa.pesa.core.enums;

/**
 * Created by Andres on 21/10/2017.
 */
public enum EntryType {
    ALL(-1),
    BUY(0),
    DISPATCH(1),
    RECEPTION(2),
    SALE(3),
    OTHER(4);


    private Integer code;

    EntryType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EntryType getTypeFromCode(Integer code){
        switch (code){
            case -1: return ALL;
            case 0: return BUY;
            case 1: return DISPATCH;
            case 2: return RECEPTION;
            case 3: return SALE;
            case 4: return OTHER;
        }
        return null;
    }
}
