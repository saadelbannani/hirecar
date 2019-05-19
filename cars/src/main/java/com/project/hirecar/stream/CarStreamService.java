package com.project.hirecar.stream;

import com.project.hirecar.model.Brand;
import com.project.hirecar.model.Car;
import com.project.hirecar.stream.dto.BrandStreamDto;
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

    public void sendCar(CarStreamDto carStreamDto) {
        log.info("Sending car " + carStreamDto);

        MessageChannel messageChannel = carStream.outboundCars();
        messageChannel.send(MessageBuilder
                .withPayload(carStreamDto)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .build());
    }

    public CarStreamDto toCarStreamDto(Car car) {
        CarStreamDto carStreamDto = new CarStreamDto();
        carStreamDto.setId(car.getId());
        carStreamDto.setName(car.getName());
        carStreamDto.setColor(car.getColor());
        carStreamDto.setImmatriculation(car.getImmatriculation());
        carStreamDto.setUuid(car.getUuid().toString());
        carStreamDto.setYear(car.getYear());
        carStreamDto.setBrand(toBrandStreamDto(car.getBrand()));

        return carStreamDto;
    }

    private BrandStreamDto toBrandStreamDto(Brand brand) {
        BrandStreamDto brandStreamDto = new BrandStreamDto();
        brandStreamDto.setId(brand.getId());
        brandStreamDto.setName(brand.getName());
        brandStreamDto.setUuid(brand.getUuid().toString());

        return brandStreamDto;
    }
}
