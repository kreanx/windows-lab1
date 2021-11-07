package com.example.windows.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JoinColumn(name = "window_id")
    @ManyToOne
    private Window window;

    @NonNull
    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @NonNull
    private Date date;

    @NonNull
    private int cost;
}
