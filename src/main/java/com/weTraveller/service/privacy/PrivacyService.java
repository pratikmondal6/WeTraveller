package com.weTraveller.service.privacy;

import com.weTraveller.entity.Privacy;
import com.weTraveller.service.AbstractService;

import java.util.List;

/**
 * Created by pratik.mondal on 7/7/2021.
 */
public interface PrivacyService extends AbstractService<Privacy> {

    public List<Privacy> findAll();
}
