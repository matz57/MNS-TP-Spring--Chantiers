package edu.jmatz.tpspringchantiers.controllers;

import edu.jmatz.tpspringchantiers.dao.UtilisateurDao;
import edu.jmatz.tpspringchantiers.models.Utilisateur;
import edu.jmatz.tpspringchantiers.security.AppUserDetails;
import edu.jmatz.tpspringchantiers.security.AppUserDetailsService;
import edu.jmatz.tpspringchantiers.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/sign-in")
    public void signIn(@RequestBody Utilisateur utilisateur) {

        utilisateur.setMotDePasse(bCryptPasswordEncoder.encode(utilisateur.getMotDePasse()));

        utilisateurDao.save(utilisateur);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Utilisateur utilisateur) {
        try {
            UserDetails userDetails = (UserDetails) authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getPseudo(),
                            utilisateur.getMotDePasse()
                    )
            ).getPrincipal();

            String jwtToken = jwtUtils.generateJwt(userDetails);
            return ResponseEntity.ok(jwtToken);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
