package proj.rest.se331.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.headers((headers) -> {
      headers.frameOptions((frameOptions) -> frameOptions.disable());
    });
    http
            .csrf((crsf) -> crsf.disable())
            .authorizeHttpRequests((authorize) -> {
                authorize.requestMatchers("api/v1/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"student/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST,"/students").hasAnyRole("STUDENT","ADMIN")
                        .requestMatchers(HttpMethod.POST,"students/editInformation/{id}").hasAnyRole("STUDENT","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/students/editAdvisor/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/comments/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST,"/addComment/{id}").hasRole("ADVISOR")
                        .requestMatchers(HttpMethod.POST,"/answer").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.POST,"/answers").permitAll()
                        .requestMatchers(HttpMethod.POST,"/editComment").hasRole("ADVISOR")
                        .requestMatchers(HttpMethod.POST,"/editAnswer").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET,"advisors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"advisor/student/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"advisors/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST,"/advisors/edit/{id}").hasAnyRole("ADMIN","ADVISOR")
                        .requestMatchers(HttpMethod.GET,"/announcement/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET,"/advisorAnnouncement/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST,"/createAnnouncement/{id}").hasRole("ADVISOR")
                        .requestMatchers(HttpMethod.POST,"/uploadImage").permitAll()
                        .requestMatchers(HttpMethod.POST,"/uploadAnnouncement").hasRole("ADVISOR")
                        .requestMatchers(HttpMethod.POST,"/addComment").hasRole("ADVISOR")
                      .anyRequest().authenticated();
            })

            .sessionManagement((session) ->{
              session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })


            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout((logout) -> {
              logout.logoutUrl("/api/v1/auth/logout");
              logout.addLogoutHandler(logoutHandler);
              logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
            })
    ;
    http.cors(withDefaults());
    return http.build();

  }
}
