package com.aidarkstu.payload.request;

public record NewCustomerRequest(
        String name,
        String email,
        Integer age
) {

}
