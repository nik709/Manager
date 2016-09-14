package com.netcracker.service;

import com.netcracker.domain.Composition;

import java.util.List;

/**
 * Created by Никита on 04.09.2016.
 */
public interface CompositionService {

    public void add(Composition composition);

    public List<Composition> list();

    public void remove(Integer id);
}
