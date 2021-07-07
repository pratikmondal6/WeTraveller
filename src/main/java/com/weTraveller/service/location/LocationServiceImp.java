package com.weTraveller.service.location;

import com.weTraveller.entity.Location;
import com.weTraveller.exception.ServiceException;
import com.weTraveller.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pratik.mondal on 7/7/2021.
 */

@Service
public class LocationServiceImp implements LocationService {



    @Autowired
    LocationRepository locationRepository;

    @Autowired
    private Environment env;


    @Override
    public List<Location> findAll() {
        return null;
    }

    @Override
    public Location create(Location location) throws ServiceException {
        return null;
    }

    @Override
    public Location update(long id, Location location) throws ServiceException {
        return null;
    }

    @Override
    public boolean delete(long id) throws ServiceException {
        return false;
    }

    @Override
    public Location findById(long id) {
        return null;
    }
}
