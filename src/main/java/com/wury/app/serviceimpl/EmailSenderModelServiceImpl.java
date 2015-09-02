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

package com.wury.app.serviceimpl;

import com.wury.app.dao.EmailSenderModelDao;
import com.wury.app.model.EmailSenderModel;
import com.wury.app.service.EmailSenderModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author WURI
 */
@Transactional(readOnly = false)
@Service("emailSenderModelService")
public class EmailSenderModelServiceImpl implements EmailSenderModelService{
    
    @Autowired
    private EmailSenderModelDao emailSenderModelDao;

    @Override
    public void save(EmailSenderModel e) {
        emailSenderModelDao.save(e);
    }

    @Override
    public void update(EmailSenderModel e) {
        emailSenderModelDao.update(e);
    }

    @Override
    public void delete(int id) {
        EmailSenderModel e = findOne(id);
        emailSenderModelDao.delete(e);
    }

    @Transactional(readOnly = true)
    @Override
    public EmailSenderModel findOne(int id) {
        return emailSenderModelDao.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmailSenderModel> findAll() {
        return emailSenderModelDao.findAll();
    }

}
