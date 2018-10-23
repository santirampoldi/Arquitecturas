package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

		} catch (IOException e) {
			e.printStackTrace();
		}

		return retorno;
	}


	public static void main(String[] args) {

		ArrayList<String>u = reader("src/resources/Usuarios.csv");
		ArrayList<String>t = reader("src/resources/Trabajos.csv");

		Set<Usuario>usuarios = new HashSet<Usuario>();
		Set<Trabajo>trabajos = new HashSet<Trabajo>();

		Lugar lugar = new Lugar(1, "Conicet", "Tandil");
		Tematica tematica1 = new Tematica(1, "Tema1", true);
		Tematica tematica2 = new Tematica(2, "Tema2", false);
		TipoTrabajo tipoTrabajo1 = new TipoTrabajo(1, "Poster");
		TipoTrabajo tipoTrabajo2 = new TipoTrabajo(2, "Articulo");
		TipoTrabajo tipoTrabajo3 = new TipoTrabajo(3, "Poster");

		Set<Tematica>tematicas = new HashSet<Tematica>();
		tematicas.add(tematica1);
		tematicas.add(tematica2);


		for (int i = 0; i < u.size(); i+=3) {
			int dni = Integer.parseInt(u.get(i));
			usuarios.add(new Usuario(dni, u.get(i+1), u.get(i+2), lugar));
		}

		for (int i = 0; i < t.size(); i+=2) {
			int id = Integer.parseInt(t.get(i));
			trabajos.add(new Trabajo(id, t.get(i+1), tipoTrabajo1, usuarios, tematicas));
		}


		LugarDAO lugarDAO = LugarDAO.getInstance();
		TematicaDAO tematicaDAO = TematicaDAO.getInstance();
		TipoTrabajoDAO tipoTrabajoDAO = TipoTrabajoDAO.getInstance();
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		TrabajoDAO trabajoDAO = TrabajoDAO.getInstance();

		tipoTrabajoDAO.persist(tipoTrabajo1);
		tipoTrabajoDAO.persist(tipoTrabajo2);
		tipoTrabajoDAO.persist(tipoTrabajo3);
		lugarDAO.persist(lugar);

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


		System.out.println(lugar.toString());
		System.out.println(tematica1.toString());
		System.out.println(tematica2.toString());
		System.out.println(tipoTrabajo1.toString());

		Iterator<Trabajo> its = trabajos.iterator();

		while (its.hasNext()) {
			Trabajo trabajo = its.next();
			System.out.println(trabajo.toString());
		}
		
		Iterator<Usuario> its2 = usuarios.iterator();

		while (its2.hasNext()) {
			Usuario usuario = its2.next();
			System.out.println(usuario.toString());
		}


		System.out.println("Finalizado");
	}
}
