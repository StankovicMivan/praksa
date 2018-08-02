//package praksa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/igraci/**").permitAll()//svako ko pristupa nekoj str koja ima public primeni na njemu sve, **moze posle public bilo sta da dodje
//                .antMatchers("/predmeti/**").permitAll()
//                .antMatchers("/users/**").hasAuthority("ADMIN")
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login")
//                .usernameParameter("username")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .deleteCookies("remember-me")
//                .logoutSuccessUrl("/")
//                .permitAll()
//                .and()
//                .rememberMe()
//                .and()
//                .sessionManagement()//postoji sesija, u ovom slucaju imamo max 1
//                .maximumSessions(1);
//    }
//	 @Override
//	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailsService)//on cuva sve podatke koje mi imamo o korisniku
//	                .passwordEncoder(new BCryptPasswordEncoder());//hesiranje lozinke
//	    }
//}
