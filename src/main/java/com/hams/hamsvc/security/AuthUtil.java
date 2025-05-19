package com.hams.hamsvc.security;

import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    private final UserRepository userRepository;

    @Autowired
    public AuthUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean isUserAuthenticated() {
        Authentication auth = getAuthentication();
        return auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);
    }

    public String getCurrentUsername() {
        Authentication auth = getAuthentication();
        if (auth != null) {
            return auth.getName();
        }
        throw new UsernameNotFoundException("No authenticated user found");
    }

    public User getCurrentUser() {
        String email = getCurrentUsername();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
}
