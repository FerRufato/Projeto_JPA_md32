package main.test.java.dao;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;
    private static Long idGerado;

    @Test
    @Order(1)
    public void testSalvarProduto() {
        produtoDAO = new ProdutoDAO();
        Produto produto = new Produto("Notebook", 3500.0, 10);
        produtoDAO.salvar(produto);
        Assertions.assertNotNull(produto.getId());
        idGerado = produto.getId();
    }

    @Test
    @Order(2)
    public void testBuscarProdutoPorId() {
        produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarPorId(idGerado);
        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Notebook", produto.getNome());
    }

    @Test
    @Order(3)
    public void testListarTodos() {
        produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarTodos();
        Assertions.assertFalse(produtos.isEmpty());
    }

    @Test
    @Order(4)
    public void testAtualizarProduto() {
        produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarPorId(idGerado);
        produto.setPreco(3600.0);
        produtoDAO.atualizar(produto);

        Produto atualizado = produtoDAO.buscarPorId(idGerado);
        Assertions.assertEquals(3600.0, atualizado.getPreco());
    }

    @Test
    @Order(5)
    public void testRemoverProduto() {
        produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarPorId(idGerado);
        produtoDAO.remover(produto);

        Produto removido = produtoDAO.buscarPorId(idGerado);
        Assertions.assertNull(removido);
    }
}
