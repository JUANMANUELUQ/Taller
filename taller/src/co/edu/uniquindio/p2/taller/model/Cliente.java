package co.edu.uniquindio.p2.taller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
	
	private String banco;
	private String nombre;
	private String apellido;
	private String documento;
	private List<Cuenta> listaCuentas;
	
	/**
	 * Metodo constructor
	 */
	public Cliente() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param banco Banco del cual es cliente
	 * @param nombre Nombre del cliente
	 * @param apellido Apellido del cliente
	 * @param documento Documento del cliente
	 */
	public Cliente(String banco,String nombre, String apellido, String documento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.listaCuentas=new ArrayList<Cuenta>();
	}
	
	/**
	 * Metodo que obtiene el nombre del banco
	 * @return Nombre del banco
	 */
	public String getBanco() {
		return banco;
	}
	
	/**
	 * Metodo que permite cambiar el nombre del banco
	 * @param nombre Nombre del banco
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * Metodo que obtiene el nombre del cliente
	 * @return Nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que permite cambiar el nombre del cliente
	 * @param nombre Nombre del cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que obtiene el apellido del cliente
	 * @return Apellido del cliente
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Metodo que permite cambiar el apellido del cliente
	 * @param apellido Apellido del cliente
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Metodo que obtiene el documento del cliente
	 * @return Documento del cliente
	 */
	public String getDocumento() {
		return documento;
	}
	
	/**
	 * Metodo que permite cambiar el documento del cliente
	 * @param documento Documento del cliente
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	/**
	 * Metodo que obtiene la lista de clientes
	 * @return Lista de clientes
	 */
	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	
	/**
	 * Metodo que permite cambiar la lista de clientes
	 * @param listaCuentas Lista de clientes
	 */
	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	/**
	 * Metodo que permite obtener la informacion del cliente en un mensaje
	 * @return Informacion del cliente en un mensaje
	 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + "]";
	}
	
	/**
	 * Metodo que obtiene el codigo hash del cliente actual
	 * @return Codigo hash del cliente actual
	 */
	@Override
	public int hashCode() {
		return Objects.hash(documento);
	}
	
	/**
	 * Metodo que verifica si un cliente es igual a este mismo por medio del documento de identidad
	 * @param obj Objeto con el que va a comparar este cliente
	 * @return Respuesta de que si los clientes son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(documento, other.documento);
	}
	
	/**
	 * Metodo que verifica si el cliente tiene una cuenta
	 * @param cuenta Cuenta a buscar
	 * @return Respuesta de que si el cliente tiene esa cuenta o no
	 */
	public boolean tieneCuenta(Cuenta cuenta) {
		boolean tieneCuenta=false;
		for (Cuenta cuentaActual : listaCuentas) {
			if (cuentaActual.equals(cuenta)) {
				tieneCuenta=true;
			}
		}
		return tieneCuenta;
	}
	
	/**
	 * Metodo que  que grega una cuenta a nombre del cliente
	 * @param cuenta Cuenta a agregar
	 * @throws Exception Error en caso de que el usuario ya tena esa cuenta
	 */
	public void agregarCuenta(Cuenta cuenta) throws Exception {
		if (tieneCuenta(cuenta)) {
			cuenta.setClienteTitular(getNombre()+" "+getApellido());
			listaCuentas.add(cuenta);
		} else {
			throw new Exception("El usuario ya tiene la cuenta registrada");
		}
	}

}
