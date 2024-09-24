package classes;

abstract public class Entity1 {

    //Attributes
    protected int health;
    protected int strength;
    protected int defense;

    Entity1(int newHealth, int newStrength, int newDefense){
        setDefense(newDefense);
        setHealth(newHealth);
        setStrength(newStrength);
    }



    //Methods
    public void takeDamage(int baseAttack, int attackTypePower) {
        // Fórmula: (valor del ataque base del personaje * valor del ataque base del tipo de ataque) / (defensa * 0.4)
        double damage = (baseAttack * attackTypePower) / (defense * 0.4);

        // Redondeo a la alza
        int finalDamage = (int) Math.ceil(damage);

        // Restar el daño a la salud
        health -= finalDamage;

        // Que la salud no baje por debajo de 0
        if (health < 0) {
            health = 0;
        }
    }


    public boolean isDead(){
        return health <= 0;
    }

    public void showHealth(){
        System.out.println("Health: " + getHealth());
    }




    //Setters and Getters

    public void setHealth(int newHealth) {
        if (newHealth > 100) {   //Que los valores de las stats no pasen de 100 (100 es lo maximo)
            health = 100;
        } else {
            health = newHealth;
        }
    }

    public void setDefense(int newDefense) {
        if (newDefense > 100) {
            defense = 100;
        } else {
            defense = newDefense;
        }
    }

    public void setStrength(int newStrength) {
        if (newStrength > 100) {
            strength = 100;
        } else {
            strength = newStrength;
        }
    }

    public int getHealth(){
        return health;
    }

    public int getStrength(){
        return strength;
    }

    public int getDefense(){
        return defense;
    }
}
