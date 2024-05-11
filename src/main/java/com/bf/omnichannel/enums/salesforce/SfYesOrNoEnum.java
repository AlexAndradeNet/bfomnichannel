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
package com.bf.omnichannel.enums.salesforce;

import com.bf.omnichannel.utils.EnumUtils;
import lombok.Getter;

@Getter
public enum SfYesOrNoEnum {
    NONE("--None--"),
    YES("Yes"),
    NO("No"),
    ;

    private final String value;

    SfYesOrNoEnum(String value) {
        this.value = value;
    }

    // Use the helper method from EnumUtils
    public static SfYesOrNoEnum fromValue(String s) {
        return EnumUtils.fromValue(SfYesOrNoEnum.class, s);
    }
}
