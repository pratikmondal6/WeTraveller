package com.weTraveller.service;


import com.weTraveller.exception.ServiceException;

public interface AbstractService<T> {
    public T create(T t) throws ServiceException;
    public T update(long id, T t) throws ServiceException;
    public boolean delete(long id) throws ServiceException;
    public T findById(long id);
}
