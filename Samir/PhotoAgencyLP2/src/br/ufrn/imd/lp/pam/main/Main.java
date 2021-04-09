package br.ufrn.imd.lp.pam.main;

import br.ufrn.imd.lp.pam.dao.AgencyDao;
import br.ufrn.imd.lp.pam.domain.Agency;
import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.Person;
import br.ufrn.imd.lp.pam.domain.PhotoPack;
import br.ufrn.imd.lp.pam.domain.Photographer;
import br.ufrn.imd.lp.pam.domain.Tour;

public class Main {

	public static void main(String[] args) {

		Agency samirFotografia = new Agency();
		AgencyDao agencyDao = new AgencyDao();

		Person leticia = new Person("Leticia", "84999302642");
		Person denis = new Person("Denis", "84997054647");
		Person gabriel = new Person("Gabriel", "84999541441");
		Person henrique = new Person("Henrique", "84999440100");
		Person will = new Person("Will", "84996502323");

		Photographer samir = new Photographer("Samir", "84999115333");
		Photographer cephas = new Photographer("Cephas", "84988734992");

		PhotoPack pack1 = new PhotoPack("Pack 1", 7, "Uma unidade");
		PhotoPack pack2 = new PhotoPack("Pack 2", 40, "10 fotos digitais");
		PhotoPack pack3 = new PhotoPack("Pack 3", 50, "15 fotos digitais");
		PhotoPack pack4 = new PhotoPack("Pack 4", 150, "20 fotos digitais + Quadro 40x60 + 5 fotos impressas");

		Tour pedraDaBoca = new Tour();
		Tour ponteNewton = new Tour();
		Tour picoCabugi = new Tour();
		Tour monteGameleiras = new Tour();

		Order order1 = new Order(leticia, samir, pedraDaBoca, pack1);
		Order order2 = new Order(denis, samir, pedraDaBoca, pack2);
		Order order3 = new Order(gabriel, cephas, picoCabugi, pack3);
		Order order4 = new Order(henrique, cephas, monteGameleiras, pack4);
		Order order5 = new Order(will, cephas, monteGameleiras, pack2);

		pedraDaBoca.getClients().add(leticia);
		pedraDaBoca.getClients().add(denis);
		picoCabugi.getClients().add(gabriel);
		monteGameleiras.getClients().add(henrique);
		monteGameleiras.getClients().add(will);

		pedraDaBoca.getOrders().add(order1);
		pedraDaBoca.getOrders().add(order2);
		picoCabugi.getOrders().add(order3);
		monteGameleiras.getOrders().add(order4);
		monteGameleiras.getOrders().add(order5);

		samir.getTours().add(pedraDaBoca);
		samir.getTours().add(ponteNewton);
		cephas.getTours().add(picoCabugi);
		cephas.getTours().add(monteGameleiras);

		samirFotografia.getPhotographers().add(samir);
		samirFotografia.getPhotographers().add(cephas);

		samirFotografia.getPhotoPacks().add(pack1);
		samirFotografia.getPhotoPacks().add(pack2);
		samirFotografia.getPhotoPacks().add(pack3);
		samirFotografia.getPhotoPacks().add(pack4);

		agencyDao.addAgency(samirFotografia);

	}

}
