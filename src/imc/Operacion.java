package imc;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Operacion {
	ArrayList<String> nombres = new ArrayList<>();
	ArrayList<Double> tallas = new ArrayList<>();
	ArrayList<Double> pesos = new ArrayList<>();
	ArrayList<Integer> edades = new ArrayList<>();
	ArrayList<String> telefonos = new ArrayList<>();
	ArrayList<Double> imc = new ArrayList<>();
	ArrayList<String> diagnostico = new ArrayList<>();

	public Operacion() {
		iniciar();
	}

	public void iniciar() {
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(
					"MENU PRINCIPAL\n\n" + "1) " + "Registrar otra personas\n" + "2) " + " Imprimir lista\n" + "3) "
							+ " Consulta individual\n" + "4) " + " Eliminar persona\n" + "5) " + " Actualizar\n" + "6) "
							+ " Limpiar lista\n" + "7) " + " Salir\n\n" + "***SELECCIONE UNA OPCION***\n\n"));
			menu(op);
		} while (op != 7);
	}

	public void menu(int op) {
		switch (op) {
		case 1:
			RegistraOtraPersona();

			break;
		case 2:
			if (nombres.size() == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				imprimrLista();
			}
			break;
		case 3:
			if (nombres.size() == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				imprimirIndividual();
			}
			break;
		case 4:
			if (nombres.size() == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				eliminarPersona();
			}
			break;
		case 5:
			if (nombres.size() == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				actualizar();
			}
			break;
		case 6:
			if (nombres.size() == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				limpiarLista();
			}
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "SALIR");
			break;
		default:
			break;
		}
	}

	public void RegistraOtraPersona() {
		String nombre = JOptionPane.showInputDialog("NOMBRE");
		;
		int edad = Integer.parseInt(JOptionPane.showInputDialog("EDAD"));
		double peso = Double.parseDouble(JOptionPane.showInputDialog("PESO"));
		double talla = Double.parseDouble(JOptionPane.showInputDialog("ESTATURA"));
		String telefono = JOptionPane.showInputDialog("TELEFONO");
		nombres.add(nombre);
		edades.add(edad);
		telefonos.add(telefono);
		pesos.add(peso);
		tallas.add(talla);
	}

	public void imprimrLista() {
		System.out.println("*****LISTA*****");
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println("NOMBRE : " + nombres.get(i) + "\nEdad : " + edades.get(i) + "\nTelefono : "
					+ telefonos.get(i) + "\nPeso : " + pesos.get(i) + "\nEstatura : " + tallas.get(i));
			System.out.println("-------------------\n");
		}
	}



	public void eliminarPersona() {
		String nombre = JOptionPane.showInputDialog("ingrese el usuario a eliminar");
		int conta = 0;
		for (int i = 0; i < nombres.size(); i++) {
			if (nombres.get(i).equalsIgnoreCase(nombre)) {
				nombres.remove(i);
				JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
				conta++;
			}
		}
		if (conta == 0) {
			JOptionPane.showMessageDialog(null, "VALOR NO EXISTE");
		}

	}

	public void actualizar() {
		String actaul = JOptionPane.showInputDialog("ingresa el nombre para actualizar datos");
		for (int i = 0; i < nombres.size(); i++) {
			if (nombres.get(i).equalsIgnoreCase(actaul)) {
				JOptionPane.showMessageDialog(null, "ingrese valores a actualizar");
				int edad = Integer.parseInt(JOptionPane.showInputDialog("EDAD"));
				double peso = Double.parseDouble(JOptionPane.showInputDialog("PESO"));
				double talla = Double.parseDouble(JOptionPane.showInputDialog("ESTATURA"));
				String telefono = JOptionPane.showInputDialog("TELEFONO");
				edades.set(i, edad);
				pesos.set(i, peso);
				tallas.set(i, talla);
				telefonos.set(i, telefono);
			}

		}
	}

	public void limpiarLista() {
		nombres.clear();
		pesos.clear();
		imc.clear();
		tallas.clear();
		telefonos.clear();
		edades.clear();
	}
	public void imprimirIndividual() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario: ");
		String diagnostico = "";
		boolean encontrado = false;
		for (int i = 0; i < nombres.size(); i++) {
			if (nombres.get(i).equalsIgnoreCase(nombre)) {
				double imc = pesos.get(i) / Math.pow(tallas.get(i), 2);

				if (imc < 18) {
					diagnostico = "ANOREXIA";
				} else if (imc >= 18 && imc <= 20) {
					diagnostico = "DELGADES";
				} else if (imc >= 20 && imc < 25) {
					diagnostico = "NORMAL";
				} else if (imc >= 25 && imc <= 30) {
					diagnostico = "OBECIDAD GRADO1";
				} else if (imc >= 30 && imc < 35) {
					diagnostico = "OBECIDAD GRADO 2";
				} else if (imc >= 35 && imc < 40) {
					diagnostico = "OBECIDAD GRADO 3";
				}else if (imc >= 40) {
					diagnostico = "OBECIDAD MORFIDA";
				}
				JOptionPane.showMessageDialog(null,
						"Nombre: " + nombres.get(i) + "\nEdad: " + edades.get(i) + "\nTeléfono: " + telefonos.get(i)
								+ "\nPeso: " + pesos.get(i) + " kg" + "\nTalla: " + tallas.get(i) + " m" + "\nIMC: "
								+ imc + "\nDiagnóstico: " + diagnostico);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
		}
	}

}
