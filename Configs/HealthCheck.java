package com.perfectsolution.Clinique.Configs;

import org.springframework.stereotype.*;
import org.springframework.boot.actuate.health.*;

@Component
public class HealthCheck implements HealthIndicator
{
    public Health health() {
        final int errorCode = this.check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", (Object)errorCode).build();
        }
        return Health.up().build();
    }
    
    public int check() {
        final int resultat = 0;
        return resultat;
    }
}
