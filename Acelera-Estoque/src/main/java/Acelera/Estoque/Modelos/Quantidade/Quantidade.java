package Acelera.Estoque.Modelos.Quantidade;

import Acelera.Estoque.Modelos.Produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "quantidades")
@Entity(name = "Quantidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quantidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto idProduto;

    @Column(name = "mes_referencia")
    private LocalDate mesReferente;

    private Integer quantidade;




}
