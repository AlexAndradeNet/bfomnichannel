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
package com.bf.omnichannel.enums.vhq;

import com.bf.omnichannel.enums.EnumUtils;
import com.bf.omnichannel.enums.IValuableEnum;
import lombok.Getter;

@Getter
public enum VhqMakeAndModelEnum implements IValuableEnum {
    NONE(""),
    T650C("T650c"),
    T650P("T650p"),
    ;

    private final String value;

    VhqMakeAndModelEnum(String value) {
        this.value = value;
    }

    // Use the helper method from EnumUtils
    public static VhqMakeAndModelEnum fromValue(String s) {
        return EnumUtils.fromValue(VhqMakeAndModelEnum.class, s);
    }
}
