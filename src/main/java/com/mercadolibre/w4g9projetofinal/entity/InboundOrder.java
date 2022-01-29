package com.mercadolibre.w4g9projetofinal.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InboundOrder {
    @Id
    private Long id;
    private LocalDate orderDate;
    @OneToOne
    private Seller seller;
    @OneToOne
    private Representative representative;
    @ToString.Exclude
    @OneToMany(
            mappedBy = "inboundOrder",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Batch> batchList;
    @ManyToOne
    private Section section;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InboundOrder that = (InboundOrder) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
