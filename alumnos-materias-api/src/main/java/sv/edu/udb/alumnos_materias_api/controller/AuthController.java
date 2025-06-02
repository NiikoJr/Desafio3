package sv.edu.udb.alumnos_materias_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.alumnos_materias_api.config.JwtUtil;
import sv.edu.udb.alumnos_materias_api.model.AuthRequest;
import sv.edu.udb.alumnos_materias_api.model.AuthResponse;
import sv.edu.udb.alumnos_materias_api.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = usuarioService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generarToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
