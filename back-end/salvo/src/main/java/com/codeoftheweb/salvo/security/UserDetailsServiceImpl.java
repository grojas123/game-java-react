package com.codeoftheweb.salvo.security;

import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Player player = playerRepository.findByEmail(username);

        if (player == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(player);
    }
}
