package com.liuyabo.appnew.auth;

import com.liuyabo.appnew.entity.Boss;
import com.liuyabo.appnew.entity.UserInfo;
import com.liuyabo.appnew.repository.BossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class SpringSecurityUserService implements UserService{

    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    private List<GrantedAuthority> authorities;

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;
    @Autowired
    private BossRepository bossRepository;
    public void init() {

        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_user"));
    }

    @Transactional
    public void createOrUpdate(User user) {
        String username = user.getUsername();

        User userDetails = new User(username, encoder.encode(user.getPassword()), authorities);

        if (userDetailsManager.userExists(username))
            userDetailsManager.updateUser(userDetails);
        else
            userDetailsManager.createUser(userDetails);

    }
    @Override
    public UserInfo findUserById(int id) {
        Boss boss = bossRepository.findById(id);
        return boss != null ? boss.toUserInfo() : null;
    }
}
