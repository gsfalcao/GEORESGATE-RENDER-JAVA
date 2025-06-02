package georesgate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(nullable = false, length = 20)
    private String telefone;

    private Integer membros_familia;

    private String endereco;

    private String cep;

    private String numero;

    private String tipo_residencia;

    private Integer numero_andares;

    private String garagem_subterranea;

    // Getters e Setters

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getMembros_familia() {
        return membros_familia;
    }

    public void setMembros_familia(Integer membros_familia) {
        this.membros_familia = membros_familia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo_residencia() {
        return tipo_residencia;
    }

    public void setTipo_residencia(String tipo_residencia) {
        this.tipo_residencia = tipo_residencia;
    }

    public Integer getNumero_andares() {
        return numero_andares;
    }

    public void setNumero_andares(Integer numero_andares) {
        this.numero_andares = numero_andares;
    }

    public String getGaragem_subterranea() {
        return garagem_subterranea;
    }

    public void setGaragem_subterranea(String garagem_subterranea) {
        this.garagem_subterranea = garagem_subterranea;
    }
}