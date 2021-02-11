package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.*;

import javax.persistence.*;
import java.util.*;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(1L);

        // String jpql = "select m from Movimentacao m where m.conta.id = 1";
        // String jpql = "select m from Movimentacao m where m.conta = :pCconta order by m.description ASC";
        String jpql = "select m from Movimentacao m join Conta c on m.conta.id = c.id";

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
//        query.setParameter("pConta", conta);
        List<Movimentacao> results = query.getResultList();

        for (Movimentacao movimentacao : results) {
            System.out.println("Descrição: " + movimentacao.getDescription());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Titular: " + movimentacao.getConta().getTitular());
        }
    }
}
