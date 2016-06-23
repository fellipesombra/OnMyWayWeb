package br.com.onmyway.service.email;

import br.com.onmyway.model.Email;

/**
 * Classe respons�vel pelos servi�os de envio de email
 */
public interface EmailService {

	/**
	 * Envia o {@link Email}
	 * @param emailInfo Informa��es do email que ser� enviado
	 */
	public void sendEmail(Email emailInfo);
}
