package com.tts.dealership.car.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tts.dealership.car.models.Dealer;

public interface DealerRepository extends CrudRepository<Dealer, Long>
{

}
