package com.howtodoinjava.hibernate.test.dto;
import com.howtodoinjava.hibernate.test.HibernateUtil;
import org.hibernate.Session;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do{
            System.out.println("optiunea 1 adauga Elev\n" +
                    "optiunea 2 adauga profesor\n" +
                    "optiunea 3 adauga Clasa\n" +
                    "Optiuena 4 modifica elev dupa nume si prenume\n" +
                    "Optiuena 5 modifica profesor dupa nume  si prenume\n" +
                    "Optiunea 6 afisare toti elevii din clasa\n" +
                    "Optiunea 7 afisare tuturor profesorilor\n" +
                    "Optiunea 8 afisare  toti elevi care au media > 7\n" +
                    "optiunea 9 afisare toate clasele\n" +
                    "optiunea 0 exit");
            option= scanner.nextInt();

            switch (option){
                case 1:
                    Elev elev = new Elev();
                    System.out.println("Introdu Nume Elev: ");
                    scanner.nextLine();
                    String numeElev = scanner.nextLine();
                    System.out.println("Introdu Prenume Elev: ");
                    String prenumeElev = scanner.nextLine();
                    System.out.println("Introdu medie Elev: ");
                    double medie = scanner.nextDouble();
                    elev.setNume(numeElev);
                    elev.setPrenume(prenumeElev);
                    elev.setMedie(medie);
                    ElevDAO elevDAO = new ElevDAO();
                    elevDAO.insertorupdateElevi(elev,session);
                    break;

                case 2:
                    Profesor profesor = new Profesor();
                    System.out.println("Introdu Nume profesor: ");
                    scanner.nextLine();
                    String numeProfesor = scanner.nextLine();
                    System.out.println("Introdu Prenume profesor: ");
                    String prenumeProfesor = scanner.nextLine();
                    profesor.setNume(numeProfesor);
                    profesor.setPrenume(prenumeProfesor);
                    ProfesorDAO profesorDAO = new ProfesorDAO();
                    profesorDAO.insertOrUpdateProfesori(profesor,session);
                    break;

                case 3:
                    Clasa clasa = new Clasa();
                    System.out.println("Introdu Nume clasa: ");
                    scanner.nextLine();
                    String numeClasa = scanner.nextLine();
                    clasa.setNumeClasa(numeClasa);
                    ClasaDAO clasaDAO = new ClasaDAO();
                    clasaDAO.insertORUpdateClasa(clasa,session);
                    break;

                case 4:
                    ElevDAO elevDAO1 = new ElevDAO();
                    System.out.println("Introdu nume elev:");
                    scanner.nextLine();
                    String numeE = scanner.nextLine();
                    System.out.println("Introdu prenume elev:");
                    String prenumeE = scanner.nextLine();
                    Elev elevE = elevDAO1.findbynameandsurname(numeE,prenumeE,session);
                    if(elevE != null){
                        System.out.println("Introdu medie noua:");
                        double mediaNoua = scanner.nextDouble();
                        elevE.setMedie(mediaNoua);
                        elevDAO1.insertorupdateElevi(elevE,session);
                    }else{
                        System.out.println("Elevul nu exista in baza de date");
                    }
                    break;

                case 5:
                    ProfesorDAO profesorDAO1 = new ProfesorDAO();
                    System.out.println("Introdu nume profesor:");
                    scanner.nextLine();
                    String numePro = scanner.nextLine();
                    System.out.println("Introdu prenume profesor");
                    String prenumePro = scanner.nextLine();
                    Profesor profesor1 = profesorDAO1.findByNameAndSurname(numePro,prenumePro,session);
                    if(profesor1 != null){
                        System.out.println("Introdu materie noua:");
                        String materieNoua = scanner.nextLine();
                        profesor1.setMaterie(materieNoua);
                        profesorDAO1.insertOrUpdateProfesori(profesor1,session);
                    }else{
                        System.out.println("Profesorul nu exista in baza de date");
                    }
                    break;

                case  6:
                    ElevDAO elevAfisare = new ElevDAO();
                    System.out.println(elevAfisare.showElevi(session));
                    break;


                case 7:
                    ProfesorDAO afisareProfesori = new ProfesorDAO();
                    System.out.println(afisareProfesori.printProfesori(session));
                    break;


                case 8:
                    ElevDAO medieElevPeste = new ElevDAO();
                    System.out.println("Introdu media:");
                    scanner.nextLine();
                    double alegereMedie = scanner.nextDouble();
                    System.out.println(medieElevPeste.overAverage(alegereMedie,session));
                    break;



                case 9:
                    ClasaDAO afisareClase = new ClasaDAO();
                    System.out.println( afisareClase.printClasa(session));
                    break;


                case 10:
                    ClasaDAO clasa1 = new ClasaDAO();
                    ProfesorDAO profesorDAO2 = new ProfesorDAO();
                    scanner.nextLine();
                    System.out.println("Introdu nume clasa:");
                    String numeClasa1 = scanner.nextLine();
                    System.out.println("Introdu nume profesor");
                    String numeProfesor1 = scanner.nextLine();
                    System.out.println("Introdu prenume profesor");
                    String prenumeProfesor1 = scanner.nextLine();

                    System.out.println(clasa1.findByName(numeClasa1,session));
                    System.out.println(profesorDAO2.findByNameAndSurname(numeProfesor1,prenumeProfesor1,session));
                    break;

            }
        }while(option != 0);

        HibernateUtil.shutdown();
    }
}

//numele clasei returneaza clasa
//se da numele profesorului; se returneaza profesorul

//12. la fel cu levi si clase
// 13.care este clasa care are cei mai multi elevi
//14. cati profi sunt de matematica
//15. elevul cu cea mai mica medie si in ce clasa se gaseste si ce prof are

//lectia 5 = 2 si 4 din zip-ul lui George
// lectia 6 - ex 4 si 5
// lectia 7 - ex 4 si 3
//lectia 8 - ex 4
//lectia 10 - ex 3







