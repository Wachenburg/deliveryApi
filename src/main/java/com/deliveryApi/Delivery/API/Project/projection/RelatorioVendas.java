package com.deliveryApi.Delivery.API.Project.projection;

import java.math.BigDecimal;

// Interface de Projeção
public interface RelatorioVendas {
    String getNomeRestaurante();
    BigDecimal getTotalVendas();
    Long getQuantidePedidos();
}
