package org.example.firebasefirestore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeliveryFood {
    private String type;
    private String brand;
    private Long price;
}
