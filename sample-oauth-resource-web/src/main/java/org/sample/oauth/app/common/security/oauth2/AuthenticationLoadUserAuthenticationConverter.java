package org.sample.oauth.app.common.security.oauth2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

public class AuthenticationLoadUserAuthenticationConverter extends DefaultUserAuthenticationConverter{

	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		if(map.containsKey("authentication")){
			Map<String, ?> authentication = (Map<String, ?>) map.get("authentication");
			Set<GrantedAuthority> authorities = ((List<Map<String, String>>)authentication.get("authorities"))
					.stream()
					.map(m -> m.get("authority"))
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toSet());
			User user = new User((String)authentication.get("username"),
						"N/A",
						(boolean)authentication.get("enabled"),
						(boolean)authentication.get("accountNonExpired"),
						(boolean)authentication.get("credentialsNonExpired"),
						(boolean)authentication.get("accountNonLocked"),
						authorities);
			return new UsernamePasswordAuthenticationToken(user, "N/A", authorities);
		}
		return super.extractAuthentication(map);
	}

}
