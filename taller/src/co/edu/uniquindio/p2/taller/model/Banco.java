package co.edu.uniquindio.p2.taller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco {
	
	private String nombre;
	private List<Cuenta> listaCuentas;
	private List<Cliente> listaClientes;
	
	/**
	 * Metodo constructor
	 */
	public Banco() {
		
	}

	/**
	 * Metodo constructor
	 * @param nombre Nombre del banco
	 */
	public Banco(String nombre) {
		this.nombre = nombre;
		listaCuentas=new ArrayList<Cuenta>();
		listaClientes=new ArrayList<Cliente>();
	}
	
	/**
	 * Metodo que obtiene el nombre del banco
	 * @return Nombre del banco
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que cambia el nombre del banco
	 * @param nombre Nuevo nombre del banco
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que obtiene la lista de cuentas bancarias
	 * @return Lista de cuentas bancarias
	 */
	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	
	/**
	 * Metodo que cambia la lista de cuentas bancarias
	 * @param listaCuentas Nueva lista de cuentas bancarias
	 */
	public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	/**
	 * Metodo que obtiene un mensaje con la informacion del banco
	 * @param informacion del banco
	 */
	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", listaCuentas=" + listaCuentas.toString() + "]";
	}
	
	/**
	 * Metodo que obtiene el numero hash del banco
	 * @return Codigo hash del banco
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	/**
	 * Metodo que verifica si un banco es igual al actual por medio de su nombre
	 * @param obj Objeto con el que el banco se va a comparar si es igual
	 * @return Respuesta de que si los bancos son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	/**
	 * Metodo que obtiene una cuenta con el numero de cuenta indicado, si no lo encuentra devolvera un null
	 * @param numeroCuenta Numero de la cuenta a buscar
	 * @return Cuenta encontrada o null en caso de que no exista una cuenta con ese numero
	 */
	public Cuenta encontrarCuenta(String numeroCuenta) {
		Cuenta cuentaEncontrada=null;
		for (Cuenta cuenta : listaCuentas) {
			if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
				cuentaEncontrada=cuenta;
				break;
			}
		}
		return cuentaEncontrada;
	}
	
	/**
	 * Metodo que agrega una cuenta a la lista de cuentas
	 * @param cuenta Cuenta a agregar
	 * @throws Exception Error en el caso de que ya este registrada una cuenta con el mismo numero de cuenta
	 */
	public void agregarCuenta(Cuenta cuenta) throws Exception  {
		if (encontrarCuenta(cuenta.getNumeroCuenta())==null) {
			listaCuentas.add(cuenta);
		} else {
			throw new Exception("Ese numero de cuenta ya esta registrado");
		}
	}
	
	/**
	 * Metodo que consula el saldo de una cuenta
	 * @param numeroCuenta Numero de la cuenta que se desea obtener su saldo
	 * @return Saldo d ela cuenta o -1 en caso de que no exista
	 */
	public double consultarSaldo(String numeroCuenta) {
		double saldo=-1;
		for (Cuenta cuenta : listaCuentas) {
			if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
				saldo=cuenta.consultarSaldo();
				break;
			}
		}
		return saldo;
	}
	
	/**
	 * Metodo que imprime la informacion de una cuenta o en caso de que no exista un mensaje informandolo
	 * @param numeroCuenta Numero de la cuenta 
	 */
	public void imprimirInformacion(String numeroCuenta) {
		Cuenta cuenta=encontrarCuenta(numeroCuenta);
		if (cuenta!=null) {
			cuenta.imprimirInformacion();
		} else {
			System.out.println("No existe una cuenta con ese numero");
		}
	}
	
	/**
	 * Metodo que deposita dinero a una cuenta
	 * @param numeroCuenta Numero de la cuenta en dodnde se desea depositar
	 * @param valorConsignado Valor que se desea consignar
	 * @throws Exception Error en caso de que no exista una cuenta con ese numero
	 */
	public void depositarDinero(String numeroCuenta,double valorConsignado) throws Exception {
		Cuenta cuenta=encontrarCuenta(numeroCuenta);
		if (cuenta!=null) {
			cuenta.depositarDinero(valorConsignado);	
		} else {
			throw new Exception("No existe una cuenta con ese numero");
		}
	}
	
	/**
	 * Metodo que retira dinero de una cuenta 
	 * @param numeroCuenta Numero de la cuenta en dodnde se desea depositar
	 * @param valorRetirado Valor que se desea retirar
	 * @throws Exception Error en caso de que no exista una cuenta con ese numero 
	 */
	public void retirarDinero(String numeroCuenta,double valorRetirado) throws Exception {
		Cuenta cuenta=encontrarCuenta(numeroCuenta);
		if (cuenta!=null) {
			cuenta.retirarDinero(valorRetirado);
		} else {
			throw new Exception("No existe una cuenta con ese numero");
		}
	}
	
	/**
	 * Metodo que compara una cuenta con otra, dando la respuesta si la primera cuenta es mayor o igual a la otra
	 * @param numeroCuenta1 Primer cuenta a comparar
	 * @param numeroCuenta2 Segunda cuenta a comparar
	 * @return Respuesta de que si la primera cuenta es mayor o igual a la otra
	 * @throws Exception Error en caso de que no exista alguna de las cuentas con esos numeros
	 */
	public boolean compararCuenta(String numeroCuenta1,String numeroCuenta2) throws Exception {
		boolean respuesta;
		Cuenta cuenta1=encontrarCuenta(numeroCuenta1);
		Cuenta cuenta2=encontrarCuenta(numeroCuenta2);
		if (cuenta1!=null && cuenta2!=null) {
			respuesta=cuenta1.compararCuenta(cuenta2);
		} else {
			throw new Exception("No existe una cuenta con ese numero");
		}
		return respuesta;
	}
	
	/**
	 * Metodo que tran
	 * @param numeroCuenta1
	 * @param numeroCuenta2
	 * @param valorTransferrir
	 * @throws Exception
	 */
	public void transferirDineroOtraCuenta(String numeroCuenta1,String numeroCuenta2,double valorTransferrir) throws Exception {
		Cuenta cuenta1=encontrarCuenta(numeroCuenta1);
		Cuenta cuenta2=encontrarCuenta(numeroCuenta2);
		if (cuenta1!=null && cuenta2!=null) {
			cuenta1.transferirOtraCuenta(cuenta2, valorTransferrir);
		} else {
			throw new Exception("No existe una cuenta con ese numero");
		}
	}
	
}
