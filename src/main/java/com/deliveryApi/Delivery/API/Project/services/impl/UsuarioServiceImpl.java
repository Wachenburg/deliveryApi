package com.deliveryApi.Delivery.API.Project.services.impl;

import com.deliveryApi.Delivery.API.Project.dto.request.LoginRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.request.UsuarioRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.LoginResponseDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.UsuarioResponseDTO;
import com.deliveryApi.Delivery.API.Project.entity.Usuario;
import com.deliveryApi.Delivery.API.Project.enums.Role;
//import com.deliveryApi.Delivery.API.Project.exception.BusinessException;
//import com.deliveryApi.Delivery.API.Project.repository.UsuarioRepository;
import com.deliveryApi.Delivery.API.Project.exceptions.BusinessException;
import com.deliveryApi.Delivery.API.Project.repository.UsuarioRepository;
import com.deliveryApi.Delivery.API.Project.security.JwtUtil;
import com.deliveryApi.Delivery.API.Project.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        if(usuarioRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("Email já cadastrado: " + dto.getEmail());
        }
        Usuario usuario = Usuario.builder()
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .nome(dto.getNome())
                .role(dto.getRole() != null ? dto.getRole() : Role.CLIENTE)
                .dataCriacao(LocalDateTime.now())
                .ativo(true)
                .restauranteId(dto.getRestauranteId())
                .build();
        usuarioRepository.save(usuario);

        return modelMapper.map(usuario, UsuarioResponseDTO.class);

    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha()));
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BusinessException(String.valueOf(HttpStatus.UNAUTHORIZED)));

        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setUsuario(modelMapper.map(usuario, UsuarioResponseDTO.class));
        responseDTO.setTipo("Bearer");
        responseDTO.setExpiracao(86400000L); // 1 dia em segundos
        responseDTO.setToken(jwtUtil.generateToken(User.withUsername(usuario.getEmail()).password(usuario.getSenha()).authorities("ROLE_" + usuario.getRole().name()).build(), usuario));

        return responseDTO;

    }
}
