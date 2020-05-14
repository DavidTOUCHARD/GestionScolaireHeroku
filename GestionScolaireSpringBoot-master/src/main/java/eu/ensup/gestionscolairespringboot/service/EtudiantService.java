package eu.ensup.gestionscolairespringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.CoursRepository;
import eu.ensup.gestionscolairespringboot.dao.DirectionRepository;
import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.dao.PersonneRepository;
import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

public class EtudiantService implements IEtudiantService {

	// On connecte la dao avec l'auto configuration
	@Autowired
	private EtudiantRepository etudiantDAO;
	@Autowired
	private CoursRepository coursDAO;
	@Autowired
	private DirectionRepository directionDAO;
	@Autowired
	private PersonneRepository personneDAO;

	// Constructeur par défault
	public EtudiantService() {
		super();
	}

	public EtudiantService(EtudiantRepository etudiantDAO, CoursRepository coursDAO, DirectionRepository directionDAO,
			PersonneRepository personneDAO) {
		super();
		this.etudiantDAO = etudiantDAO;
		this.coursDAO = coursDAO;
		this.directionDAO = directionDAO;
		this.personneDAO = personneDAO;
	}

	@Override
	public Etudiant saveStudent(Etudiant etu) {
		return etudiantDAO.save(etu);
	}

	@Override
	public List<Etudiant> getAll() {
		return etudiantDAO.findAll();
	}

	@Override
	public Etudiant getById(int id) {
		return etudiantDAO.getOne(id);
	}

	@Override
	public void deleteStudent(Etudiant etudiant) {
		etudiantDAO.delete(etudiant);
	}

	@Override
	public boolean lierCoursEtudiant(Cours cours, Etudiant etudiant) {
		if (etudiantDAO.existsById(etudiant.getId()) && coursDAO.existsById(cours.getIdCours())) {
			etudiantDAO.saveAndFlush(etudiant);
			return true;
		} else return false;

	}

	@Override
	public Direction login(String login, String password) {
		Direction direction = new Direction();
		direction = directionDAO.findByLoginAndPassword(login, password);
		System.out.println("sysout de direction" + direction);
		return direction;
	}

	@Override
	public Etudiant update(Etudiant etu) {
		return etudiantDAO.save(etu);
	}

	public List<Cours> getAllCours() {

		return coursDAO.findAll();

	}

}
