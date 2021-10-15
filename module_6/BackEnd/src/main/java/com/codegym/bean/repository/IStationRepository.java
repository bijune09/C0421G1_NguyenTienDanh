package com.codegym.bean.repository;

import com.codegym.bean.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStationRepository extends JpaRepository<Station, Long> {
}
