package com.project.hirecar.stream;

import com.project.hirecar.stream.dto.CarStreamDto;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class CarListener {

    @StreamListener(CarStream.input)
    public void handleCar(@Payload CarStreamDto carStreamDto) {
        log.info("Received car " + carStreamDto);
    }
}
