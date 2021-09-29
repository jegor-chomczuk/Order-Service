package com.bookapp.orderservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "book_isbn")
    private String bookIsbn;

    private Integer quantity;

    @Column(name = "user_email")
    private String userEmail;

    public Order(String bookIsbn, Integer quantity, String userEmail) {
        this.bookIsbn = bookIsbn;
        this.quantity = quantity;
        this.userEmail = userEmail;
    }
}
