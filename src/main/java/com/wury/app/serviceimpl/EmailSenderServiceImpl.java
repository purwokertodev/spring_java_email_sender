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

import com.wury.app.service.EmailSenderService;
import com.wury.app.model.EmailSenderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author WURI
 */
@Service("emailSenderService")
public class EmailSenderServiceImpl implements EmailSenderService{
    
    @Autowired
    private MailSender mailSender;

    @Override
    public boolean sendEmail(EmailSenderModel e) {
        boolean res;
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(e.getAlamatEmailTujuan());
        mail.setSubject(e.getSubject());
        mail.setText(e.getMessageBody());
        try{
            mailSender.send(mail);
            res = true;
        }catch(MailException ex){
            res = false;
            System.out.println(ex.getMessage());
        }
        return res;
    }

}
