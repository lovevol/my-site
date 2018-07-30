package com.lovevol.mysite.serviceImp;

import com.lovevol.mysite.service.ProfileTestService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class ProfileProdServiceImp implements ProfileTestService {
    @Override
    public String testProfile() {
        return "prod";
    }
}
