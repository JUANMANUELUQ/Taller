package co.edu.uniquindio.p2.taller.model;

import java.util.Objects;

public class Cuenta {
	
	private String banco;
	private String clienteTitular;
	private String numero;
	private TipoCuenta tipoCuenta;
	private Double saldo;
	
	/**
	 * Metodo constructor
	 */
	public Cuenta() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param apellidosTitular Apellidos del titular d ela cuenta
	 * @param numeroCuenta Numero de la cuenta
	 * @param tipoCuenta Tipo de la cuenta
	 */
	public Cuenta(String apellidosTitular, String numeroCuenta, TipoCuenta tipoCuenta) {
		this.numero = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldo=0.0;
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
	 * @param banco Nombre del banco
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	/**
	 * Metodo que obtiene el nombre del cliente titular
	 * @return Nombre del cliente titular
	 */
	public String getClienteTitular() {
		return clienteTitular;
	}
	
	/**
	 * Metodo que permite cambiar el nombre del cliente titular
	 * @param clienteTitular Nombre del cliente titular
	 */
	public void setClienteTitular(String clienteTitular) {
		this.clienteTitular = clienteTitular;
	}

	/**
	 * Metodo que obtiene el numero de cuenta
	 * @return Numero de la cuenta
	 */
	public String getNumeroCuenta() {
		return numero;
	}
	
	/**
	 * Metodo que permite cambiar el numero de la cuenta
	 * @param numeroCuenta Nuevo numero de la cuenta
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numero = numeroCuenta;
	}
	
	/**
	 * Metodo que obtiene  el tipo de cuenta
	 * @return Tipo de cuenta
	 */
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	
	/**
	 * Metodo que permite cambiar el tipo de cuenta
	 * @param tipoCuenta Nuevo tipo de cuenta
	 */
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	/**
	 * Metodo que permite consultar el saldo de la cuenta bancaria
	 * @return Saldo de la cuenta
	 */
	public double consultarSaldo() {
		return saldo;
	}
	
	/**
	 * Metodo que permite cambiar el saldo de la cuenta
	 * @param saldo Nuevo saldo de la cuenta
	 * @throws Exception Error en caso de que se ponga como nuevo saldo un valor negativo 
	 */
	public void setSaldo(double saldo) throws Exception {
		if (saldo<0) {
			throw new Exception("El valor del saldo es negativo");
		}
		this.saldo = saldo;
	}
	
	/**
	 * Metodo que permite obtener la informacion de la cuenta en un mensaje
	 * @param informacion del banco
	 */
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta="+ numero + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + "]";
	}
	
	/**
	 * Metodo que obtiene el codigo hash de la cuenta actual
	 * @return Codigo hash de la cuenta actual
	 */
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	
	/**
	 * Metodo que verifica si una cuenta es igual a la actual por medio del numero de cuenta
	 * @param obj Objeto con el que va a comparar la cuenta actual
	 * @return Respuesta de que si las cuentas son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(numero, other.numero);
	}

	/**
	 * Metodo que imprime los valores de los atributos de esta cuenta bancaria
	 */
	public void imprimirInformacion() {
		System.out.println(this.toString());
	}
	
	/**
	 * Metodo que consigna un valor a la cuenta bancaria, actualizando su saldo
	 * @param valorConsignado Valor que se desea consignar a la cuenta
	 * @throws Exception Error en caso de que el valor a consignar sea negativo
	 */
	public void depositarDinero(double valorConsignado) throws Exception {
		if (valorConsignado<0) {
			throw new Exception("El valor a consignar es negativo");
		}
		this.saldo+=valorConsignado;
	}
	
	/**
	 * Metodo que retira un valor de la cuenta bancaria, actualizando su  saldo
	 * @param valorRetirado Valor a retirar de la cuenta actual
	 * @throws Exception Error en caso de que el valor a retirar supere al valor de la cuenta actual o sea negativo
	 */
	public void retirarDinero(double valorRetirado) throws Exception {
		if (valorRetirado>this.saldo) {
			throw new Exception("El valor a retirar supera el valor de la cuenta");
		}
		if (valorRetirado<0) {
			throw new Exception("El valor a retirar es negativo");
		}
		this.saldo-=valorRetirado;
	}
	
	/**
	 * Metodo que compara esta cuenta con otra, dando la respuesta si esta cuenta es mayor o igual a otra
	 * @param cuenta Cuenta con la que se va a comparar
	 * @return Respuesta de que si la cuenta actual es mayor o igual o no
	 */
	public boolean compararCuenta(Cuenta cuenta) {
		boolean respuesta=false;
		if (this.consultarSaldo()>=cuenta.consultarSaldo()) {
			respuesta=true;
		}
		return respuesta;
	}
	
	/**
	 * Metodo que transfiere dinero de una cuenta a otra
	 * @param cuenta Cuenta de destino, la cual se le trnsferira el dinero
	 * @param valorTransferrir Valor a transferrir a la cuenta
	 * @throws Exception Error en caso de que el valor a transferrir de la cuenta actual sea mayor al guardado o sea un valor negativo
	 */
	public void transferirOtraCuenta(Cuenta cuenta,double valorTransferrir) throws Exception {
		this.retirarDinero(valorTransferrir);
		cuenta.depositarDinero(valorTransferrir);
	}

}
