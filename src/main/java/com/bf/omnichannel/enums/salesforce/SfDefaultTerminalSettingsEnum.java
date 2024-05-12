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

import com.bf.omnichannel.enums.EnumUtils;
import com.bf.omnichannel.enums.IValuableEnum;
import lombok.Getter;

@Getter
public enum SfDefaultTerminalSettingsEnum implements IValuableEnum {
    NONE("--None--"),
    RETAIL_SETUP("RETAIL Set-up"),
    RETAIL_WITH_TIP_SETUP("RETAIL with Tip Set-up"),
    RESTAURANT_SETUP("Restaurant Set-up"),
    MOTO("MOTO");

    private final String value;

    SfDefaultTerminalSettingsEnum(String value) {
        this.value = value;
    }

    // Use the helper method from EnumUtils
    public static SfDefaultTerminalSettingsEnum fromValue(String s) {
        return EnumUtils.fromValue(SfDefaultTerminalSettingsEnum.class, s);
    }
}
