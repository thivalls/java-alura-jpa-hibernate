package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.*;

import javax.persistence.*;

public class CriaCategory {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Category category = new Category();
        category.setName("Lazer");

        em.getTransaction().begin();
        // Transient -> Managed
        em.persist(category);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
