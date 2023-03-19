package magacin;

import java.util.ArrayList;
import java.util.List;

import interfejs_magacin.MagacinInterfejs;

public class Magacin implements MagacinInterfejs {

	List<Artikal> artikli = new ArrayList<>();

	@Override
	public void dodajArtikal(Artikal a) {
		if (a == null) {
			return;
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
			return;
		}
		if (!artikli.contains(a)) {
			return;
		}
		if (a.getKolicina() == 0) {
			return;
		}

		a.setKolicina(a.getKolicina() - 1);
	}

	@Override
	public Artikal pronadjiArtikal(int sifra) {
		if (sifra < 0) {
			return null;
		}

		for (Artikal ar : artikli) {
			if (ar.getSifra() == sifra) {
				return ar;
			}
		}
		return null;
	}

}
