package lab4;


import lab4.Moments.Moment;
import lab4.News.Bulletens;
import lab4.News.NewsPapers;
import lab4.Places.*;
import lab4.people.*;

public class Main {
    public static void main(String[] args) {
        try{
            Moment EveryMoments = new Moment("Каждый момент полета", "Врезался в память","Изменил мою жизнь");
            PeaceAndQuiet peaceAndQuiet = new PeaceAndQuiet();
            Phantoms phantoms = new Phantoms("Фантомы","таящиеся", "в глубинах мира");
            We we = new We("Мы", "неотрывно следили",phantoms);
            Mine mine = new Mine("Шахта");
            Lake lake = new Lake("Лэйк", "пробурил", mine, "три дня назад");
            Airplane airplane = new Airplane("Самолет","летел со значительной скоростью");
            Flight flight = new Flight("Беспосадочный перелет");
            UpperAtmosphere upperAtmosphere = new UpperAtmosphere("Верхние слои атмосферы");
            GustsOfWind gustsOfWind = new GustsOfWind("Порывы ветра");
            Meeting meeting = new Meeting("Встреча", upperAtmosphere, gustsOfWind);
            SnowCylinders snowCylinders = new SnowCylinders("Загадочные снежные цилиндры");
            Flatland flatland = new Flatland("Бескрайняя ледяная равнина");
            Amundsen amundsen = new Amundsen("Амундсен","заметил",snowCylinders, "ранее" );
            Berd berd = new Berd("Берд","заметил",snowCylinders, "ранее" );
            Wind wind = new Wind("Ветер", "гнал", amundsen,berd,flatland,"ранее");
            Bulletens bulletens = new Bulletens("Бюллетени","посланы", airplane.BoardAction().GetPlace(),flight,meeting,mine,snowCylinders);
            NewsPapers newsPapers = new NewsPapers("Газеты", "напечатали", bulletens);
            Moment moment = new Moment("Момент","наступил");
            We we1 = new We ();
            We we2 = new We("Мы", "начали строго контролировать слова", "ввели своего рода цензуру");
            Craters craters = new Craters("Таинственные кратеры");
            Tops tops = new Tops("Вершины");
            Line line = new Line("Линия", craters,tops);
            Larsen larsen = new Larsen("Матрос Ларсен", "завидел","завопил",line);
            Illuminator illuminator = new Illuminator("Иллюминатор");
            All all = new All("Все", "бросились", illuminator);
            airplane.Action();
            High high = new High("Высота");
            PartOfSky sky = new PartOfSky("Западная часть неба");
            Mountains mountains = new Mountains("Горы","далеки","не приближались","видны","все же вырастали","застилали", high,we,sky);
            We we3 = new We(){
                @Override
                public void ClassicVivod() {
                    System.out.println("Мы уже могли рассмотреть");
                }
            };
            tops.GetDescription();
            Dust dust = new Dust("Ледяная пыль", "переливается цветами радуги");
            Background background = new Background("Фон облаков ", dust);
            Giaints giaints = new Giaints("Громады");
            Light light = new Light("Розовый антарктический свет", "Заливал",giaints,background);
            We we4 = new We(){
                @Override
                public void ClassicVivod() {
                    System.out.println("Мы смотрели");
                }
            };
            Us us = new Us("Нас");
            Feeeling feeeling = new Feeeling("Ощущение чуда", "пронизывало", us);
        } catch (Exception e){
            System.err.println("Проблема!!!");
            throw new Exceptions.Story();
        } finally {
            System.out.println("Конец");
        }
    }
}
