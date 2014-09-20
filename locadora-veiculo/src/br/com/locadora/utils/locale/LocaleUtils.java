package br.com.locadora.utils.locale;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import br.com.locadora.utils.Constants;
import br.com.locadora.utils.SystemUtils;

/**
 * Essa class é reponsavel pela internacionalização do sistema, com métodos facilitadores
 * que agilizam o desenvolvimento
 * @author Joaquim Neto
 */
public class LocaleUtils {

	// Armazena as configurações de internacionalização das Telas do Sistema
	private static ResourceBundle localeView;

	// Armazena as configurações de Internacionalização das Mensagem do Sistema
	private static ResourceBundle localeMessages;

	/**
	 * Define o idioma padrão utilizando o localeID </br>Exemplo:
	 * setLocaleId(<b>"pt_BR"</b>);
	 * @param localeId Locale que será usado no sistema
	 * @param defaultLocale <b>true</b> definir o localeId como default para o proximo
	 * acesso ao sistema
	 */
	public static void setLocaleId(String localeId, boolean defaultLocale) {
		// Carrega as configurações default
		Properties property = carregarPorpertyDefault();

		// Verifica se o localeId é igual ao armazenado por default
		if (defaultLocale) {
			if (!property.getProperty("locale_default").equals(localeId)) {
				// Salva a nova localeId como default para a proxima utilização do sistema
				salvarPorpertyDefault(localeId);
			}
		}

		// Faz a internacionalização do sistema
		carregarInternacionalizacao(localeId);

	}

	/**
	 * Carrega as configurações default do locale de uma arquivo properties
	 * @author Joaquim Neto
	 * @return Properteis com as configurações
	 */
	private static Properties carregarPorpertyDefault() {
		Properties property = new Properties();
		InputStream inputStream = null;

		try {
			// Carrega o properties
			inputStream = new FileInputStream("./src/br/com/locadora/utils/locale/defaultLocale.properties");
			property.load(inputStream);

		} catch (Exception e) {
			System.err.println("Falha ao carregar o Idioma Default");
			e.printStackTrace();
		}

		return property;
	}

	/**
	 * Salva as configurações de locale default em um arquivo properteis
	 * @author Joaquim Neto
	 * @param localeId String com o localeId exemplo:<b>"pt_BR"</b>
	 */
	public static void salvarPorpertyDefault(String localeId) {
		Properties property = new Properties();
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream("./src/br/com/locadora/utils/locale/defaultLocale.properties");
			property.setProperty("locale_default", localeId);

			property.store(outputStream, null);
		} catch (Exception e) {
			System.err.println("Falha ao salvar o idioma default");
			e.printStackTrace();
		}
	}

	/**
	 * Carrega a ResourceBundle com a localeId informada por parâmetro
	 * @author Joaquim Neto
	 * @param localeId String com Locale para internacionalização exemplo:<b>"pt_BR"</b>
	 */
	private static void carregarInternacionalizacao(String localeId) {
		// Valida a localeID, se for invalida carrega o bundle padrão
		if (!SystemUtils.isNuloOuVazio(localeId) && localeId.length() == 5) {
			// Internacionalização das telas do sistema
			localeView = ResourceBundle.getBundle(Constants.PATH_VIEWS_INTERNACIONALIZADA,
					new Locale(localeId.substring(0, 2), localeId.substring(3, 5).toUpperCase()));

			// Internacionalização das mensagens do sistema
			localeMessages = ResourceBundle.getBundle(Constants.PATH_MESSAGES_INTERNACIONALIZADA,
					new Locale(localeId.substring(0, 2), localeId.substring(3, 5).toUpperCase()));
		} else {
			// Internacionalização das telas do sistema
			localeView = ResourceBundle.getBundle(Constants.PATH_VIEWS_INTERNACIONALIZADA);

			// Internacionalização das mensagens do sistema
			localeMessages = ResourceBundle.getBundle(Constants.PATH_MESSAGES_INTERNACIONALIZADA);
		}
	}

	/**
	 * Retorna o Bundle de internacionalização das views do sistema
	 * @return the localeView
	 */
	public static ResourceBundle getLocaleView() {
		// Carrega a internacionalização default caso não exista nenhum definida
		if (SystemUtils.isNuloOuVazio(localeView)) {
			carregarInternacionalizacao(carregarPorpertyDefault().getProperty("locale_default"));
		}
		return localeView;
	}

	/**
	 * Retorna o Bundle de internacionalização das messages do sistema
	 * @return the localeMessages
	 */
	public static ResourceBundle getLocaleMessages() {
		// Carrega a internacionalização default caso não exista nenhum definida
		if (SystemUtils.isNuloOuVazio(localeMessages)) {
			carregarInternacionalizacao(carregarPorpertyDefault().getProperty("locale_default"));
		}
		return localeMessages;
	}
	
	public static String getDisplayLocale() {
		return carregarPorpertyDefault().getProperty("locale_default");
	}
}
