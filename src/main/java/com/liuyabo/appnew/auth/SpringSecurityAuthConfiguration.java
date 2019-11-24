package com.liuyabo.appnew.auth;

import com.liuyabo.appnew.defaultImpl.DefaultLogoutHandler;
import com.liuyabo.appnew.defaultImpl.DefaultSsoHeartbeatHandler;
import com.liuyabo.appnew.spi.SsoHeartbeatHandler;
import com.liuyabo.appnew.spi.UserInfoHolder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityAuthConfiguration {

    @Bean
    @ConditionalOnMissingBean(SsoHeartbeatHandler.class)
    public SsoHeartbeatHandler defaultSsoHeartbeatHandler() {
        return new DefaultSsoHeartbeatHandler();
    }

    @Bean
    @ConditionalOnMissingBean(UserInfoHolder.class)
    public UserInfoHolder springSecurityUserInfoHolder() {
        return new SpringSecurityUserInfoHolder();
    }

    @Bean
    @ConditionalOnMissingBean(LogoutHandler.class)
    public LogoutHandler logoutHandler() {
        return new DefaultLogoutHandler();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(AuthenticationManagerBuilder auth,
                                                         DataSource datasource) throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).dataSource(datasource)
                .usersByUsernameQuery("select Username,Password,Enabled from `Users` where Username = ?")
                .authoritiesByUsernameQuery(
                        "select Username,Authority from `Authorities` where Username = ?")
                .getUserDetailsService();

        jdbcUserDetailsManager.setUserExistsSql("select Username from `Users` where Username = ?");
        jdbcUserDetailsManager
                .setCreateUserSql("insert into `Users` (Username, Password, Enabled) values (?,?,?)");
        jdbcUserDetailsManager
                .setUpdateUserSql("update `Users` set Password = ?, Enabled = ? where id = (select u.id from (select id from `Users` where Username = ?) as u)");
        jdbcUserDetailsManager.setDeleteUserSql("delete from `Users` where id = (select u.id from (select id from `Users` where Username = ?) as u)");
        jdbcUserDetailsManager
                .setCreateAuthoritySql("insert into `Authorities` (Username, Authority) values (?,?)");
        jdbcUserDetailsManager
                .setDeleteUserAuthoritiesSql("delete from `Authorities` where id = (select u.id from (select id from `Users` where Username = ?) as u)");
        jdbcUserDetailsManager
                .setChangePasswordSql("update `Users` set Password = ? where id = (select u.id from (select id from `Users` where Username = ?) as u)");

        return jdbcUserDetailsManager;
    }

    @Bean
    @ConditionalOnMissingBean(UserService.class)
    public UserService springSecurityUserService() {
        return new SpringSecurityUserService();
    }
}
