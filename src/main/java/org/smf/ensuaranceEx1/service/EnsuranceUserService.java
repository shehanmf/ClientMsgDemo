package org.smf.ensuaranceEx1.service;


import org.smf.ensuaranceEx1.entity.UserRole;
import org.smf.ensuaranceEx1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shehan on 11/22/2015.
 */
@Service
@Qualifier("ensuranceUserService")
public class EnsuranceUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        org.smf.ensuaranceEx1.entity.User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);
    }


    private User buildUserForAuthentication(org.smf.ensuaranceEx1.entity.User user,
                                            List<GrantedAuthority> authorities) {


        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();


        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
}
