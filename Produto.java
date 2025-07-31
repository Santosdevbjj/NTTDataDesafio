@Entity
public class Produto {
  @Id @GeneratedValue private Long id;
  private String nome;
  private String descricao;
  private BigDecimal preco;
  // getters e setters
}
