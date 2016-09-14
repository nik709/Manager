package com.netcracker.dao;

import java.util.List;

import com.netcracker.domain.Contact;

public interface BaseDAO<Entity> {

	public void add(Entity entity);

	public List<Entity> list();

	public void remove(Integer id);

	public Entity findById(Integer id);
}