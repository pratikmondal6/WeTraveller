package com.weTraveller.service.location;

import com.weTraveller.entity.Location;
import com.weTraveller.service.AbstractService;

import java.util.List;

/**
 * Created by pratik.mondal on 7/7/2021.
 */
public interface LocationService extends AbstractService<Location> {

    public List<Location> findAll();
}
