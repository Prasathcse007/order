package com.maersk.order.bo;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {
    private Integer bookingRef;
}
