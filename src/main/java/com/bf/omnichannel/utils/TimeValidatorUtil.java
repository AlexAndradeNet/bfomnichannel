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
package com.bf.omnichannel.utils;

import org.apache.commons.lang3.StringUtils;

public class TimeValidatorUtil {

    private TimeValidatorUtil() {
        // private constructor to prevent instantiation
    }

    public static boolean isValid(String time) {
        if (StringUtils.isEmpty(time)) {
            return true;
        }
        String regex = "^[0-2]\\d:[0-2][05]$";
        return time.trim().matches(regex);
    }
}
