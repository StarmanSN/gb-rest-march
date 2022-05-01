package ru.bg.gbrestmarch.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "order_date", updatable = false)
    private LocalDate orderDate;
    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_order_details_product"))
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "cost")
    private double cost;
    @Column(name = "amount")
    private double amount;



}
