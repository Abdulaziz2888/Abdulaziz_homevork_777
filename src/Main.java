// Шаг 1: Создать интерфейс HavingSuperAbility
interface HavingSuperAbility {
    void applySuperAbility();
}

// Шаг 2: Создать абстрактный класс Hero с полями здоровье, урон и тип суперспособности и реализовать интерфейс HavingSuperAbility
abstract class Hero implements HavingSuperAbility {
    int health;
    int damage;
    String superAbilityType;

    public Hero(int health, int damage, String superAbilityType) {
        this.health = health;
        this.damage = damage;
        this.superAbilityType = superAbilityType;
    }
}

// Шаг 3: Создать 3 класса героев Magic, Medic, Warrior и наследовать их от класса Hero. Реализовать метод applySuperAbility()
class Magic extends Hero {
    public Magic(int health, int damage, String superAbilityType) {
        super(health, damage, superAbilityType);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Magic применил суперспособность " + superAbilityType);
    }
}

class Medic extends Hero {
    int healPoints;

    public Medic(int health, int damage, String superAbilityType, int healPoints) {
        super(health, damage, superAbilityType);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Medic применил суперспособность " + superAbilityType);
    }

    // Шаг 5: Добавить метод increaseExperience()
    public void increaseExperience() {
        healPoints += healPoints * 0.1; // Увеличить количество единиц лечения на 10%
    }
}

class Warrior extends Hero {
    public Warrior(int health, int damage, String superAbilityType) {
        super(health, damage, superAbilityType);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Warrior применил суперспособность " + superAbilityType);
    }
}

// Шаг 4: В классе Main создать массив из 3х разных героев, затем через цикл применить суперспособность каждого героя
public class Main {
    public static void main(String[] args) {
        // Создать массив из 3х разных героев
        Hero[] heroes = {
                new Magic(100, 20, "INVISIBILITY"),
                new Medic(120, 15, "HEAL", 50),
                new Warrior(150, 25, "CRITICAL DAMAGE")
        };

        // Через цикл применить суперспособность каждого героя
        for (Hero hero : heroes) {
            hero.applySuperAbility();

            // Шаг 6: Увеличить опыт лечения медика
            if (hero instanceof Medic) {
                ((Medic) hero).increaseExperience();
            }
        }
    }
}
