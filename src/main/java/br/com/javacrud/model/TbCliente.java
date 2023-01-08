package br.com.javacrud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table; 
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CLIENTE")
public class TbCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="TB_CLIENTE_CODCLIENTE_GENERATOR", sequenceName="SEQ_CLIENTE", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_CLIENTE_CODCLIENTE_GENERATOR")
	@Column(name="ID_CLIENTE")
	private Long idCliente;

	@Column(name="NOME_CLIENTE")
	private String nomeCliente;
	
	@Column(name="CPF_CLIENTE")
	private String cpfCliente;
	
	@Column(name="ENDERECO_CLIENTE")
	private String enderecoCliente;
	
	@Column(name="TELEFONE_CLIENTE")
	private String telefoneCliente;
	
	@Column(name="USUARIO_INICIO")
	private String usuarioInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_INICIO")
	private Date dataInicio;
	
	@Column(name="USUARIO_FIM")
	private String usuarioFim;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_FIM")
	private Date dataFim;
		
	public TbCliente() {
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getUsuarioInicio() {
		return usuarioInicio;
	}

	public void setUsuarioInicio(String usuarioInicio) {
		this.usuarioInicio = usuarioInicio;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getUsuarioFim() {
		return usuarioFim;
	}

	public void setUsuarioFim(String usuarioFim) {
		this.usuarioFim = usuarioFim;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}