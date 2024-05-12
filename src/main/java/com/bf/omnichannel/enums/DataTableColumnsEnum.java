/*
nuvei.com CONFIDENTIAL

Copyright (c) 2024. All Rights Reserved.

NOTICE: The source code contained or described herein and all documents
related to the source code ("Material") are owned by Nuvei Inc.
or its companies, suppliers or licensors.

Dissemination of this information or reproduction of this material
is strictly forbidden unless prior written permission is obtained
from Nuvei Inc.
*/
package com.bf.omnichannel.enums;

import lombok.Getter;

@Getter
public enum DataTableColumnsEnum implements IValuableEnum {
    SALESFORCE("SALESFORCE"),
    SF_VALUE("SF_VALUE"),
    EXPECTED_VHQ_VALUE("EXPECTED_VHQ_VALUE"),
    VHQ_VALUE("VHQ_VALUE"),
    VHQ_FIELD("VHQ_FIELD"),
    ;

    private final String value;

    DataTableColumnsEnum(String value) {
        this.value = value;
    }

    // Use the helper method from EnumUtils
    public static DataTableColumnsEnum fromValue(String s) {
        return EnumUtils.fromValue(DataTableColumnsEnum.class, s);
    }
}
