package com.tts.dealership.car.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.tts.dealership.car.models.Car;
import com.tts.dealership.car.models.Dealer;

public interface CarRepository extends CrudRepository<Car, Long>
{

    Car findByDealerAndId(Dealer dealer, Long carId);
    
    List<Car> findAllByDealer(Dealer dealer);
   
    List<Car> findAllByDealerOrderByMsrpDesc(Dealer dealer);
    
    List<Car> findAllByDealerAndColor(Dealer dealer, String color);
    
    List<Car> findAllByDealerAndColorOrderByMsrpDesc(Dealer dealer, String color);
}
