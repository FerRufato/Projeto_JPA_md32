package dao;



import domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");

    @Override
    public void salvar(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    @Override
    public List<Produto> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        em.close();
        return produtos;
    }

    @Override
    public void atualizar(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        produto = em.merge(produto); // garantir que está gerenciado
        em.remove(produto);
        em.getTransaction().commit();
        em.close();
    }
}