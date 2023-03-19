package magacin;

import java.util.ArrayList;
import java.util.List;

import interfejs_magacin.MagacinInterfejs;

public class Magacin implements MagacinInterfejs {

	List<Artikal> artikli = new ArrayList<>();

	@Override
	public void dodajArtikal(Artikal a) {
		if (a == null) {
			throw new NullPointerException("Artikal ne sme imati null vrednost");
		}

		if (!artikli.contains(a)) {
			artikli.add(a);
			a.setKolicina(1);
		} else {
			a.setKolicina(a.getKolicina() + 1);
		}
	}

	@Override
	public void izbaciArtikal(Artikal a) {
		if (a == null) {
			throw new NullPointerException("Artikal ne sme imati null vrednost");
		}
		if (!artikli.contains(a)) {
			throw new IllegalArgumentException("Dati artikal ne postoji u magacinu");
		}
		if (a.getKolicina() == 1) {
			artikli.remove(a);
		}

		a.setKolicina(a.getKolicina() - 1);
	}

	@Override
	public Artikal pronadjiArtikal(int sifra) {
		if (sifra < 0) {
			throw new IllegalArgumentException("Sifra artikla ne sme biti manja od nule");
		}

		for (Artikal ar : artikli) {
			if (ar.getSifra() == sifra) {
				return ar;
			}
		}
		throw new IllegalArgumentException("Ne postoji dati artikal u magacinu");
	}

}
