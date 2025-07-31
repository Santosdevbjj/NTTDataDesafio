@RestController
@RequestMapping("/pedidos")
public class PedidoController {
  @Autowired private RestTemplate restTemplate;
  @Bean @LoadBalanced public RestTemplate restTemplate() { return new RestTemplate(); }

  @PostMapping("/simular")
  public ResponseEntity<PedidoResponse> simular(@RequestBody PedidoRequest req) {
    List<Produto> produtos = req.getProdutoIds().stream()
      .map(id -> restTemplate.getForObject("http://produto-service/produtos/"+id, Produto.class))
      .toList();
    BigDecimal total = produtos.stream()
      .map(Produto::getPreco)
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    PedidoResponse resp = new PedidoResponse();
    resp.setProdutos(produtos);
    resp.setTotal(total);
    return ResponseEntity.ok(resp);
  }
}
