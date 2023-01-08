package br.com.javacrud.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;

import com.sun.xml.internal.ws.client.RequestContext;

import br.com.dao.ClienteDAO;
import br.com.javacrud.model.TbCliente;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<TbCliente> clientes = new ArrayList<TbCliente>();
	private ClienteDAO dao = new ClienteDAO();
	private TbCliente cliente = new TbCliente();
	
	@PostConstruct
	public void postConstruct() {
		listarCliente();
	}

	public String listarCliente() {
		clientes = dao.listarClientes();
		return "/paginas/formClientes.jsf";
	}

	public String persistir() {
		if (cliente.getIdCliente() == null || cliente.getIdCliente() == 0)
			salvarCliente();
		else
			editarCliente();

		return "/paginas/formClientes.jsf";
	}

	private void salvarCliente() {

		if (!dao.verificaCliente(cliente.getCpfCliente())) {
			cliente.setUsuarioInicio(cliente.getNomeCliente());
			cliente.setDataInicio(new Date());
			dao.salvarCliente(cliente);
			listarCliente();
			PrimeFaces.current().executeScript("PF('dlgCliente').hide()");
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso.", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cliente já cadastrado. Por favor verifique se o CPF esta escrito corretamente.", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
	}

	private void editarCliente() {
		dao.salvarCliente(cliente);
		PrimeFaces.current().executeScript("PF('dlgCliente').hide()");
		listarCliente();
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editação realizada com sucesso.", "");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public String inativarCliente() {
		cliente.setUsuarioFim(cliente.getNomeCliente());
		cliente.setDataFim(new Date());
		dao.salvarCliente(cliente);
		cliente = new TbCliente();
		return "/paginas/formClientes.jsf";
	}

	public String ativarCliente() {
		cliente.setUsuarioFim(null);
		cliente.setDataFim(null);
		dao.salvarCliente(cliente);
		cliente = new TbCliente();
		return "/paginas/formClientes.jsf";
	}

	public void handleClose(CloseEvent event) {
		
		cliente = new TbCliente();
	}

	public List<TbCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<TbCliente> clientes) {
		this.clientes = clientes;
	}

	public TbCliente getCliente() {
		return cliente;
	}

	public void setCliente(TbCliente cliente) {
		this.cliente = cliente;
	}

}

