package br.com.locadora.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.entity.Funcionario;
import br.com.locadora.utils.annotation.Required;
import br.com.locadora.utils.locale.LocaleUtils;

public class SystemUtils {
	
	private static Funcionario funcionarioLogado;
	
	/**
	 * Valida o preenchimento de um campo obrigatório por reflection
	 * @author Renan Baggio | Joaquim Neto
	 * @param objeto Objeto com os campos (atributos) a serem validados
	 * @return <b>true</b> se todos campos obrigatórios foram preenchidos
	 */
	public static boolean isCamposObrigatoriosPreenchidos(Object objeto) {
		// Obtendo a classe do objeto e seus atributos
		Class<?> classe = objeto.getClass();
		Field[] atributos = classe.getDeclaredFields();
		boolean camposValidos = true;
		StringBuilder mensagem = new StringBuilder(LocaleUtils.getLocaleMessages().getString("falha_minimo")+" ");

		for (Field atributo : atributos) {
			// Tentando obter a annotation Required
			Required required = atributo.getAnnotation(Required.class);

			// Verificando se a anotação estava presente
			if (required != null) {
				// Tornando o atributo "public"
				atributo.setAccessible(true);
				try {
					// Obtendo o valor do atributo
					Object valor = atributo.get(objeto);

					// Verificando o tamanho mínimo (length) para este atributo
					if (valor == null || valor.toString().length() < required.minimo()) {
						// Criando mensagem de validação
						mensagem.append(required.minimo());
						mensagem.append(" " + LocaleUtils.getLocaleMessages().getString("falha_caracteres") + " ");
						mensagem.append(required.label());
						mensagem.append("\n");
						
						camposValidos = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// Adicionando mensagem de validação
		if (!mensagem.toString().equals(LocaleUtils.getLocaleMessages().getString("falha_minimo") + " ")) {
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		return camposValidos;
	}

	/**
	 * Valida o preenchimento de um campo obrigatório por reflection e retorna uma lista
	 * com os campos obrigatórios não preenchidos.<br>
	 * Retorna uma lista vazia se todos os campos obrigatórios foram preenchidos
	 * @author Renan Baggio
	 * @param objeto Objeto com os campos (atributos) a serem validados
	 * @return <b>true</b> se todos campos obrigatórios foram preenchidos
	 */
	public static List<String> listarCamposObrigatoriosNaoPreenchidos(Object objeto) {
		// Obtendo a classe do objeto e seus atributos
		Class<?> classe = objeto.getClass();
		Field[] atributos = classe.getDeclaredFields();
		List<String> listaCampos = new ArrayList<String>();

		for (Field atributo : atributos) {
			// Tentando obter a annotation Required
			Required required = atributo.getAnnotation(Required.class);

			// Verificando se a anotação estava presente
			if (required != null) {
				// Tornando o atributo "public"
				atributo.setAccessible(true);
				try {
					// Obtendo o valor do atributo
					Object valor = atributo.get(objeto);

					// Verificando o tamanho mínimo (length) para este atributo
					if (valor == null || valor.toString().length() < required.minimo()) {
						// Criando mensagem de validação
						StringBuilder mensagem = new StringBuilder(LocaleUtils.getLocaleMessages().getString("falha_minimo") + " ");
						mensagem.append(required.minimo());
						mensagem.append(" " + LocaleUtils.getLocaleMessages().getString("falha_caracteres") + " ");
						mensagem.append(required.label());

						// Adicionando mensagem de validação
						listaCampos.add(mensagem.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listaCampos;
	}

	/**
	 * Limita o número de casas decimais para a quantidade desejada
	 * @author Renan Baggio
	 * @param valor double com valor a ser formatado
	 * @param casasDecimais Número de casas decimais
	 * @return double formatado
	 */
	public static double limitarCasasDecimais(double valor, int casasDecimais) {
		String valorString = String.valueOf(valor);
		int qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);
		if (qtdeCasasDecimais > casasDecimais)
			qtdeCasasDecimais = casasDecimais;

		valorString = valorString.substring(0, valorString.indexOf(".") + qtdeCasasDecimais + 1);
		qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);

		return Double.parseDouble(valorString);
	}

	/**
	 * Limita o número de casas decimais para a quantidade desejada
	 * @author Renan Baggio
	 * @param valor double com valor a ser formatado
	 * @param casasDecimais Número de casas decimais
	 * @return String com valor formatado
	 */
	public static String limitaCasasDecimaisString(double valor, int casasDecimais) {
		String valorString = String.valueOf(valor);
		int qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);
		if (qtdeCasasDecimais > casasDecimais)
			qtdeCasasDecimais = casasDecimais;

		valorString = valorString.substring(0, valorString.indexOf(".") + qtdeCasasDecimais + 1);
		qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);

		for (int i = qtdeCasasDecimais; i < casasDecimais; i++)
			valorString += "0";

		return valorString;
	}

	/**
	 * Formata a data vinda do banco de dados para o formato dd/MM/yyyy
	 * @author Renan Baggio
	 * @param strData String com a data a ser formatada
	 * @return String com a data no formato dd/MM/yyyy
	 */
	public static String formatarDataParaTela(String strData) {
		String vetor[] = strData.split("-");
		String strDataFormatada;
		strDataFormatada = vetor[2] + "/" + vetor[1] + "/" + vetor[0];
		return strDataFormatada;
	}

	/**
	 * Compara duas datas e retorna o número de dias de diferença entre elas.<br />
	 * Diferença = <code>dataHigh - dataLow</code>
	 * @author Renan Baggio
	 * @param dataTeoricamenteMenor Date com a data teoricamente inferior
	 * @param dataTeoricamenteMaior Date com a data teoricamente superior
	 * @return Integer com número de dias de diferença entre as datas
	 */
	public static int getDiferencaDias(Date dataTeoricamenteMenor, Date dataTeoricamenteMaior) {
		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();

		startTime.setTime(dataTeoricamenteMenor);
		endTime.setTime(dataTeoricamenteMaior);

		int dif_multiplier = 1;

		// Verifica a ordem de início das datas
		if (dataTeoricamenteMenor.compareTo(dataTeoricamenteMaior) < 0) {
			baseTime.setTime(dataTeoricamenteMaior);
			curTime.setTime(dataTeoricamenteMenor);
			dif_multiplier = 1;
		} else {
			baseTime.setTime(dataTeoricamenteMenor);
			curTime.setTime(dataTeoricamenteMaior);
			dif_multiplier = -1;
		}

		int result_years = 0;
		int result_months = 0;
		int result_days = 0;

		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import
		// acumulando no total de dias. Já leva em consideração ano bissexto
		while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR)
				|| curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {
			int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);
		}

		// Marca que é um saldo negativo ou positivo
		result_months = result_months * dif_multiplier;

		// Retorna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));

		return result_years + result_months + result_days;
	}

	/**
	 * Maximiza a data informada para 23:59:59
	 * @author Renan Baggio
	 * @param data
	 * @return Date
	 */
	public static Date maximizarData(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");

		String dataFormatada = dateFormat.format(data);
		dataFormatada = dataFormatada.substring(0, dataFormatada.indexOf("-"));

		try {
			return dateFormat.parse(dataFormatada + "-23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
			return data;
		}
	}

	/**
	 * Retorna data somada ou subtraida pela quantidade de dias
	 * @author Nicolas Ibanheiz
	 * @param data Data base para a nova data
	 * @param quantidadeDias Quantidade de dias para acrescetar ou retirar da data base
	 * @return Nova data calculada através dos dias informados
	 */
	public static Date getDataAlteradaEmDias(Date data, int quantidadeDias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, quantidadeDias);
		return calendar.getTime();
	}

	/**
	 * Verifica se o objeto informado é nulo (<code>null</code>) ou vazio. Se for uma
	 * Collection irá validar todos os seus elementos estão nulos ou vazios.</br> Se for
	 * um array de Objetos irá validar todos os seus elementos estão nulos ou vazios.</br>
	 * Se for um array de tipos primitivos verifica se o array está vazio.</br>
	 * @author <a href="mailto:paulohenriqueas13@gmail.com">Paulo Henrique Alves</a>
	 * @param objeto Objeto para verificação
	 * @return <b>true</b> se o objeto for nulo ou vazio
	 */
	public static boolean isNuloOuVazio(Object objeto) {
		Boolean retorno = Boolean.FALSE;

		if (objeto != null) {
			if (objeto instanceof Collection<?>) {
				Collection<?> lista = (Collection<?>) objeto;
				if (lista.isEmpty()) {
					retorno = Boolean.TRUE;
				} else {
					for (Object object : lista) {
						if (!isNuloOuVazio(object)) {
							retorno = Boolean.FALSE;
							break;
						}
					}
				}
			} else if (String.valueOf(objeto).trim().isEmpty()) {
				retorno = Boolean.TRUE;

			} else if (objeto.getClass().isArray()) {
				if (objeto instanceof Object[]) {
					Object[] array = (Object[]) objeto;
					if (array.length == 0) {
						retorno = Boolean.TRUE;
					} else {
						for (Object object : array) {
							if (!isNuloOuVazio(object)) {
								retorno = Boolean.FALSE;
								break;
							}
						}
					}
				}
			}
		} else {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

	/**
	 * Verifica se <b>todos</b> os objetos informados são nulos (<code>null</code>) ou
	 * vazios.
	 * @author Renan Baggio
	 * @param objeto Objetos para verificação
	 * @return <b>true</b> se <b>todos</b> os objetos forem nulos ou vazios
	 */
	public static boolean isTodosNulosOuVazios(Object... objetos) {
		for (Object objeto : objetos) {
			if (!isNuloOuVazio(objeto))
				return false;
		}
		return true;
	}

	/**
	 * Verifica se <b>algum</b> dos objetos informados é nulo (<code>null</code>) ou
	 * vazio.
	 * @author Renan Baggio
	 * @param objeto Objetos para verificação
	 * @return <b>true</b> se <b>algum</b> dos objetos for nulo ou vazio
	 */
	public static boolean hasAlgumNuloOuVazio(Object... objetos) {
		for (Object objeto : objetos) {
			if (isNuloOuVazio(objeto))
				return true;
		}
		return false;
	}

	/**
	 * Verifica se o campo informado é um CPF
	 * @author Renan Baggio
	 * @param Campo CNPJ/CPF
	 * @return <b>true</b> se for CPf
	 */
	public static boolean isCpf(String cnpjCpf) {
		if (cnpjCpf.contains("-") && cnpjCpf.contains(".")) {
			if (cnpjCpf.length() == 14) {
				return true;
			}
		} else if (cnpjCpf.length() == 11) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se o CPF informado é válido
	 * @author Renan Baggio
	 * @param CPF String com CPF
	 * @return <b>true</b> se CPF é válido
	 */
	public static boolean isCpfValido(String CPF) {
		String erroInvalido = LocaleUtils.getLocaleMessages().getString("falha_cpfinvalido");
		if (CPF == null) {
			System.out.println(erroInvalido);
			return false;
		}

		// Removendo máscara caso haja
		CPF = CPF.replace(".", "");
		CPF = CPF.replace("-", "");

		// Considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			System.out.println(erroInvalido);
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1º Dígito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// Converte o i-esimo caractere do CPF em um numero:
				// Por exemplo, transforma o caractere '0' no inteiro 0 (48 eh a posicao
				// de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // Converte no respectivo caractere numerico

			// Calculo do 2º Dígito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else {
				System.out.println(erroInvalido);
				return false;
			}

		} catch (InputMismatchException erro) {
			System.err.println(LocaleUtils.getLocaleMessages().getString("falha_validacaocpf"));
			return false;
		}
	}

	/**
	 * Verifica se o CNPJ informado é válido
	 * @author Renan Baggio
	 * @param CNPJ String com CNPJ
	 * @return <b>true</b> se CNPJ é válido
	 */
	public static boolean isCnpjValido(String CNPJ) {
		String erroInvalido = LocaleUtils.getLocaleMessages().getString("falha_validacaocpf");
		if (CNPJ == null) {
			System.out.println(erroInvalido);
			return false;
		}

		// Removendo máscara caso haja
		CNPJ = CNPJ.replace(".", "");
		CNPJ = CNPJ.replace("/", "");
		CNPJ = CNPJ.replace("-", "");

		// Considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14)) {
			System.out.println(erroInvalido);
			return false;
		}

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1º Dígito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// Converte o i-ésimo caractere do CNPJ em um número:
				// Por exemplo, transforma o caractere '0' no inteiro 0 (48 eh a posição
				// de '0' na tabela ASCII)
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2º Dígito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else {
				System.out.println(erroInvalido);
				return false;
			}

		} catch (InputMismatchException erro) {
			System.err.println(LocaleUtils.getLocaleMessages().getString("falha_validacaocnpj"));
			return false;
		}
	}

	/**
	 * Verifica se o parâmetro informado é CPF ou CNPJ
	 * @author Renan Baggio
	 * @param cnpjCpf Destinatário, expedidor e recebedor
	 * @return <b>true</b> se for CPF cadastrado
	 */
	public static boolean isPessoaFisica(String cnpjCpf) {
		return cnpjCpf.length() <= 11 ? true : false;
	}

	/**
	 * Calcula o dígito verificador do módulo 11 do número informado
	 * @author Renan Baggio
	 * @param numeroSemDigito
	 * @return String dígito verificador
	 */
	public static String getDigitoVerificadorModulo11(String numeroSemDigito) {
		int ponderacao = 0;
		int peso = 1;

		for (int i = numeroSemDigito.length() - 1; i >= 0; i--) {
			peso++;
			ponderacao += Integer.parseInt(String.valueOf(numeroSemDigito.charAt(i))) * peso;
			if (peso == 9)
				peso = 1;
		}
		int digitoVerificador = (11 - (ponderacao % 11));
		return String.valueOf(digitoVerificador > 9 ? 0 : digitoVerificador);
	}


	/**
	 * Retorna o valor arredondado e com o número de casas decimais informado.<br>
	 * Modo de arredondamento utilizado: RoundingMode.HALF_DOWN
	 * @author Renan Baggio
	 * @param valor Valor a ser arredondado
	 * @param casasDecimais Número de casas decimais
	 * @return double
	 */
	public static double valorArredondado(double valor, int casasDecimais) {
		return new BigDecimal(valor).setScale(casasDecimais, RoundingMode.HALF_DOWN).doubleValue();
	}

	/**
	 * Retorna o valor concatenado entre parte inteira e parte decimal de um campo
	 * @author Renan Baggio
	 * @param parteInteira Parte inteira que compõe o valor
	 * @param parteDecimal Parte decimal que compõe o valor depois da vírgula
	 * @return double
	 */
	public static double valorConcatenado(String parteInteira, String parteDecimal) {
		return Double.parseDouble(parteInteira + "." + parteDecimal);
	}

	/**
	 * Retorna um int com valor aleatório
	 * @author Renan Baggio
	 * @param objeto
	 * @return int aleatório
	 */
	public static int getRamdomId() {
		return (int) UUID.randomUUID().getLeastSignificantBits();
	}
	
	/**
	 * Converte uma java.util.Date para java.sql.Date
	 * @author Joaquim Neto
	 * @param data Objeto java.util.Date
	 * @return java.sql.Date
	 */
	public static java.sql.Date dataConverter(java.util.Date data) {
		java.sql.Date dateSql = new java.sql.Date(data.getTime());
		return dateSql;
	}

	/**
	 * Retorna à agência que está na sessão do usuário
	 * @return the agenciaSelecionado
	 */
	public static Agencia getAgenciaSelecionado() {
		return funcionarioLogado.getAgencia();
	}

	/**
	 * Retorna o funcionário logado no sistema
	 * @return the funcionarioSelecionado
	 */
	public static Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	/**
	 * Adicionado o funcionário que logou na sessão
	 * @param funcionarioSelecionado the funcionarioSelecionado to set
	 */
	public static void setFuncionarioLogado(Funcionario funcionarioSelecionado) {
		SystemUtils.funcionarioLogado = funcionarioSelecionado;
	}
}
