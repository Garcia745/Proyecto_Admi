package com.unieventos.proyecto.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinayConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwxsauisd",
                "api_key", "329415721582168",
                "api_secret", "TNpB2gLSfLO9cVf-QQp-MLycV5M",
                "secure", true
        ));
    }
}
