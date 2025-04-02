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

import com.bf.omnichannel.enums.salesforce.SfYesOrNoEnum;
import com.bf.omnichannel.enums.vhq.VhqEnabledOrDisabledEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class YesNoEnabledDisabledPojo {
    private SfYesOrNoEnum sFYesOrNoEnum;
    private VhqEnabledOrDisabledEnum vhqEnabledOrDisabledEnum;
}
