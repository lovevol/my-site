package com.lovevol.mysite.serviceImp;

import com.lovevol.mysite.service.ProfileTestService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class ProfileDevServiceImp implements ProfileTestService {
    @Override
    public String testProfile() {
        return "dev";
    }
}
