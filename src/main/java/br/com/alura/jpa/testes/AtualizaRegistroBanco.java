package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizaRegistroBanco {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager myEntity = emf.createEntityManager();

        Conta conta = myEntity.find(Conta.class, 2L);

        myEntity.getTransaction().begin();
        conta.setSaldo(150.0);
        myEntity.getTransaction().commit();
    }
}
