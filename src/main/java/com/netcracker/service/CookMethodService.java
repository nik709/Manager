package com.netcracker.service;

import com.netcracker.domain.CookMethod;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
public interface CookMethodService {

    public void add(CookMethod cuisine);

    public List<CookMethod> list();

    public void remove(Integer id);

    public CookMethod findById(Integer id);
}
