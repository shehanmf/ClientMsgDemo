package org.smf.ensuaranceEx1.service;

import org.smf.ensuaranceEx1.entity.User;
import org.smf.ensuaranceEx1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shehan on 11/22/2015.
 */
@Service
public class StartUpDataService {

    @Autowired
    private UserRepository userRepository;

    public void initiateStartUpData()
    {
        User user = userRepository.findByUsername("Shehan");
        if(user == null)
        {
            user = User.createUser("Shehan","shehan_mf@yahoo.com","Logos321");
//
            userRepository.save(user);
        }
//
        System.out.println(user.getUsername() +"   " +  user.getEmail());

    }
}
