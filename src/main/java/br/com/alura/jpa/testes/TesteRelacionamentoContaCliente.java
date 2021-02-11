package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.*;

import javax.persistence.*;

public class TesteRelacionamentoContaCliente {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setId(1L);

        Client client = new Client();
        client.setConta(conta);
        client.setEndereco("Alameda das Orquideas");
        client.setNome("Santander");
        client.setProfissao("Bancario");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();

    }
}
