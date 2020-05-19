package educacionit.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.bcrypt.*;

import educacionit.jpa.dao.PersonaDAO;
import educacionit.jpa.dao.PersonaDAOImpl;
import educacionit.jpa.dao.ProductoDAO;
import educacionit.jpa.entidades.Persona;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	PersonaDAO dao;

	@Autowired
	ProductoDAO productoDao;

	@Autowired
	PersonaDAOImpl daoImpl;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// List<Persona> personas = daoImpl.findMayorDeEdad();
//		  Long respuesta = daoImpl.cuantasPersonasHay();
//		  System.out.println(respuesta);

		// List<Persona> personas = dao.findByPhone(111);
//		  for (Persona persona : personas) {
//			System.out.println(persona);
//		}

//		  List<Persona> personas = dao.findAll();
//		  for (Persona persona : personas) {
//			System.out.println(persona);
//		}

		Persona p = new Persona();
		p.setNombre("Estudio1");
		String ape = BCrypt.hashpw("Suarez", BCrypt.gensalt());
		p.setApellido(ape);

		p.setEdad(22);

//		  Telefono t = new Telefono();
//		  t.setNumero(111);
//		  t.setTipo("Celu");
//		  p.addTelefono(t);
		dao.save(p);

		// dao.findByName("Pepe").forEach((persona)->System.out.println(persona.getApellido()));
		// daoImpl.cuantasPersonasHay();
//		 List<Persona> personas = daoImpl.findByName("Pepe");
//		 for (Persona persona : personas) {
//			System.out.println(persona.getNombre() + ", " + persona.getApellido());
//			System.out.println(persona.getTelefonos().get(0).getNumero());
//		}

//		 Persona p = dao.findById(1).get();
//		 System.out.println(p.getApellido());

//		 List personas =  dao.findAll();
//		 System.out.println(personas.size());

//		 List apellidos = daoImpl.getAllApellidosMayuscula();
//		 for (Object object : apellidos) {
//			System.out.println(object);
//		}

//		  List<PersonaDTO> lista = daoImpl.getPersonaDTO();
//		  for (PersonaDTO personaDTO : lista) {
//			System.out.println(personaDTO.getNombre() + ", " + personaDTO.getNumero());
//		}
//		  

		List<Persona> lisPersonas = daoImpl.findByEdad(22);
		Persona pbd = lisPersonas.get(0);
		
		if (BCrypt.checkpw("Suarez", pbd.getApellido())) {
			System.out.println("FUNCIONA!!!!");			
		}
		
		/*
		 * for (Persona persona : personas) { System.out.println(persona.getApellido());
		 * }
		 */
//		  Producto producto = new Producto();
//		  producto.setDescripcion("Algo");
//		  producto.setFechaAlta(new Date());
//		  producto.setPrecio(20.4);
//		  
//		  dao.save(producto);
//		
//		  
//		  dao.findAll().forEach((p)->System.out.println(p.getDescripcion()));
	}

}
