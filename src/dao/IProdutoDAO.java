package dao;





import domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    void salvar(Produto produto);
    Produto buscarPorId(Long id);
    List<Produto> listarTodos();
    void atualizar(Produto produto);
    void remover(Produto produto);
}


