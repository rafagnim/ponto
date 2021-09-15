<h2>Sistema de controle de ponto e acesso com Spring Boot</h2>

Este  API foi desenvolvido em aula proporcionada pela Digital Innovation One, através do desenvolvedor Rodolfo Gomes.

Em relação ao projeto desenvolvido em aula, fiz os seguintes acréscimos:

- ---

Acrescentei uma Interface Repository, uma classe Service e uma Controller para as entidades Empresa e Usuario (em aula foi efetuado apenas para a entidade Jornada.

O desenvolvimento desta API trouxe vários desafios e aprendizado, aprimorando o conhecimento de JPA, conexão com o banco de dados H2 e configuração e utilização do Swagger.

Por já ter experiência com o desenvolvimento de outras API, este projeto em especial acrescentou o aprendizado sobre como incluir chaves externas (FK) nas entidades, para acesso e gravação no banco de dados, conforme exemplo abaixo (@ManyToOne):

```
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Usuario {
    @Id
    private Long id;
    @ManyToOne
    private CategoriaUsuario categoriaUsuario;
    private String nome;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private NivelAcesso nivelAcesso;
    @ManyToOne
    private  JornadaTrabalho jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;
```

-------------

Pré-requisitos para a execução do projeto:

* Java 11 ou versões superiores;
* Gradle;
* Intellj IDEA Community Edition ou outra IDE;
* H2, Swagger e Lombok como dependências.
