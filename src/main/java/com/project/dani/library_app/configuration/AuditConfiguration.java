package com.project.dani.library_app.configuration;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuditConfiguration implements AuditorAware<String>{

    @SuppressWarnings("null")
    @Override
    public Optional<String> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            
            if (authentication == null || !authentication.isAuthenticated()) {
                return Optional.empty();
            }

            User user = (User) authentication.getPrincipal();

            return Optional.of(user.getUsername());
        }

    }



