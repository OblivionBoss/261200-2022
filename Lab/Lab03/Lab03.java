class RPGcharacter {
    private int maxHP,maxMana,level;
    private double maxSpeed,baseSpeed,HP,mana;
    private Sword sword;
    private Shield shield;

    public RPGcharacter(double speed){
        HP = maxHP = 100;
        mana = maxMana = 50;
        level = 0;
        baseSpeed = Math.abs(speed);
        maxSpeed = baseSpeed*(0.1+0.03*level);
    }

    public void levelUp(){
        level++;
        maxHP = 100+10*level;
        maxMana = 50+2*level;
        updateSpeed();
    }

    public void attack(RPGcharacter p){
        if(this.sword==null) return;
        if(p.shield!=null) p.HP -= this.sword.getDamage()-p.shield.getDefense();
        else p.HP -= this.sword.getDamage();
    }

    public void equippedSword(Sword sword){// send null to unequipped sword
        this.sword = sword;
        updateSpeed();
    }

    public void equippedShield(Shield shield){// send null to unequipped shield
        this.shield = shield;
        updateSpeed();
    }

    private void updateSpeed(){
        maxSpeed = baseSpeed*(0.1+0.03*level);
        if(sword!=null) maxSpeed -= baseSpeed*(0.1+0.04*sword.getLevel());
        if(shield!=null) maxSpeed -= baseSpeed*(0.1+0.08*shield.getLevel());
        if(maxSpeed <= 0){
            maxSpeed *= (-1)*Math.pow(2,Math.round(maxSpeed));
        }
    }

    public void printStat(){
        System.out.println("------------------------");
        System.out.println("Character Status");
        System.out.println("------------------------");
        System.out.println("Level : "+level);
        System.out.println("Max HP : "+maxHP+" , HP : "+HP);
        System.out.println("Max Mana : "+maxMana+" , Mana : "+mana);
        System.out.println("Max Speed : "+maxSpeed+" , Base Speed : "+baseSpeed);
        System.out.println("Sword : "+ ((sword==null) ? "Unequipped" : "Equipped"));
        System.out.println("Shield : "+ ((shield==null) ? "Unequipped" : "Equipped"));
        System.out.println("------------------------");
    }
}

class Sword {
    private int level;
    private double damage;

    public Sword(double damage){
        level = 0;
        this.damage = Math.abs(damage);
    }

    public void levelUp(){
        level++;
        damage = damage*(1+0.1*level);
    }

    public double getDamage(){
        return damage;
    }

    public int getLevel(){
        return level;
    }

    public void printStat(){
        System.out.println("------------------------");
        System.out.println("Sword Status");
        System.out.println("------------------------");
        System.out.println("Level : "+level);
        System.out.println("Sword Damage : "+damage);
        System.out.println("------------------------");
    }
}

class Shield {
    private int level;
    private double defense;

    public Shield(double defense){
        level = 0;
        this.defense = Math.abs(defense);
    }

    public void levelUp(){
        level++;
        defense = defense*(1+0.05*level);
    }

    public double getDefense(){
        return defense;
    }

    public int getLevel(){
        return level;
    }

    public void printStat(){
        System.out.println("------------------------");
        System.out.println("Shield Status");
        System.out.println("------------------------");
        System.out.println("Level : "+level);
        System.out.println("Shield Defense : "+defense);
        System.out.println("------------------------");
    }
}
public class Lab03 {
    public static void main(String[] args) {
        RPGcharacter player1 = new RPGcharacter(10);
        RPGcharacter player2 = new RPGcharacter(50);
        player1.levelUp();
        player2.levelUp();
        player2.levelUp();
        Sword s = new Sword(10);
        Shield q = new Shield(3);
        s.levelUp();
        player1.equippedSword(s);
        player1.equippedShield(q);
        player2.equippedShield(q);
        player1.attack(player2);
        player1.printStat();
        player2.printStat();
        s.printStat();
        q.printStat();
        player1.equippedSword(null);
        player1.equippedShield(null);
        player1.printStat();
        player2.printStat();
    }
}
