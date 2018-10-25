package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dao.*;
import entidades.*;


public class Main {


	private static ArrayList<String> reader(String src){

		ArrayList<String> retorno = new ArrayList<String>();

		String csvFile = src;
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){			
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] items = line.split(",");
				for (int i = 0; i < items.length; i++) {
					retorno.add(items[i]);
				}
			}
		} catch (IOException e) { e.printStackTrace(); }
		return retorno;
	}


	public static void main(String[] args) {

		//		---------------------Item A---------------------	

		ArrayList<String>u = reader("src/resources/Usuarios.csv");
		ArrayList<String>t = reader("src/resources/Trabajos.csv");

		Set<Usuario>usuarios = new HashSet<Usuario>();
		Set<Trabajo>trabajos = new HashSet<Trabajo>();
		Set<Lugar>lugares = new HashSet<Lugar>();

		Tematica tematica1 = new Tematica("Tema1", true);
		Tematica tematica2 = new Tematica("Tema2", false);
		TipoTrabajo tipoTrabajo1 = new TipoTrabajo("Poster");
		TipoTrabajo tipoTrabajo2 = new TipoTrabajo("Articulo");
		TipoTrabajo tipoTrabajo3 = new TipoTrabajo("Resumen");

		Set<Tematica>tematicas = new HashSet<Tematica>();
		tematicas.add(tematica1);
		tematicas.add(tematica2);


		//		---------------------Item B---------------------

		for (int i = 0; i < u.size(); i+=5) {
			Lugar lugarTemp = new Lugar(u.get(i+3), u.get(i+4));
			Iterator<Lugar> itlugar = lugares.iterator();
			Boolean existe = false;
			while (itlugar.hasNext()) {
				Lugar lugar = (Lugar) itlugar.next();
				if (lugar.equals(lugarTemp)) {
					lugarTemp = lugar;
					existe = true;
					break;
				}
			}
			if (existe == false) {
				lugares.add(lugarTemp);
			}
			int dni = Integer.parseInt(u.get(i));
			usuarios.add(new Usuario(dni, u.get(i+1), u.get(i+2), lugarTemp));
		}


		//		---------------------Item C---------------------

		for (int i = 0; i < t.size(); i++) {
			trabajos.add(new Trabajo(t.get(i), tipoTrabajo1, usuarios, tematicas));
		}


		LugarDAO lugarDAO = LugarDAO.getInstance();
		TematicaDAO tematicaDAO = TematicaDAO.getInstance();
		TipoTrabajoDAO tipoTrabajoDAO = TipoTrabajoDAO.getInstance();
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		TrabajoDAO trabajoDAO = TrabajoDAO.getInstance();
		EvaluacionDAO evaluacionDAO = EvaluacionDAO.getInstance();

		tipoTrabajoDAO.persist(tipoTrabajo1);
		tipoTrabajoDAO.persist(tipoTrabajo2);
		tipoTrabajoDAO.persist(tipoTrabajo3);


		Iterator<Lugar> itlugares = lugares.iterator();

		while (itlugares.hasNext()) {
			Lugar lugar = (Lugar) itlugares.next();
			lugarDAO.persist(lugar);
		}

		Iterator<Usuario> itp2 = usuarios.iterator();

		while (itp2.hasNext()) {
			Usuario usuario = itp2.next();
			usuarioDAO.persist(usuario);
		}

		tematicaDAO.persist(tematica1);
		tematicaDAO.persist(tematica2);

		Iterator<Trabajo> itp = trabajos.iterator();

		while (itp.hasNext()) {
			Trabajo trabajo = itp.next();
			trabajoDAO.persist(trabajo);
		}

		System.out.println("Finalizada creacion de la BBDD");

		//		----------------Mostrar datos de un usuario(Item D.i)----------------

		//		Usuario usu = usuarioDAO.findById(1);
		//		System.out.println(usu.toString());


		//		----------------Verificar trabajos asignados(Item D.ii)----------------

		//		Trabajo tra1 = new Trabajo("PythonAceptado", tipoTrabajo1);
		//		Trabajo tra2 = new Trabajo("PythonPostergado", tipoTrabajo1);
		//		Usuario usu = new Usuario(202, "Santiago", "Rampoldi", lugares.iterator().next());
		//		usu.setTrabajoEvaluacion(tra1);
		//		usu.setTrabajoPendiente(tra2);
		//		trabajoDAO.persist(tra1);
		//		trabajoDAO.persist(tra2);
		//		usuarioDAO.persist(usu);
		//		List<Trabajo> resultado = usuarioDAO.findAllTrabajosAsignados(202);
		//		for (int i = 0; i < resultado.size(); i++) {
		//			System.out.println(resultado.get(i).getNombre());
		//		}


		//		----------------Verificar revisiones en rango de fecha(Item D.iii)----------------

		//		Trabajo tra = new Trabajo("PythonEnRango", tipoTrabajo1);
		//		Usuario usu = new Usuario(203, "Santiago", "Rampoldi", lugares.iterator().next());
		//		trabajoDAO.persist(tra);
		//		usuarioDAO.persist(usu);
		//		Evaluacion e = new Evaluacion(tra, usu, "Buen trabajo");
		//		Calendar fecha = Calendar.getInstance();
		//		fecha.set(2017, 3, 1);
		//		//e.setFecha(fecha); Esta linea cambia la fecha para que quede fuera del rango
		//		evaluacionDAO.persist(e);
		//		Calendar desde = Calendar.getInstance();
		//		desde.set(2018, 0, 1);
		//		Calendar hasta = Calendar.getInstance();
		//		hasta.set(2018, 11, 31);
		//
		//		List<Trabajo> resultado = usuarioDAO.findAllTrabajosInvestigacionEnRango(203, desde, hasta);
		//		for (int i = 0; i < resultado.size(); i++) {
		//			System.out.println(resultado.get(i).getNombre());
		//		}


		//		----------------Verificar trabajos enviados de autor(Item D.iv)----------------

		//		Trabajo tra = new Trabajo("PythonEscrito", tipoTrabajo1);
		//		Usuario usu = new Usuario(204, "Santiago", "Rampoldi", lugares.iterator().next());
		//		usu.setTrabajoInvestigacion(tra);
		//		trabajoDAO.persist(tra);
		//		usuarioDAO.persist(usu);
		//		List<Trabajo> resultado = usuarioDAO.findAllTrabajosEnviados(202);
		//		for (int i = 0; i < resultado.size(); i++) {
		//			System.out.println(resultado.get(i).getNombre());
		//		}


		//		----------------Verificar si un usuario es experto----------------

		//		Usuario usu = new Usuario(200, "Santiago", "Rampoldi", lugares.iterator().next());
		//		usu.setTema(tematica1);
		//		usu.setTema(tematica2);
		//		usuarioDAO.persist(usu);
		//		System.out.println(usuarioDAO.esExperto(usu.getDni()));


		//		----------------Verificar los evaluadores asignables a un trabajo----------------

		//		Iterator<Trabajo> itevaluadores = trabajos.iterator();
		//		Set<Usuario> evaluadores = trabajoDAO.evaluadoresAsignables(itevaluadores.next());
		//		Iterator<Usuario> itevaluadores2 = evaluadores.iterator();
		//		while (itevaluadores2.hasNext()) {
		//			Usuario usuario = (Usuario) itevaluadores2.next();
		//			System.out.println(usuario.toString());
		//		}



	}
}
