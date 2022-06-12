package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(unique = true)
	private String cpf;

	private String bairro;

	private LocalDate dataDeNascimento;

	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

	public List<AvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Object object) {
		this.dataDeNascimento = (LocalDate) object;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(Object object) {
		this.bairro = (String) object;
	}

	public void setNome(Object object) {
		this.nome = (String) object;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(Object object) {
		this.cpf = (String) object;
	}

}