package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.*;

import javax.persistence.*;
import java.math.*;
import java.time.*;
import java.util.*;

public class TesteRelacionamento {
    public static void main(String[] args) {

        EntityManagerFactory emfm = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emfm.createEntityManager();

        EntityManagerFactory emfc = Persistence.createEntityManagerFactory("contas");
        EntityManager emc = emfc.createEntityManager();

        Conta conta = emc.find(Conta.class, 1L);


        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescription("Primeira movimentacao");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setConta(conta);
        movimentacao.setValor(new BigDecimal(200));

        em.getTransaction().begin();
        // Iniciando sincronização e tornando movimentacao MANAGED
        em.persist(movimentacao);
        em.getTransaction().commit();
        em.close();

    }
}
