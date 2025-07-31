@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  @Autowired private ProdutoService service;
  @PostMapping public Produto criar(@RequestBody Produto p){ return service.salvar(p); }
  @GetMapping public List<Produto> listar(){ return service.listar(); }
  @GetMapping("/{id}") public ResponseEntity<Produto> buscar(@PathVariable Long id){
    return service.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
  @PutMapping("/{id}") public Produto atualizar(@PathVariable Long id,@RequestBody Produto p){
    return service.atualizar(id,p);
  }
  @DeleteMapping("/{id}") public void deletar(@PathVariable Long id){ service.deletar(id); }
}
