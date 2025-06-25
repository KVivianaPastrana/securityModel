package com.security.demo.jwt;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
        //Se obtiene el token 
        final String token = getTokenFromRequest(request);
        //verifica el token
        if(token == null){
         filterChain.doFilter(request,response);
         return;
        }
        //Se deja que el token siga su camino
        filterChain.doFilter(request,response);

}

//este metodo extrae el token JWT del encabezado HTTP
private String getTokenFromRequest(HttpServletRequest request) {

    //Obtenemos el token de la cabecera HTTP
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
 
//se valida si tiene texto  y empieza con "Bearer"
if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){

//se extrae el token
return authHeader.substring(7);
}
return null;

}

}