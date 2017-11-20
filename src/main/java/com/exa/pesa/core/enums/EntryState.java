package com.exa.pesa.core.enums;

/**
 * Created by Andres on 21/10/2017.
 */
public enum EntryState {

    PENDING(0),
    IN_TRANSIT(1),
    ENDED(2);

    private Integer code;

    EntryState(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EntryState getStateFromCode(Integer code){
        switch (code){
            case 0: return PENDING;
            case 1: return IN_TRANSIT;
            case 2: return ENDED;
        }
        return null;
    }

    public static EntryState getStateFromEntryType(Integer entryTypeCode){
        return entryTypeCode.equals(EntryType.OTHER.getCode()) ? ENDED : PENDING;
    }
}
