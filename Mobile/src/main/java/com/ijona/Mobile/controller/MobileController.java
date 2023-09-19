package com.ijona.Mobile.controller;

import com.ijona.Mobile.DTO.MobileDTO;
import com.ijona.Mobile.DTO.ResponseDTO;
import com.ijona.Mobile.exception.MobileNotFoundException;
import com.ijona.Mobile.model.Mobile;
import com.ijona.Mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {
    private MobileService mobileService;

    @Autowired
    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;

    }
    @PostMapping("/createMobile")
    ResponseEntity<ResponseDTO> createMobileController(@RequestBody MobileDTO mobileDTO)throws MobileNotFoundException {

     MobileDTO saveMobileDTO = mobileService.createMobile(mobileDTO);
     return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),saveMobileDTO,null, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseDTO> getMobileByIdController(@PathVariable final Long id) throws MobileNotFoundException{
        MobileDTO mobileDTO = mobileService.getMobileById(id);
        return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTO,null,HttpStatus.FOUND));
    }

    @GetMapping("/allMobile")
    ResponseEntity<ResponseDTO> getAllMobileController()throws MobileNotFoundException{
        List<MobileDTO> mobileDTOList = mobileService.getAllMobile();
        return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTOList,null,HttpStatus.FOUND));
    }
    @GetMapping("/byCompany/{companyName}")
    ResponseEntity<ResponseDTO> getAllByCompanyNameController(@PathVariable String companyName)throws MobileNotFoundException{
        List<MobileDTO> mobileDTOList = mobileService.getAllMobileByCompanyName(companyName);
        return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTOList,null,HttpStatus.FOUND));
    }

    @GetMapping("/byRam/{ram}")
    ResponseEntity<ResponseDTO> getAllMobileByRamController(@PathVariable String ram)throws MobileNotFoundException{
        List<MobileDTO> mobileDTOList = mobileService.getAllMobileByRam(ram);
        return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTOList,null,HttpStatus.FOUND));
    }

    @GetMapping("/storage/{storage}")

    ResponseEntity<ResponseDTO> getAllMobileByStorage(@PathVariable String storage)throws MobileNotFoundException {

       List<MobileDTO> mobileDTOList =  mobileService.getAllMobileByStorage(storage);
       return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTOList,null,HttpStatus.FOUND));

    }

































    @PutMapping("/{id}")
    ResponseEntity<ResponseDTO> updateMobileById(@PathVariable final Long id ,
                                                 @RequestBody final MobileDTO mobileDTO)
                                                 throws MobileNotFoundException{
        MobileDTO saveMobileDTO = mobileService.updateMobileById(id,mobileDTO);
        return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTO,null,HttpStatus.CREATED));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDTO> deleteMobileController(@PathVariable final Long id)throws MobileNotFoundException{
        MobileDTO mobileDTO = mobileService.deleteMobile(id);
        return ResponseEntity.ok(new ResponseDTO(LocalTime.now(),mobileDTO,null,HttpStatus.FOUND));
    }
}
