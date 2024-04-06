package com.restaurant.reservation.utils.messages;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {

    private T data;
    private int status;
    private String message;

}
