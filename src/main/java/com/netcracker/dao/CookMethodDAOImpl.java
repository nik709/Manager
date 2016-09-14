package com.netcracker.dao;

import com.netcracker.domain.CookMethod;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 06.09.2016.
 */
@Repository
public class CookMethodDAOImpl extends BaseDAOImpl<CookMethod> implements CookMethodDAO {

    public CookMethodDAOImpl(){
        super(CookMethod.class);
    }
}
