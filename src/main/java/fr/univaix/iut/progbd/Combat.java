package fr.univaix.iut.progbd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
        @NamedQuery(name = Combat.FIND_ALL, query = "SELECT c FROM Combat c")
})
public class Combat {
    public int getNumC() {
		return numC;
	}

	public void setNumC(int numC) {
		this.numC = numC;
	}

	public static final String FIND_ALL = "findAllCombat";
    @Id
    private int numC;
    
    @OneToMany
    private Pokemon Pokemon1;
    private Pokemon Pokemon2;
    private Pokemon Winner;

    protected Combat() {

    }

	public Pokemon getPokemon1() {
		return Pokemon1;
	}

	public void setPokemon1(Pokemon pokemon1) {
		Pokemon1 = pokemon1;
	}

	public Pokemon getPokemon2() {
		return Pokemon2;
	}

	public void setPokemon2(Pokemon pokemon2) {
		Pokemon2 = pokemon2;
	}

	public Pokemon getWinner() {
		return Winner;
	}

	public void setWinner(Pokemon winner) {
		Winner = winner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Pokemon1 == null) ? 0 : Pokemon1.hashCode());
		result = prime * result
				+ ((Pokemon2 == null) ? 0 : Pokemon2.hashCode());
		result = prime * result + ((Winner == null) ? 0 : Winner.hashCode());
		result = prime * result + numC;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combat other = (Combat) obj;
		if (Pokemon1 == null) {
			if (other.Pokemon1 != null)
				return false;
		} else if (!Pokemon1.equals(other.Pokemon1))
			return false;
		if (Pokemon2 == null) {
			if (other.Pokemon2 != null)
				return false;
		} else if (!Pokemon2.equals(other.Pokemon2))
			return false;
		if (Winner == null) {
			if (other.Winner != null)
				return false;
		} else if (!Winner.equals(other.Winner))
			return false;
		if (numC != other.numC)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Combat [numC=" + numC + ", Pokemon1=" + Pokemon1
				+ ", Pokemon2=" + Pokemon2 + ", Winner=" + Winner + "]";
	}
}