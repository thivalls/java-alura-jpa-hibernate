package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {
    public static void main(String[] args) {
        Conta conta = new Conta();
        // TRANSIENT
        conta.setNumero(123452323);
        conta.setAgencia(543212323);
        conta.setTitular("Juliete");
        conta.setSaldo(222.0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager myEntity = emf.createEntityManager();

        myEntity.getTransaction().begin();
        // TRANSIENT -> MANAGED
        myEntity.persist(conta);

        // MANAGED -> REMOVED
        myEntity.remove(conta);
        myEntity.getTransaction().commit();
    }
}
