package com.adminservice.adminService;


import com.adminservice.adminService.entity.UserEntity;
import com.adminservice.adminService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repo.findByUserName(username);
        if(userEntity==null){
            throw  new UsernameNotFoundException("User 404");
        }

        return new UserPrinciples(userEntity);
    }
}
