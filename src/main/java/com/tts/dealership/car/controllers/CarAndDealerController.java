package com.tts.dealership.car.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.dealership.car.models.Car;
import com.tts.dealership.car.models.Dealer;
import com.tts.dealership.car.repositories.CarRepository;
import com.tts.dealership.car.repositories.DealerRepository;

@RestController
public class CarAndDealerController
{
    @Autowired
    CarRepository carRepository;
    
    @Autowired
    DealerRepository dealerRepository;
    
    @GetMapping("/dealerships/{dealershipId}/cars/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable(value="dealershipId") Long dealershipId, 
                                      @PathVariable(value="carId") Long carId) {
        Optional<Dealer> dealer = dealerRepository.findById(dealershipId);
        if (dealer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Car car = carRepository.findByDealerAndId(dealer.get(), carId);
        if (car == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    
    @GetMapping("/dealerships/{dealershipId}/cars/")
    public ResponseEntity<List<Car>> getCars(@PathVariable(value="dealershipId") Long dealershipId,
                                             @RequestParam(value="color", required=false) String color,
                                             @RequestParam(value="sort", required=false) String sort)
    {
        Optional<Dealer> optDealer = dealerRepository.findById(dealershipId);
        if (optDealer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Dealer dealer = optDealer.get();
        
        List<Car> cars;
        if (color != null && sort != null && sort.equalsIgnoreCase("msrp")){
            cars = carRepository.findAllByDealerAndColorOrderByMsrpDesc(dealer, color);
        }
        else if (color != null){
            cars = carRepository.findAllByDealerAndColor(dealer, color);
        }
        else if (sort != null && sort.equalsIgnoreCase("msrp")){
            cars = carRepository.findAllByDealerOrderByMsrpDesc(dealer);
        }
        else {
            cars = carRepository.findAllByDealer(dealer);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
        
    }
    
}
