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
package com.bf.omnichannel.exceptions;

import com.bf.omnichannel.enums.IValuableEnum;

public class UnknownEnumValueException extends IllegalArgumentException {

    public UnknownEnumValueException(Class<? extends Enum<?>> enumClass, String value) {
        StringBuilder error =
                new StringBuilder(
                        "Unknown value: '%s' for enum %s%n"
                                .formatted(value, enumClass.getSimpleName()));

        error.append("Available options for enum %s:".formatted(enumClass.getSimpleName()));
        for (Enum<?> option : enumClass.getEnumConstants()) {
            error.append("'%s', ".formatted(((IValuableEnum) option).getValue()));
        }

        throw new IllegalArgumentException(error.toString());
    }
}
