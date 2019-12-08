package com.project.hirecar.stream;

import com.project.hirecar.stream.dto.CarStreamDto;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@CommonsLog
public class CarStreamService {

    private CarStream carStream;

    @Autowired
    public CarStreamService(CarStream carStream) {
        this.carStream = carStream;
    }

    public void publishCar(CarStreamDto carStreamDto) {
        log.info("Sending car " + carStreamDto);

        MessageChannel messageChannel = carStream.outboundCars();
        if(!messageChannel.send(MessageBuilder
                .withPayload(carStreamDto)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .build())) {
            log.info("Fail to publish car.");
            return;
        }
        log.info("Car published succesfully into topic : " + carStream.outboundCars().toString());
    }
}