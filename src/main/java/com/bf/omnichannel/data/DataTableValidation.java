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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataTableValidation {

    private static final Set<String> EXPECTED_COLUMN_NAMES =
            Stream.concat(
                            Stream.of(SfTerminalFieldsEnum.values())
                                    .map(SfTerminalFieldsEnum::getValue),
                            Stream.of(VhqTerminalFieldsEnum.values())
                                    .map(VhqTerminalFieldsEnum::getValue))
                    .collect(Collectors.toSet());

    private DataTableValidation() {
        // Prevent instantiation
    }

    public static void validateRowNames(List<String> actualColumnNames) {
        List<String> newList =
                actualColumnNames.subList(
                        1, actualColumnNames.size()); // Remove the first column name

        for (String columnName : newList) {
            if (!EXPECTED_COLUMN_NAMES.contains(columnName)) {
                throw new AssertionError(
                        String.format("Unexpected column name found: '%s'", columnName));
            }
        }
    }
}
