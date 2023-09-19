package com.ijona.Mobile.service;

import com.ijona.Mobile.DTO.MobileDTO;
import com.ijona.Mobile.exception.MobileNotFoundException;

import java.util.List;

public interface MobileService {

    MobileDTO createMobile(MobileDTO mobileDTO);
    MobileDTO getMobileById(final Long id)throws MobileNotFoundException;
    MobileDTO updateMobileById(Long id , MobileDTO mobileDTO);
    List<MobileDTO> getAllMobile() throws MobileNotFoundException;
    List<MobileDTO> getAllMobileByCompanyName(String companyName)throws MobileNotFoundException;
    List<MobileDTO> getAllMobileByRam(String ram) throws MobileNotFoundException;
    List<MobileDTO> getAllMobileByStorage(String storage)throws MobileNotFoundException;
    MobileDTO deleteMobile(final Long id);
}
