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
package com.wury.app.util;

import com.wury.app.service.EmailSenderModelService;
import com.wury.app.service.EmailSenderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author WURI
 */
public class SpringUtil {

    private static final ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
//new ClassPathXmlApplicationContext("spring-config.xml");

    private static EmailSenderService emailSenderService;
    private static EmailSenderModelService emailSenderModelService;

    public static EmailSenderService getEmailSenderService() {
        if (emailSenderService == null) {
            emailSenderService = (EmailSenderService) context.getBean("emailSenderService");
        }
        return emailSenderService;
    }

    public static EmailSenderModelService getEmailSenderModelService() {
        if(emailSenderModelService == null){
            emailSenderModelService = (EmailSenderModelService) context.getBean("emailSenderModelService");
        }
        return emailSenderModelService;
    }

}
