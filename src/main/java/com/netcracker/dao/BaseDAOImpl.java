package com.netcracker.dao;

import java.util.List;

import com.netcracker.domain.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAOImpl<Entity> implements BaseDAO<Entity> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<Entity> entityClass;

    public BaseDAOImpl(){}

    protected BaseDAOImpl(Class<Entity> entityClass){
        this.entityClass = entityClass;
    }

    public void add(Entity entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Entity> list() {

        return sessionFactory.getCurrentSession().createQuery("from " + entityClass.getName())
                .list();
    }

    public void remove(Integer id) {

        Object obj;
        obj = sessionFactory.getCurrentSession().load(entityClass, id);
        if (obj != null){
            sessionFactory.getCurrentSession().delete(obj);
        }

    }

    public Entity findById(Integer id){
        String query = "from " + entityClass.getName() + " where id = " + id;
        return (Entity) sessionFactory.getCurrentSession().createQuery(query).list().get(0);
    }
}

