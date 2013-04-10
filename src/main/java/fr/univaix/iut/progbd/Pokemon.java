package fr.univaix.iut.progbd;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Pokemon.FIND_ALL, query = "SELECT p FROM Pokemon p"),
        @NamedQuery(name = Pokemon.FIND_BY_TYPE, query = "SELECT p FROM Pokemon p WHERE p.type1 = :ftype")
})
public class Pokemon {
    public static final String FIND_BY_TYPE = "findPokemonByType";
    public static final String FIND_ALL = "findAllPokemon";
    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type1;

    @Enumerated(EnumType.STRING)
    private Type type2;

    private int baseHP;
    private String attack;
    private int defense;
    private int attackSpecial;
    private int defenseSpecial;
    private int speed;
    private String cri;
    private int xp;
    private int pv;
    private int level; 
    
    
    @ManyToOne
    @JoinColumn(name="OWNER_POKE")
    private Owner owner_poke; 

    protected Pokemon() {

    }
    
    public Owner getOwner_poke() {
		return owner_poke;
	}


	public void setOwner_poke(Owner owner_poke) {
		this.owner_poke = owner_poke;
	}

	
	public Pokemon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type types1) {
        this.type1 = types1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type types2) {
        this.type2 = types2;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttackSpecial() {
        return attackSpecial;
    }

    public void setAttackSpecial(int attackSpecial) {
        this.attackSpecial = attackSpecial;
    }

    public int getDefenseSpecial() {
        return defenseSpecial;
    }

    public void setDefenseSpecial(int defenseSpecial) {
        this.defenseSpecial = defenseSpecial;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;

        Pokemon pokemon = (Pokemon) o;

        if (attack != pokemon.attack) return false;
        if (attackSpecial != pokemon.attackSpecial) return false;
        if (baseHP != pokemon.baseHP) return false;
        if (defense != pokemon.defense) return false;
        if (defenseSpecial != pokemon.defenseSpecial) return false;
        if (speed != pokemon.speed) return false;
        if (name != null ? !name.equals(pokemon.name) : pokemon.name != null) return false;
        if (type1 != pokemon.type1) return false;
        if (type2 != pokemon.type2) return false;
        if (xp != pokemon.xp) return false;
        if (pv != pokemon.pv) return false;
        if (cri != pokemon.cri) return false;
        if (level != pokemon.level) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type1 != null ? type1.hashCode() : 0);
        result = 31 * result + (type2 != null ? type2.hashCode() : 0);
        result = 31 * result + baseHP;
        result = 31 * result + defense;
        result = 31 * result + attackSpecial;
        result = 31 * result + defenseSpecial;
        result = 31 * result + speed;
        result = 31 * result + pv;
        result = 31 * result + xp;
        result = 31 * result + level;
        return result;
    }



	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type1=" + type1 + ", type2="
				+ type2 + ", baseHP=" + baseHP + ", attack=" + attack
				+ ", defense=" + defense + ", attackSpecial=" + attackSpecial
				+ ", defenseSpecial=" + defenseSpecial + ", speed=" + speed
				+ ", cri=" + cri + ", xp=" + xp + ", pv=" + pv + ", level="
				+ level + ", owner_poke=" + owner_poke + "]";
	}

	public String getCri() {
		return cri;
	}

	public void setCri(String cri) {
		this.cri = cri;
	}
}