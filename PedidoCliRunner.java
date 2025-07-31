@Component
public class PedidoCliRunner implements CommandLineRunner {
  @Autowired private PedidoController ctrl;
  public void run(String... args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      System.out.println("1‑Listar produtos | 2‑Simular pedido | 0‑Sair");
      int opt = sc.nextInt();
      if(opt==0) break;
      if(opt==1) { ... } else if(opt==2) { ... }
    }
  }
}
