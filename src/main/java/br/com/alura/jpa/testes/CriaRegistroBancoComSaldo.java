package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaRegistroBancoComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager myEntity = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setNumero(12345);
        conta.setAgencia(54321);
        conta.setTitular("Caio Jardim");
        conta.setSaldo(200.0);

        myEntity.getTransaction().begin();
        myEntity.persist(conta);
        myEntity.getTransaction().commit();
    }
}
