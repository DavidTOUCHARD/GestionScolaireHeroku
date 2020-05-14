package eu.ensup.gestionscolairespringboot.service;

import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.domaine.Personne;

import java.util.List;

public interface IEtudiantService {
<<<<<<< HEAD
    public Personne saveStudent(Etudiant etu);
=======
    public Etudiant saveStudent(Etudiant etu);
>>>>>>> branch 'master' of https://github.com/Le-master-crew/gestionscolairespringboot.git
    public List<Etudiant> getAll();
    public Etudiant getById(int id);
    public void deleteStudent(Etudiant etudiant);
    public boolean lierCoursEtudiant(Cours cours, Etudiant etudiant);
    Direction login(String login, String password);
    public Etudiant update(Etudiant etu);
    public List<Cours> getAllCours();

}