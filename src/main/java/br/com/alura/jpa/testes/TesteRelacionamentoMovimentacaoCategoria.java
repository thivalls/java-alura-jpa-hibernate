package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.*;

import javax.persistence.*;
import java.math.*;
import java.time.*;
import java.util.*;

public class TesteRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
//        Category category = new Category("Viagem SP");
//        Category category1 = new Category("Viagem RJ");

        Category category = new Category();
        category.setId(1L);

        Category category1 = new Category();
        category1.setId(2L);

        Conta conta = new Conta();
        conta.setId(1L);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal(100));
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescription("Viagem SP");
        movimentacao.setCategories(Arrays.asList(category, category1));
        movimentacao.setConta(conta);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal(150));
        movimentacao1.setData(LocalDateTime.now());
        movimentacao1.setDescription("Viagem SP");
        movimentacao1.setCategories(Arrays.asList(category, category1));
        movimentacao1.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Transient -> Managed (a transição faz com que o JPA sincronize e persista no banco de dados)
//        em.persist(category);
//        em.persist(category1);
        em.persist(movimentacao);
        em.persist(movimentacao1);
        em.getTransaction().commit();
        em.close();

    }
}
