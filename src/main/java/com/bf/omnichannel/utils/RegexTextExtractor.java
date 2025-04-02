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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTextExtractor {
    private RegexTextExtractor() {
        throw new IllegalStateException("Utility class");
    }

    public static String get(String text, String regexPattern) {
        Pattern compiledPattern = Pattern.compile(regexPattern);
        Matcher matcher = compiledPattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1); // or matcher.group(n) if multiple groups are required
        } else {
            return "";
        }
    }
}
