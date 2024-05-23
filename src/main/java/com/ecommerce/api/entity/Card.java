package com.ecommerce.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cards", schema = "ecommerce")
public class Card {
    private Long id;
    private String no;
    private String nameOnCard;
    private String expiryMonth;
    private String expiryYear;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
