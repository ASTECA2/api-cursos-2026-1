package app.autenticacao;

import java.security.AlgorithmConstraints;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
    private String tokenKey = "123456789";

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(
            ZoneOffset.of("-03:00"));
    }

    public String generateToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenKey);
            return JWT.create()
                .withIssuer("FATEC API")
                .withSubject(usuario.getNomeDeUsuario())
                .withExpiresAt(this.expirationDate())
                .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar JWT");
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenKey);
            return JWT.require(algorithm)
            .withIssuer("FATEC API")
            .build()
            .verify(token)
            .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token Inválido");
        }

    }

}