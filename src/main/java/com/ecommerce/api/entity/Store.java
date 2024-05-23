package com.ecommerce.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//store: { name, phone, tax_no, bank_account  }
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "store", schema = "ecommerce")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String phone;
    @Column(name = "tax_no")

    private String taxNo;

    @Column(name = "bank_account")
    private String bankAccount;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
