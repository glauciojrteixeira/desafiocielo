package br.com.elo.desafiocielo.resources.exceptions;

import java.io.Serializable;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	private String fieldName;
	private String message;
	
	/**
	 * Construtores
	 * @param fieldName
	 * @param message
	 */
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	public FieldMessage() {
		
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
