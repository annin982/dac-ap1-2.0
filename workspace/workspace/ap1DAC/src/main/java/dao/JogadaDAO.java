package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Entidades.Jogada;
import util.JPAUtil;

public class JogadaDAO {
    public static void salvar(Jogada jogada) {
        EntityManager em = JPAUtil.criarEntityManager();
        em.getTransaction().begin();
        em.persist(jogada);
        em.getTransaction().commit();
        em.close();
    }

    public static void editar(Jogada jogada) {
        EntityManager em = JPAUtil.criarEntityManager();
        em.getTransaction().begin();
        em.merge(jogada);
        em.getTransaction().commit();
        em.close();
    }

    public static void excluir(Jogada jogada) {
        EntityManager em = JPAUtil.criarEntityManager();
        em.getTransaction().begin();
        jogada = em.find(Jogada.class, jogada.getId());
        em.remove(jogada);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Jogada> listar() {
        EntityManager em = JPAUtil.criarEntityManager();
        Query query = em.createQuery("select j from Jogada j");
        List<Jogada> resultado = query.getResultList();
        em.close();
        return resultado;
    }
}
