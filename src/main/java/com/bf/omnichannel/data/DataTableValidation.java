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
package com.bf.omnichannel.data;

import com.bf.omnichannel.enums.salesforce.SfTerminalFieldsEnum;
import com.bf.omnichannel.enums.vhq.VhqTerminalFieldsEnum;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DataTableValidation {

    private static final List<String> EXPECTED_COLUMN_NAMES =
            Stream.concat(
                            Arrays.stream(SfTerminalFieldsEnum.values())
                                    .map(SfTerminalFieldsEnum::getValue),
                            Arrays.stream(VhqTerminalFieldsEnum.values())
                                    .map(VhqTerminalFieldsEnum::getValue))
                    .toList();

    private DataTableValidation() {
        // Prevent instantiation
    }

    public static void validateRowNames(List<String> actualColumnNames) {
        List<String> newList =
                actualColumnNames.subList(
                        1, actualColumnNames.size()); // Remove the first column name

        // Check if all actual column names are expected
        for (String columnName : newList) {
            if (!EXPECTED_COLUMN_NAMES.contains(columnName)) {
                throw new AssertionError(
                        "Unexpected column name found: '%s'".formatted(columnName));
            }
        }
    }
}
