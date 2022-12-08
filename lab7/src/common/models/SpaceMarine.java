package common.models;


import java.io.Serializable;
import java.util.Date;


public class SpaceMarine implements Serializable {
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле не может быть null, Значение поля должно быть больше 0
    private Long heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private Weapon weaponType; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null
    private String author;
    /**
     * Пустой конструктор класса spaceMarine
     */
    public SpaceMarine(){}

    public SpaceMarine (Long id, String name, Float coordinateX, Integer coordinateY, Long creationDate, Float health, Long heartCount, String weapon, String meleeWeapon, String chapterName, String parentLegion, String author){
        this(name,coordinateX,coordinateY,creationDate, health, heartCount, weapon, meleeWeapon, chapterName, parentLegion, author);
        this.id = id;
    }

    public SpaceMarine (String name, Float coordinateX, Integer coordinateY, Long creationDate, Float health, Long heartCount, String weapon, String meleeWeapon, String chapterName, String parentLegion, String author){
        this.name = name;
        this.coordinates = new Coordinates(coordinateX, coordinateY);
        this.creationDate = new Date(creationDate);
        this.health = health;
        this.heartCount = heartCount;
        this.weaponType = weapon == null ? null : Weapon.valueOf(weapon);
        this.meleeWeapon = meleeWeapon == null ? null : MeleeWeapon.valueOf(meleeWeapon);
        if(chapterName != null){
            this.chapter = new Chapter(chapterName,parentLegion);
        }
        this.author = author;
    }

    /**
     * Возвращает значение id
     */
    public long getId(){
        return id;
    }
    /**
     * Возвращает имя
     */
    public String getName(){
        return name;
    }

    /**
     * Возвращает координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * возвращает дату создания
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * возвращает здоровье
     */
    public Float getHealth() {
        return health;
    }

    /**
     * возвращает количество сердец
     */
    public Long getHeartCount() {
        return heartCount;
    }

    /**
     * возвращает оружие
     */
    public Weapon getWeapon() {
        return weaponType;
    }

    /**
     * возвращает оружие ближнего боя
     */
    public MeleeWeapon getMeleeWeapon(){
        return meleeWeapon;
    }

    /**
     * возвращает главу
     */
    public Chapter getChapter() {
        return chapter;
    }

    /**
     * задает значение chapter
     * @param chapter глава
     */
    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
    /**
     * задает значение name
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * задает значение health
     * @param health здоровье
     */
    public void setHealth(Float health) {
        this.health = health;
    }
    /**
     * задает значение heartCount
     * @param heartCount количество сердец
     */
    public void setHeartCount(Long heartCount) {
        this.heartCount = heartCount;
    }
    /**
     * задает значение Weapon
     * @param weaponType оружие
     */
    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }
    /**
     * задает значение meleeWeapon
     * @param meleeWeapon оружие ближнего боя
     */
    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }
    /**
     * задает значение coordinates
     * @param coordinates координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate == null) {
            creationDate = new Date();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

}