@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repo;

    public Produto salvar(Produto produto) {
        return repo.save(produto);
    }
    public List<Produto> listar() {
        return repo.findAll();
    }
    public Produto buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    public Produto atualizar(Long id, Produto prodAtualizado) {
        Produto prod = buscarPorId(id);
        prod.setNome(prodAtualizado.getNome());
        prod.setDescricao(prodAtualizado.getDescricao());
        prod.setPreco(prodAtualizado.getPreco());
        return repo.save(prod);
    }
    public void deletar(Long id) {
        repo.deleteById(id);
    }
} 
