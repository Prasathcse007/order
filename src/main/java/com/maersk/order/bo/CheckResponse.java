package com.maersk.order.bo;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckResponse {
    private Integer availableSpace;
}
