/*
   **********************************************************************
   **********************************************************************
   ** By Wuriyanto                                                     **
   ** EMAIL/FACEBOOK : wuriyanto48@yahoo.co.id  OR  Prince Wury        **
   ** WEBSITE : wuriyantoinformatika.blogspot.com                      **
   ** CITY : BANJARNEGARA CENTRAL JAVA INDONESIA                       **
   ** COMPUTER SCIENCE                                                 **
   ** MUHAMMADIYAH UNIVERSITY OF PURWOKERTO                            **
   ** NB:BEBAS DIDISTRIBUSIKAN UNTUK TUJUAN BELAJAR                    **      
   **                                                                  **
   **                                     JMAT.inc & Black Code Studio **
   **********************************************************************
   **********************************************************************

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wury.app.daoimpl;

import com.wury.app.dao.AbstractDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author WURI
 * @param <T>
 */
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {
    
    @Autowired
    protected SessionFactory factory;
    protected Class<T> model;
    
    public AbstractDaoImpl(Class<T> model){
        this.model = model;
    }

    @Override
    public void save(T t) {
        factory.getCurrentSession().save(t);
    }

    @Override
    public void update(T t) {
        factory.getCurrentSession().update(t);
    }

    @Override
    public void delete(T t) {
        factory.getCurrentSession().delete(t);
    }

    @Override
    public T findOne(Object id) {
        return (T) factory.getCurrentSession().get(model, (Serializable) id);
    }

    @Override
    public List<T> findAll() {
        return factory.getCurrentSession().createCriteria(model).list();
    }

}
