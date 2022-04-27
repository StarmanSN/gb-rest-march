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
    @Column(name = "order_num")
    private int orderNum;
    @Column(name = "amount")
    private double amount;
    @Column(name = "customer_name")
    private String customerName;

}
