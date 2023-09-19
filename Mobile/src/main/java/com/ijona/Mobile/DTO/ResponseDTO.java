package com.ijona.Mobile.DTO;

import com.ijona.Mobile.exception.MobileNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private LocalTime localTime;

    private Object data;

    private String error;

    private HttpStatus httpStatus;

}
