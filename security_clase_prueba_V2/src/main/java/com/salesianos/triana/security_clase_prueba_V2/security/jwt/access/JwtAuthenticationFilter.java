package com.salesianos.triana.security_clase_prueba_V2.security.jwt.access;

import com.salesianos.triana.security_clase_prueba_V2.user.model.User;
import com.salesianos.triana.security_clase_prueba_V2.user.repository.UserRepository;
import com.salesianos.triana.security_clase_prueba_V2.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //private final UserService userService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtAccessTokenFromRequest(request);

        // Validar el token
        // Si es válido, autenticar al usuario

        if (StringUtils.hasText(token) && jwtService.validateAccessToken(token)) {

            // Obtener el sub del token, que es el ID del usuario
            // Buscar el usuario por id
            // Colocar el usuario autenticado en el contexto de seguridad

            UUID id = jwtService.getUserIdFromAccessToken(token);

            Optional<User> result = userRepository.findById(id);

            if (result.isPresent()) {
                User user = result.get();
                UsernamePasswordAuthenticationToken
                        authenticationToken = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        user.getAuthorities()
                );

                authenticationToken.setDetails(new WebAuthenticationDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }

        }

        filterChain.doFilter(request, response);

    }

    private String getJwtAccessTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(JwtService.TOKEN_HEADER);
        // Bearer asfkñaldsjfslk.asñklfdjadlsñfajs.asñkjdfaksdñlfjal
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtService.TOKEN_PREFIX)) {
            return bearerToken.substring(JwtService.TOKEN_PREFIX.length());
        }

        return null;
    }
}