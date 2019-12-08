package com.project.hirecar.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface CarStream {

    String input = "cars_in";
    String output = "cars_out";

    @Input(input)
    SubscribableChannel inboundCars();

    @Output(output)
    MessageChannel outboundCars();

}
