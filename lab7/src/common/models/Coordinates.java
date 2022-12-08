package common.models;


import java.io.Serializable;

public class Coordinates implements Serializable {
    private Float x; //Максимальное значение поля: 893, Поле не может быть null
    private Integer y; //Поле не может быть null

    /**
     * Пустой конструктор
     */
    public Coordinates() {
    }

    /**
     * конструктор класса coordinates
     * @param x координата x
     * @param y координата y
     */
    public Coordinates(Float x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает значение координаты x
     * @return
     */
    public Float getX() {
        return x;
    }

    /**
     * Задает значение координаты x
     * @param x координата x
     */
    public void setX(Float x) {
        this.x = x;
    }

    /**
     * возвращает значение координаты y
     * @return
     */
    public Integer getY() {
        return y;
    }

    /**
     * Задает значение координаты y
     * @param y координата y
     */
    public void setY(Integer y) {
        this.y = y;
    }

}