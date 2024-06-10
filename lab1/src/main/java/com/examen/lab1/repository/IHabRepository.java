package com.examen.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.lab1.model.Habitacion;

@Repository
public interface IHabRepository extends JpaRepository<Habitacion, Integer> {
}
