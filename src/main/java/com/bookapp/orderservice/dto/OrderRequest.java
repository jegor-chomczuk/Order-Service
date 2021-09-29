package com.bookapp.orderservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
public class OrderRequest {

    private String bookIsbn;

    private Integer quantity;

    private String userEmail;
}
