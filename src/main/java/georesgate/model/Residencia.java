package georesgate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "residencia")
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    private String numero;
    private String cep;
    private String tipo;
    private Integer numero_andares;
    private Boolean garagem_subterranea;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero_andares() {
        return numero_andares;
    }

    public void setNumero_andares(Integer numero_andares) {
        this.numero_andares = numero_andares;
    }

    public Boolean getGaragem_subterranea() {
        return garagem_subterranea;
    }

    public void setGaragem_subterranea(Boolean garagem_subterranea) {
        this.garagem_subterranea = garagem_subterranea;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}