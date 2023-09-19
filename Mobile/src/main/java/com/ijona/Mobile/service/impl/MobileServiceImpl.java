package com.ijona.Mobile.service.impl;

import com.ijona.Mobile.DTO.MobileDTO;
import com.ijona.Mobile.exception.MobileNotFoundException;
import com.ijona.Mobile.model.Mobile;
import com.ijona.Mobile.repository.MobileRepository;
import com.ijona.Mobile.service.MobileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public MobileServiceImpl(MobileRepository mobileRepository, ModelMapper modelMapper) {
        this.mobileRepository = mobileRepository;
        this.modelMapper = modelMapper;
    }

    public MobileDTO createMobile(MobileDTO mobileDTO){
        Mobile mobile = modelMapper.map(mobileDTO,Mobile.class);
        Mobile saveMobile = mobileRepository.save(mobile);
        return modelMapper.map(saveMobile , MobileDTO.class);
    }
    @Override
    public MobileDTO getMobileById(Long id) throws MobileNotFoundException {
        Optional<Mobile> mobileOptional = mobileRepository.findById(id);
        if(mobileOptional.isEmpty()){
            throw new MobileNotFoundException("Mobile detail is not found with id: " + id);
        }else{
            return modelMapper.map(mobileOptional.get(),MobileDTO.class);
        }
    }

    @Override
    public List<MobileDTO> getAllMobile() throws MobileNotFoundException {
        List<Mobile> mobileList = mobileRepository.findAll();
        if(mobileList.isEmpty()){
            throw new MobileNotFoundException("Mobile is empty:");
        }else{ List<MobileDTO> mobileDTOList = mobileList.stream()
                .map(mobile -> modelMapper.map(mobile, MobileDTO.class))
                .collect(Collectors.toList());
            return mobileDTOList;}
      }
    @Override
    public List<MobileDTO> getAllMobileByCompanyName(String companyName) throws MobileNotFoundException {
        List<Mobile> mobileList = mobileRepository.findAllMobileByCompanyName(companyName);
        if(mobileList.isEmpty()){
            throw new MobileNotFoundException("Mobile is empty:");
        }else{
            List<MobileDTO> mobileDTOList = mobileList.stream()
                .map(mobile -> modelMapper.map(mobile, MobileDTO.class))
                .collect(Collectors.toList());
            return mobileDTOList;
        }
    }
    @Override
    public List<MobileDTO> getAllMobileByRam(String ram) throws MobileNotFoundException {
        List<Mobile> mobileList = mobileRepository.findAllMobileByRam(ram);
        if (mobileList.isEmpty()){
            throw new MobileNotFoundException("Mobile not found by ram : " + ram);
        }else{
            List<MobileDTO> mobileDTOList = mobileList.stream()
                    .map(mobile -> modelMapper.map(mobile, MobileDTO.class))
                    .collect(Collectors.toList());
            return mobileDTOList;
        }
    }

    @Override
    public List<MobileDTO> getAllMobileByStorage(String storage) throws MobileNotFoundException {

        List<Mobile> mobileList = mobileRepository.findAllMobileByStorage(storage);
        if(mobileList.isEmpty()){
            throw new MobileNotFoundException("Mobile not found by storage : " + storage);
        }else{
            List<MobileDTO> mobileDTOList = mobileList.stream()
                    .map(mobile -> modelMapper.map(mobile, MobileDTO.class))
                    .collect(Collectors.toList());
            return mobileDTOList ;
        }
    }

    @Override
    public MobileDTO updateMobileById(Long id, MobileDTO mobileDTO)throws MobileNotFoundException {
        Optional<Mobile> mobileOptional = mobileRepository.findById(id);
        if (mobileOptional.isEmpty()){
            throw new MobileNotFoundException("Mobile detail is not present at id: " +id);
        }else{
            Mobile mobile = modelMapper.map(mobileDTO,Mobile.class);
            mobile.setId(id);
            Mobile saveMobile = mobileRepository.save(mobile);
            return modelMapper.map(saveMobile,MobileDTO.class);
        }
    }
    @Override
    public MobileDTO deleteMobile(Long id) {
        if(mobileRepository.findById(id).isEmpty()){
            throw new MobileNotFoundException("No Mobile is found in ID: "+id);
        }else{
            mobileRepository.deleteById(id);
        }
        return null;
    }
}
