package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizaRegistroDetached {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager myEntity = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setNumero(1234565);
        conta.setAgencia(5654321);
        conta.setTitular("Peçanha 1");
        conta.setSaldo(1000.0);

        myEntity.getTransaction().begin();
        myEntity.persist(conta);
        myEntity.getTransaction().commit();
        myEntity.close();

        conta.setSaldo(3000.0);

        EntityManager me = emf.createEntityManager();
        me.getTransaction().begin();
        me.merge(conta);
        me.getTransaction().commit();


    }
}
