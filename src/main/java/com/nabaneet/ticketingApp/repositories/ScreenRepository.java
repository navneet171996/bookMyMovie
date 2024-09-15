package com.nabaneet.ticketingApp.repositories;

import com.nabaneet.ticketingApp.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
