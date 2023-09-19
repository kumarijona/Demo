package com.ijona.Mobile.repository;

import com.ijona.Mobile.exception.MobileNotFoundException;
import com.ijona.Mobile.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile , Long> {

    List<Mobile> findAllMobileByCompanyName(String companyName)throws MobileNotFoundException;
    List<Mobile> findAllMobileByRam(String ram)throws MobileNotFoundException;
    List<Mobile> findAllMobileByStorage(String storage) throws MobileNotFoundException;


}
