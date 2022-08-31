package com.maersk.order.bo;

import com.maersk.order.constant.ContainerType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvailabilityResponse {
    private boolean available;
}
