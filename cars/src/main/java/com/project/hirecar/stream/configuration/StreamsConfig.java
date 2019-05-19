package com.project.hirecar.stream.configuration;

import com.project.hirecar.stream.CarStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(CarStream.class)
public class StreamsConfig {
}