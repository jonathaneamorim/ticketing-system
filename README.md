# Ticketing System
Sistema de cadastro, compra e emissão de ingressos para eventos.

### Importando o apache.commons
Importante para a utilização do stringUtils. Fonte: [link](https://how.dev/answers/what-is-the-stringutilsrightpad-method-in-java)
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.12.0</version>
</dependency>
```

## Checklist de requisitos
### Conter heranças e agregações nos relacionamentos
- **Herança**
  ```java
  public class Administrador extends Usuario{
    private String nomeOrganizador;
    private String senha;

    public Administrador() {
        super();
    }

    public Administrador(int id, String cpf, String nome, LocalDate dataNascimento, String email, String nomeOrganizador, String senha) {
        super(id, cpf, nome, dataNascimento, email);
        this.nomeOrganizador = nomeOrganizador;
        this.senha = senha;
    }
  }
    ```

- Agregações
  ```java
  public class Venda {
  private Ingresso ingresso;
  private Pagamento pagamento;
  private Usuario usuario;
  private LocalDate data;

  public Venda(){}

  public Venda(Ingresso ingresso, Pagamento pagamento, Usuario usuario, LocalDate data) {
      this.ingresso = ingresso;
      this.pagamento = pagamento;
      this.usuario = usuario;
      this.data = data;
  }
  }
  ```

### Pelo menos 4 entidades relacionadas
1. Pagamento se relaciona com ingresso
```java
public class Pagamento {
    private FormaPagamentoEnum formaPagamentoEnum;
    private Ingresso ingresso;
    private StatusPagamentoEnum  statusPagamento;

    public Pagamento(){}

    public Pagamento(FormaPagamentoEnum formaPagamentoEnum, Ingresso ingresso, StatusPagamentoEnum statusPagamento) {
        this.formaPagamentoEnum = formaPagamentoEnum;
        this.ingresso = ingresso;
        this.statusPagamento = statusPagamento;
    }
}
```

2. Evento se relaciona com endereço
```java
public class Evento {
    private int id;
    private String nome;
    private LocalDate data;
    private String descricao;
    private String avisos;
    private Endereco endereco;
    private List<String> atracoes = new ArrayList<>();
    private List<String> patrocinadores = new ArrayList<>();

    public Evento() {}
}
```

3. Venda se relaciona com Ingresso, Pagamento e usuário
```java
public class Venda {
    private Ingresso ingresso;
    private Pagamento pagamento;
    private Usuario usuario;
    private LocalDate data;

    public Venda(){}
}
```

4. Ingresso se relaciona com Usuario
```java
public class Ingresso {
    private String code;
    private Evento evento;
    private Usuario usuario;
    private String assento;
    private CategoriaEnum categoria;
    private Double valor;

    public Ingresso(){}
}
```

### Uso de pelo menos 1 interface

### Uso de uma ordenação

### Uso de tratamento de exceção

### 
Ter prompt de entrada de menu para o usuário entrar com dados (cadastros prévios
podem ser feitos, por exemplo, o cadastro do time de futebol, as pontuações, linhas
aéreas ou de ônibus, etc). Mas precisa ter uma interação do usuário final com o
sistema.