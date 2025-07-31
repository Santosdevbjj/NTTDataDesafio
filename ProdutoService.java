@Service
public class ProdutoService {
  @Autowired private ProdutoRepository repo;
  public Produto salvar(Produto p) { return repo.save(p); }
  public List<Produto> listar() { return repo.findAll(); }
  public Optional<Produto> buscar(Long id) { return repo.findById(id); }
  public Produto atualizar(Long id, Produto p) { p.setId(id); return repo.save(p); }
  public void deletar(Long id) { repo.deleteById(id); }
}
