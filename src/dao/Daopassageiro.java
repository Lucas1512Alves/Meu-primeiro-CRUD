package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.Passageiro;

public class Daopassageiro implements Serializable {

    private EntityManagerFactory emf = null;
    
    /* construtor */
    public Daopassageiro(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    /* método utilizado para criar objetos no banco */
    public void create(Passageiro passageiro){
        EntityManager em = null;
        try {
            /* cria uma entidade EntityManager para utilizarmos na transação */
            em = this.emf.createEntityManager();
            
            /* inicia a transação */
            em.getTransaction().begin();
            
            /* método utilizado para persistir o objeto no banco */
            em.persist(passageiro);
            
            /* comita a transação no banco */
            em.getTransaction().commit();
            
        /* tratamento de exceções */
        } catch (Exception ex) {
            if (findPassageiro(passageiro.getCodpassageiro()) != null) {
                System.out.println("Passageiro " + passageiro + "já existe.");
            }
            
           throw ex;
           
        } finally {
            if (em != null) {
                
                /* após a operação, a transação é finalizada */
                em.close();
                 
            }
        }  
    }
    
    /* método utilizado para editar objetos do banco */
    public void edit (Passageiro passageiro) {
        EntityManager em = null;
        try {
            /* cria uma entidade EntityManager para utilizarmos na transação */
            em = this.emf.createEntityManager();
            
            /* inicia a transação */
            em.getTransaction().begin();
            
            /* método utilizado para alterar o objeto no banco */
            passageiro = em.merge(passageiro);
            
            /* comita a transação no banco */
            em.getTransaction().commit();
            
        /* tratamento de exceções */    
        } catch (Exception ex) {
            
            int id = passageiro.getCodpassageiro();
            if (findPassageiro (id) == null) {
                System.out.println("O passageiro com ID " + id + "não existe.");
                System.out.println(ex.toString());
            }
            
            throw ex;
            
        } finally {
            if (em != null) {
                
                /* após a operação, a transação é finalizada */
                em.close();
            }
        }
    }
    
    /* método utilizado para remover objetos do banco */
    public void destroy(int id){
        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
            em.getTransaction().begin();
            Passageiro passageiro;
            try {
                /* recupera a referência do objeto a ser removido */
                passageiro = em.getReference(Passageiro.class, id);
                
                /* método utilizado para remover o produto do banco */
                em.remove(passageiro);
                
                /* comita a transação no banco */
                em.getTransaction().commit();
            } catch (Exception ex) {
                
                System.out.println("Passageiro " + id + "Apagado");
            }
            
        } finally {
            if (em != null) {
                
                 /* após a operação, a transação é finalizada */
                em.close();
            }
        }
    }
    
    /* método utilizado para recuperar um produto pelo seu id */
    public Passageiro findPassageiro (int id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            
            return em.find(Passageiro.class, id);
        } finally {
             /* após a operação, a transação é finalizada */
            em.close();
        }
    }
    
     /* método utilizado para recuperar todos os produtos da base */
    public List<Passageiro> findAllPassageiro() {
        
        EntityManager em = this.emf.createEntityManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            
            /* métodos utilizados para criar a consulta */
            cq.select (cq.from(Passageiro.class));
            Query q = em.createQuery(cq);
            
            return q.getResultList();
            
        } finally {
            
            /* após a operação, a transação é finalizada */
            em.close();
        }
    }
    
    /* método utilizado para gerar o próximo id válido da entidade produto */
    private int generatedNextId(){
        EntityManager em = this.emf.createEntityManager();
        
        try {
            int nextId = (int) em.createNativeQuery("SELECT prod.codproduto FROM produto prod ORDER BY prod.codproduto DESC").getResultList().get(0) + 1;
            return nextId;
            
        } catch (java.lang.ArrayIndexOutOfBoundsException e){
            
            return 1;
        }
    }
}
