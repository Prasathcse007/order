package com.maersk.order.bo;

import com.maersk.order.constant.ContainerType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {
    @NotNull
    private Integer containerSize;
    private ContainerType containerType;
    @NotNull
    @Size(min=5, max=30)
    private String origin;
    @NotNull
    @Size(min=5, max=30)
    private String destination;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer quantity;
    private LocalDateTime timestamp;
}
