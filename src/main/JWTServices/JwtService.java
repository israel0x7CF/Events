import java.util.HashMap;
import java.util.function.Function;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtService {
    @Value("jwt.secret")
    private String jwtSecret;

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(userName, claims);
    }

    private String createToken(String userName, Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
                
    }
    private byte [] getSignKey(){
        byte [] secretKeyByte = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(secretKeyByte);
    }
    public String extractUsername(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }
    public <T> T extractClaim(String token,Function<Claims,T> claimsResolver){
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token){
        return Jwts
        .parserBuilder()
        .setSigningKey(getSignKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }
    private Boolean isTokenExipred(String Token){
        return extractExpirationDate(Token).before(new Date());

    }
    public Boolean validateToken(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExipred(token);
    }

}
