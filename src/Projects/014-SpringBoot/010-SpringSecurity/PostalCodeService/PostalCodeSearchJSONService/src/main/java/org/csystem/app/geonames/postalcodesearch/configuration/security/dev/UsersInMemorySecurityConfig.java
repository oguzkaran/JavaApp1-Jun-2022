package org.csystem.app.geonames.postalcodesearch.configuration.security.dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Profile("dev-security")
public class UsersInMemorySecurityConfig {
    private UserDetails createUser(String username, String password, String...roles)
    {
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        var admin = createUser("deniz", "deniz1234", "ADMIN");
        var user = createUser("mete", "mete12345", "USER", "VIEWER");
        var teamLeader = createUser("nurican", "nuri1234567", "TEAM_LEADER");

        return new InMemoryUserDetailsManager(admin, user, teamLeader);
    }
}
