package com.weTraveller.repository;

import com.weTraveller.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pratik.mondal on 7/7/2021.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
}
