package com.example.demo.component;

import com.example.demo.entity.Courier;
import com.example.demo.entity.DeliveryTime;
import com.example.demo.entity.District;
import com.example.demo.repo.CourierRepository;
import com.example.demo.repo.DeliveryTimeRepository;
import com.example.demo.repo.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Runer implements CommandLineRunner {

    private final DeliveryTimeRepository deliveryTimeRepository;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
    private final DistrictRepository districtRepository;
    private final CourierRepository courierRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ddl.equals("create")) {
            deliveryTimeRepository.saveAll(List.of(
                    new DeliveryTime(1, LocalTime.of(9, 0), LocalTime.of(12, 0)),
                    new DeliveryTime(2, LocalTime.of(13, 0), LocalTime.of(18, 0)),
                    new DeliveryTime(3, LocalTime.of(18, 0), LocalTime.of(23, 59))
            ));
            districtRepository.saveAll(
                    List.of(
                            new District(null, "Shayxontohur"),
                            new District(null, "Olmazor"),
                            new District(null, "Yunusobod"),
                            new District(null, "Mirobod"),
                            new District(null, "Chilonzor"),
                            new District(null, "Yashnobod"),
                            new District(null, "Mirzo ulugbek")
                    )
            );
            courierRepository.saveAll(List.of(
                    new Courier(null,"Eshmat","Damas","177"),
                    new Courier(null,"Toshmat","Labo","717"),
                    new Courier(null,"Hikmat","Zil","223")
            ));
        }

    }
}
