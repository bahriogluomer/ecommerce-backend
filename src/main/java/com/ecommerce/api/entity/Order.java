package com.ecommerce.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

//{
//        "address_id": 1,
//        "order_date": "2024-01-10T14:18:30",
//        "card_no": 1234123412341234,
//        "card_name": "Ali Baş",
//        "card_expire_month": 12,
//        "card_expire_year": 2025,
//        "card_ccv": 321,
//        "price": 1919,
//        "products": [
//        {
//        "product_id": 12,
//        "count": 1,
//        "detail": "açık mavi - xl"
//        },
//        {
//        "product_id": 13,
//        "count": 2,
//        "detail": "siyah - lg"
//        }
//        ]
//        }

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders", schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name="order_date")
    private Instant orderDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "card_no")
    private String cardNo;
    @Column(name = "card_name")
    private String cardName;
    @Column(name = "card_expire_month")
    private Integer cardExpireMonth;
    @Column(name = "card_expire_year")
    private Integer cardExpireYear;
    @Column(name = "card_ccv")
    private Integer cardCCV;
    @Column(name = "price")
    private Double price;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderedProduct> products;
}
