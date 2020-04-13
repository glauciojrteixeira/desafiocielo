package br.com.elo.desafiocielo.resources.utils;

import br.com.elo.desafiocielo.services.exceptions.APIVersionExcecao;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

public class APIVersion {
	/*
	 * Valida a versão da API informada pelo cliente.
	 * A versão pode ser informada no cabeçalho e/ou na URI.
	 * Caso a versão não seja informada pelo cliente, 
	 * o sistema assumira como default a ultima versão.
	 */
	public static String version(String versionHeader, String versionParam) {
		if (versionHeader.equals("0") && versionParam.equals("0")) {
			// O cliente não esta especificando a versão. Será aplicado a ultima versão como default
			return "0";
		} else {
			if (!versionHeader.equals("0") && !versionParam.equals("0")) {
				if (versionHeader.equals(versionParam)) {
					return versionHeader;
				} else {
					throw new APIVersionExcecao("Versão da API informada no Headers e no Params são diferentes!");
				}
			} else {
				if (versionHeader.equals("0")) {
					return versionParam;
				} else {
					return versionHeader;
				}
			}
		}
	}
}
