package com.tui.proof.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {

    private int pilotes;
    private Long clientId;
    private boolean isDelivery;
    
    public OrderDto() {
    }

    public OrderDto(boolean isDelivery, int pilotes, Long clientId) {
        this.isDelivery = isDelivery;
        this.pilotes = pilotes;
        this.clientId = clientId;
    }
}
