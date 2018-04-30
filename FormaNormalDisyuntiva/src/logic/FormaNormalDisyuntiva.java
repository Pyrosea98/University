package logic;

import java.util.ArrayList;

public class FormaNormalDisyuntiva {

	int pInt = 1;
	int qInt = 1;
	int rInt = 1;
	int sInt = 1;
	int tInt = 1;
	int cont;

	boolean pBool = true;
	boolean qBool = true;
	boolean rBool = true;
	boolean sBool = true;
	boolean tBool = true;

	ArrayList<Character> atoms;

	String[] table;
	boolean[] val;

	/**
	 * Método para obtener el operador principal de la formula
	 * 
	 * @param proposition:
	 *            la fórmula
	 * @return el operador principal de la fórmula
	 */
	public String getMainOperator(String proposition) {
		if (proposition.contains("&") || proposition.contains("v") || proposition.contains("→")
				|| proposition.contains("↔") || proposition.contains("¬")) { // Se observa si hay opoerador
			if (proposition.charAt(0) == '¬') { // En caso de que el operador principal sea una negación
				return "¬";
			} else {
				cont = 0;
				for (int i = 0; i < proposition.length(); i++) {// Se recorrera toda la formula para encontrar el
																// operador
																// principal
					cont += proposition.charAt(i) == '(' ? 1 : 0; // se sumará 1 al contador en caso de que sea
																	// paréntesis
																	// abierto
					cont -= proposition.charAt(i) == ')' ? 1 : 0; // se restará 1 al contador en caso de que sea
																	// parentesis
																	// cerrado

					if (cont == 0) {// se rompe el for cuando el contador vuelva a ser 0
						cont = i + 1; // se asigna la posicion del último parentesis a cont para optimizar recursos en
										// memoria
						break;
					}
				}
				return "" + proposition.charAt(cont);// Restorna el operador principal que está al lado del
															// paréntesis
															// donde el contador fue 0
			}
		} else {
			return "";
		}
	}

	/**
	 * Método para encontrar la tabla de verdad de la formula proposicional
	 * 
	 * @param proposition
	 *            la formula proposicional a evaluar
	 */
	public void truthTable(String proposition) {
		atoms = new ArrayList<Character>();// Se encontrarán todos los atomos de laformula
		for (int i = 0; i < proposition.length(); i++) { // se empieza a iterar sobre la proposicion
			if (proposition.charAt(i) == 'p' || proposition.charAt(i) == 'q' || proposition.charAt(i) == 'r'
					|| proposition.charAt(i) == 's' || proposition.charAt(i) == 't') {//Se observa si en la posicion hay un atomo
				if (!(atoms.contains(proposition.charAt(i)))) {//Se agrega el atomo si no se ha agregado antes
					atoms.add(proposition.charAt(i));
					if (atoms.size() == 5) {//Si se llegan a los 5 atomos, no hay necesidad de buscar más
						break;
					}
				}
			}
		}

		table = new String[(int) Math.pow(2, atoms.size())];//Se crea un arreglo para escribir las combinaciones posibles de los atomos
		val = new boolean[(int) Math.pow(2, atoms.size())];//Se crea un arreglo para hallar el valor de verdad de la formula
		int index = 0;//

		for (int i = 0; i < 2; i++) {//Iterador de atomo p
			if (atoms.size() - 1 > 0) {//Condicional para saber si sigue otro atomo
				for (int j = 0; j < 2; j++) {//Iterador del atomo q
					if (atoms.size() - 2 > 0) {//Condicional para saber si sigue otro atomo
						for (int k = 0; k < 2; k++) {//Iterador del atomo r
							if (atoms.size() - 3 > 0) {//Condicional para saber si sigue otro atomo
								for (int l = 0; l < 2; l++) {//Iterador del atomo s
									if (atoms.size() - 4 > 0) {//Condicional para saber si sigue otro atomo
										for (int m = 0; m < 2; m++) {//Iterador del atomo t
											table[index] = pInt + "," + qInt + "," + rInt + "," + sInt + "," + tInt; //Asigna la combinación de los atomos en caso de ser 5
											val[index] = eval(proposition);// obtiene el valor de verdad de la expresion
											index++;//cambia el indice de la posicion del arreglo
											tInt = 0;//se cambia el valor numerico de t
											tBool = false;//se cambia el valor de verdad de t
										}
									} else {
										table[index] = pInt + "," + qInt + "," + rInt + "," + sInt;//Asigna la combinación de los atomos en caso de ser 4
										val[index] = eval(proposition);// obtiene el valor de verdad de la expresion
										index++;//cambia el indice de la posicion del arreglo
									}
									sInt = 0;//cambia el valor númerico de s
									sBool = false;//cambia el valor de verdad de s
									tInt = 1;//se cambia el valor numerico de t
									tBool = true;//se cambia el valor de verdad de t
								}
							} else {
								table[index] = pInt + "," + qInt + "," + rInt;//Asigna la combinación de los atomos en caso de ser 3
								val[index] = eval(proposition);// obtiene el valor de verdad de la expresion
								index++;//cambia el indice de la posicion del arreglo
							}
							rInt = 0;//cambia el valor númerico de s
							rBool = false;//cambia el valor de verdad de s
							sInt = 1;//cambia el valor númerico de s
							sBool = true;//cambia el valor de verdad de s
							tInt = 1;//se cambia el valor numerico de t
							tBool = true;//se cambia el valor de verdad de t
						}
					} else {
						table[index] = pInt + "," + qInt;//Asigna la combinación de los atomos en caso de ser 2
						val[index] = eval(proposition);// obtiene el valor de verdad de la expresion
						index++;//cambia el indice de la posicion del arreglo
					}
					qInt = 0; //Cambia el valor numerico de q
					qBool = false;//Cambia el valor de verdad de q
					rInt = 1;//cambia el valor númerico de s
					rBool = true;//cambia el valor de verdad de s
					sInt = 1;//cambia el valor númerico de s
					sBool = true;//cambia el valor de verdad de s
					tInt = 1;//se cambia el valor numerico de t
					tBool = true;//se cambia el valor de verdad de t
				}
			} else {
				table[index] = pInt + "";//Asigna la combinación de los atomos en caso de ser 1
				val[index] = eval(proposition);// obtiene el valor de verdad de la expresion
				index++;//cambia el indice de la posicion del arreglo
			}
			pInt = 0;//Cambia el valor numerico de p
			pBool = false; // cambia el valor de verdad de p
			qInt = 1; //Cambia el valor numerico de q
			qBool = true;//Cambia el valor de verdad de q
			rInt = 1;//cambia el valor númerico de s
			rBool = true;//cambia el valor de verdad de s
			sInt = 1;//cambia el valor númerico de s
			sBool = true;//cambia el valor de verdad de s
			tInt = 1;//se cambia el valor numerico de t
			tBool = true;//se cambia el valor de verdad de t
		}
	}

	/**
	 * Metodo para evaluar el valor de verdad una proposicion
	 * @param proposition
	 * @return true or false
	 */
	public boolean eval(String proposition) {//Evaluación de la formula proposicional
		switch (getMainOperator(proposition)) {//En caso de que no haya operador principal se retorna el valor de verdad del átomo
		case "":
			switch (proposition.charAt(0)) {
			case 'p':
				return pBool;
			case 'q':
				return qBool;
			case 'r':
				return rBool;
			case 's':
				return sBool;
			case 't':
				return tBool;
			}
		case "¬"://Caso de negación retorna el valor de verdad de la negacion del valor de verdad de la proposicion dentro
			return !eval(proposition.substring(2, proposition.length() - 1));
		case "&":
			return eval(proposition.substring(1, cont - 1))//Caso de conjuncion retorna el valor de verdad de la sub cadena antes del &, operada con el valor de verdad de la cadena después del &
					&& eval(proposition.substring(cont + 2, proposition.length() - 1));
		case "v":
			return eval(proposition.substring(1, cont - 1))//Caso de disyuncion retorna el valor de verdad de la sub cadena antes del v, operada con el valor de verdad de la cadena después del v
					|| eval(proposition.substring(cont + 2, proposition.length() - 1));
		case "→":
			return !(eval(proposition.substring(1, cont - 1))) //Caso de implicacion retorna el valor de verdad negado de la sub cadena antes del →, operada con disyuncion con el valor de verdad de la cadena después del →
					|| eval(proposition.substring(cont + 2, proposition.length() - 1));
		case "↔":
			return (eval(proposition.substring(1, cont - 1))//Caso de implicacion retorna el valor de verdad de la sub cadena antes del ↔, operada con conjuncion con el valor de verdad de la cadena después del ↔
															//operado con disyuncion con el valor de verdad negado de la sub cadena antes del ↔, operada con conjuncion con el valor de verdad negado de la cadena después del ↔
					&& eval(proposition.substring(cont + 2, proposition.length() - 1)))
					|| (!eval(proposition.substring(1, cont - 1))
							&& !eval(proposition.substring(cont + 2, proposition.length() - 1)));
		default:
			return true;//Caso improbable
		}
	}

	/**
	 * Convierte una formula a su forma normal disyuntiva
	 * @param proposition
	 * @return
	 */
	public String toDNF(String proposition) {
		if (proposition == "p" || proposition == "q" || proposition == "r" || proposition == "s"
				|| proposition == "t") {
			return proposition;
		} else {
			String result = "";
			String first = "";
			String second = "";
			String third = "";
			String fourth = "";
			String fifth = "";

			truthTable(proposition);
			for (int i = 0; i < val.length; i++) {
				if (val[i]) {
					switch (atoms.size()) {
					case 2:
						first = table[i].split(",")[0].equals("1") ? "(p)" : "¬(p)";
						second = table[i].split(",")[1].equals("1") ? "(q)" : "¬(q)";
						result += i == val.length - 1 ? "(" + "(" + first + ")" + "&" + "(" + second + ")" + ")"
								: "(" + "(" + first + ")" + "&" + "(" + second + ")" + ")" + "v";
						break;
					case 3:
						first = table[i].split(",")[0].equals("1") ? "(p)" : "¬(p)";
						second = table[i].split(",")[1].equals("1") ? "(q)" : "¬(q)";
						third = table[i].split(",")[2].equals("1") ? "(r)" : "¬(r)";
						result += i == val.length - 1
								? "(" + "(" + first + ")" + "&" + "(" + second + ")" + "&" + "(" + third + ")" + ")"
								: "(" + "(" + first + ")" + "&" + "(" + second + ")" + "&" + "(" + third + ")" + ")"
										+ "v";
						break;
					case 4:
						first = table[i].split(",")[0].equals("1") ? "(p)" : "¬(p)";
						second = table[i].split(",")[1].equals("1") ? "(q)" : "¬(q)";
						third = table[i].split(",")[2].equals("1") ? "(r)" : "¬(r)";
						fourth = table[i].split(",")[3].equals("1") ? "(s)" : "¬(s)";
						result += i == val.length - 1
								? "(" + "(" + first + ")" + "&" + "(" + second + ")" + "&" + "(" + third + ")" + "&"
										+ "(" + fourth + ")" + ")"
								: "(" + "(" + first + ")" + "&" + "(" + second + ")" + "&" + "(" + third + ")" + "&"
										+ "(" + fourth + ")" + ")" + "v";
						break;
					case 5:
						first = table[i].split(",")[0].equals("1") ? "(p)" : "¬(p)";
						second = table[i].split(",")[1].equals("1") ? "(q)" : "¬(q)";
						third = table[i].split(",")[2].equals("1") ? "(r)" : "¬(r)";
						fourth = table[i].split(",")[3].equals("1") ? "(s)" : "¬(s)";
						fifth = table[i].split(",")[4].equals("1") ? "(t)" : "¬(t)";
						result += i == val.length - 1
								? "(" + "(" + first + ")" + "&" + "(" + second + ")" + "&" + "(" + third + ")" + "&"
										+ "(" + fourth + ")" + "(" + fifth + ")" + ")"
								: "(" + "(" + first + ")" + "&" + "(" + second + ")" + "&" + "(" + third + ")" + "&"
										+ "(" + fourth + ")" + "(" + fifth + ")" + ")" + "v";
						break;
					}
				}
			}
			return result;
		}
	}
}
