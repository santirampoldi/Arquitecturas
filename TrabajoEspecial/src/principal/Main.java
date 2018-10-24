package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

		ArrayList<String>u = reader("src/resources/Usuarios.csv");
		ArrayList<String>t = reader("src/resources/Trabajos.csv");

		Set<Usuario>usuarios = new HashSet<Usuario>();
		Set<Trabajo>trabajos = new HashSet<Trabajo>();
		Set<Lugar>lugares = new HashSet<Lugar>();

		Tematica tematica1 = new Tematica("Tema1", true);
		Tematica tematica2 = new Tematica("Tema2", false);
		TipoTrabajo tipoTrabajo1 = new TipoTrabajo("Poster");
		TipoTrabajo tipoTrabajo2 = new TipoTrabajo("Articulo");
		TipoTrabajo tipoTrabajo3 = new TipoTrabajo("Poster");

		Set<Tematica>tematicas = new HashSet<Tematica>();
		tematicas.add(tematica1);
		tematicas.add(tematica2);


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

		for (int i = 0; i < t.size(); i++) {
			trabajos.add(new Trabajo(t.get(i), tipoTrabajo1, usuarios, tematicas));
		}


		LugarDAO lugarDAO = LugarDAO.getInstance();
		TematicaDAO tematicaDAO = TematicaDAO.getInstance();
		TipoTrabajoDAO tipoTrabajoDAO = TipoTrabajoDAO.getInstance();
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		TrabajoDAO trabajoDAO = TrabajoDAO.getInstance();

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

		System.out.println("Finalizado");


		Iterator<Trabajo> itevaluadores = trabajos.iterator();
		Set<Usuario> evaluadores = trabajoDAO.evaluadoresAsignables(itevaluadores.next());

		Iterator<Usuario> itevaluadores2 = evaluadores.iterator();

		while (itevaluadores2.hasNext()) {
			Usuario usuario = (Usuario) itevaluadores2.next();
			System.out.println(usuario.toString());
		}


//		List<Trabajo>query = usuarioDAO.findAllTrabajosEnEvaluacion(1);
//		for (int i = 0; i < query.size(); i++) {
//			System.out.println(query.get(i).toString());
//		}

	}
}
