package com.project.hirecar.mapper;

import com.project.hirecar.model.Car;
import com.project.hirecar.stream.dto.CarStreamDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = CarMapperTest.SpringTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CarMapperTest {

    @Configuration
    @ComponentScan(basePackageClasses = CarMapperTest.class)
    public static class SpringTestConfig {
    }

    @Autowired
    private CarMapper carMapper;

    @Test
    public void toCarStreamDto() {
        // Given
        Car car = new Car();
        car.setColor("rouge");
        car.setName("Kia");

        CarStreamDto carStreamDto = carMapper.toCarStreamDto(car);

        assertNotNull(carStreamDto);
    }
}