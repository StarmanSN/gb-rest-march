package ru.bg.gbrestmarch.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_details")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_order_details_product"))
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "cost")
    private double cost;
    @Column(name = "amaunt")
    private double amount;

}
