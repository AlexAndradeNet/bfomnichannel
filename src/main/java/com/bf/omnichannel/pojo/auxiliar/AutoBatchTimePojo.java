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
package com.bf.omnichannel.pojo.auxiliar;

import com.bf.omnichannel.utils.TimeValidatorUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@NoArgsConstructor
public class AutoBatchTimePojo {
    private String sFAutoBatchTime;
    private String vhqAutoBatchTime;

    public void setSFAutoBatchTime(String autoBatchTime) {
        this.sFAutoBatchTime = validateTime(autoBatchTime);
    }

    public void setVhqAutoBatchTime(String autoBatchTime) {
        this.vhqAutoBatchTime = validateTime(autoBatchTime);
    }

    private String validateTime(String autoBatchTime) {

        if (StringUtils.isEmpty(autoBatchTime)) {
            autoBatchTime = "";
        }

        if (!TimeValidatorUtil.isValid(autoBatchTime)) {
            throw new IllegalArgumentException(
                    "Invalid time format for '"
                            + autoBatchTime
                            + "'. Expected format is 'hh:mm' and the time must be in increments of"
                            + " 15 minutes between 00:00 and 23:45.");
        }
        return autoBatchTime.trim();
    }
}
