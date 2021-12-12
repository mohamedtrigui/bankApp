package tn.esps.bankApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esps.bankApp.dao.RoleDao;
import tn.esps.bankApp.dao.UserDao;
import tn.esps.bankApp.entities.Role;
import tn.esps.bankApp.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class UserService implements UserDetailsService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);
        if (user == null) throw new UsernameNotFoundException("User not fount in DB");

        //here we need to return a spring security User so we map our entity User to a Spring Security User (ps: roles -> authorities )
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        User user = userDao.findUserByUsername(username);
        Role role = roleDao.findByName(roleName);
        user.getRoles().add(role);
    }

    public User getUser(String username){
        return userDao.findUserByUsername(username);
    }

    public List<User> getUsers(){
        return userDao.findAll();
    }


}
