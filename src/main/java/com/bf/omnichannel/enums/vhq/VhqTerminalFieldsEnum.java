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
public enum VhqTerminalFieldsEnum implements IValuableEnum {
    CLERK_ID("Clerk ID"),
    SERVER_ID("Server ID"),
    ACCEPT_TIPS("Accept Tips"),
    SEMI_INTEGRATION("Semi-Integration"),
    RETAIL_PULL_MODE("RetailPullMode"),
    RESTAURANT_PUSH_MODE("RestaurantPushMode"),
    ;

    private final String value;

    VhqTerminalFieldsEnum(String value) {
        this.value = value;
    }

    // Use the helper method from EnumUtils
    public static VhqTerminalFieldsEnum fromValue(String s) {
        return EnumUtils.fromValue(VhqTerminalFieldsEnum.class, s);
    }
}
