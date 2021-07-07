package com.weTraveller.service.privacy;

import com.weTraveller.entity.Privacy;
import com.weTraveller.exception.ServiceException;
import com.weTraveller.repository.PrivacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pratik.mondal on 7/7/2021.
 */
@Service
public class PrivacyServiceImp implements PrivacyService{


    @Autowired
    PrivacyRepository privacyRepository;


    @Autowired
    private Environment env;

    @Override
    public List<Privacy> findAll() {
        return privacyRepository.findAll();
    }

    @Override
    public Privacy create(Privacy privacy) throws ServiceException {
        return null;
    }

    @Override
    public Privacy update(long id, Privacy privacy) throws ServiceException {
        return null;
    }

    @Override
    public boolean delete(long id) throws ServiceException {
        return false;
    }

    @Override
    public Privacy findById(long id) {
        return null;
    }
}
