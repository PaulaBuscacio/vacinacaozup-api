package com.zup.vacinacaozupapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.vacinacaozupapi.model.Vacinado;

@Repository
public interface VacinadoRepository extends JpaRepository<Vacinado, Long> {

}
