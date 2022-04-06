package com.mavericsystems.gatewayservice.repo;

import com.mavericsystems.gatewayservice.model.JWTRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorisationRepo extends JpaRepository<JWTRequest,Integer> {

    JWTRequest findByEmail(String email);
}
