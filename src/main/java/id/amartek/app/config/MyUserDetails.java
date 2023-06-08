package id.amartek.app.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import id.amartek.app.model.User;
import id.amartek.app.repository.UserManagementRepository;

@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    @Autowired
    private UserManagementRepository managementRepository;
    private String username;
    private String password;
    private GrantedAuthority authority;

    public MyUserDetails() {
        super();
    }

    public MyUserDetails(User user) {
        this.username = "ipin@gmail.com";
        this.password = "$2a$10$CKKvFZqxoH/uCzeM50srKeYKjpqgMwom45x4.iYuMLjLtG0dPhPbK";
        this.authority = new SimpleGrantedAuthority("Staff");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = managementRepository.Login("ipin@gmail.com");
        return new MyUserDetails(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(authority);
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
