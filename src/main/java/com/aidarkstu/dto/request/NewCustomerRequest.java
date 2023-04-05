package com.aidarkstu.dto.request;

public record NewCustomerRequest(
        String name,
        String email,
        Integer age
) {

}
