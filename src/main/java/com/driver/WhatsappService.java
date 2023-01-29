package com.driver;

import org.springframework.stereotype.Service;

@Service
public class WhatsappService {

    WhatsappRepository whatsappRepository = new WhatsappRepository();

    public String createUser(String name, String number) throws Exception
    {
       return whatsappRepository.saveUser(name,number);
    }

}
