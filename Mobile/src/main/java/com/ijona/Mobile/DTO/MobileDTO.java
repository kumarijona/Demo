package com.ijona.Mobile.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileDTO {

    private String companyName;
    private String camera;
    private String ram;
    private String storage;
    private boolean activeMobile;
}
