//package com.cg.sprint1_onlineplantnursery.service;
//
//import java.util.ArrayList;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
// 
//
//import com.cg.dao.UserRepository;
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
// 
//
//    @Autowired
//    private UserRepository userDao;
//
// 
//
//    @Autowired
//    private PasswordEncoder bcryptEncoder;
//
// 
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//          com.cg.entities.User user =  userDao.findByEmail(username);
//          if(user==null)
//              throw new UsernameNotFoundException("user not found"+username);
//          
//          return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
//          
//    
//    }
//
// 
//
//    public com.cg.entities.User save(com.cg.entities.User user) {
//        com.cg.entities.User newUser = new com.cg.entities.User();
//        newUser.setEmail(user.getEmail());
//        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        return userDao.save(newUser);
//    }
//
// 
//
//}
