package com.salesianos.triana.security_clase_prueba_V2.security.jwt.refresh;

import com.salesianos.triana.security_clase_prueba_V2.security.errorhandling.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {

    public RefreshTokenException(String msg) {
        super(msg);
    }

}
