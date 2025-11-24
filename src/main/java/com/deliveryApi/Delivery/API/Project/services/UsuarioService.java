package com.deliveryApi.Delivery.API.Project.services;


import com.deliveryApi.Delivery.API.Project.dto.request.LoginRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.request.UsuarioRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.LoginResponseDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto);

    LoginResponseDTO login(LoginRequestDTO dto);

}
