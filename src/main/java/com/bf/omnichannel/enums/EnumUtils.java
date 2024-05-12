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

import java.util.Arrays;

public class EnumUtils {

    private EnumUtils() {
        throw new UnsupportedOperationException("utility class");
    }

    public static <E extends Enum<E> & IValuableEnum> E fromValue(
            Class<E> enumClass, String value) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "Unknown value: '"
                                                + value
                                                + "' for enum "
                                                + enumClass.getName()));
    }
}
