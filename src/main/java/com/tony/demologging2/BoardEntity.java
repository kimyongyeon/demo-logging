package com.tony.demologging2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_BOARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message="id is not null")
    private long id;
    @Column(name = "NAME")
    @NotNull(message="name is not null")
    private String name;
    @Column(name = "PRICE")
    @NotNull(message="price is not null")
    private BigDecimal price;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=>").append(this.id)
        .append(", name=>").append(this.name)
        .append(", price=>").append(this.price);
        return stringBuilder.toString();
    }
}
