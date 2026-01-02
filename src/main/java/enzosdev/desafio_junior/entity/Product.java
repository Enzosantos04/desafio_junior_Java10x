package enzosdev.desafio_junior.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;


    @Column(nullable = false)
    private BigDecimal price;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;




}
