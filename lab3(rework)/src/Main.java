public class Main {
    public static void exsist(String s){
        System.out.println("Объект " + s +" создан");
    }
    public static void story(Neznayka neznayka, Cashier kassir,Seeds seeds,Shorty korotishka,AbstractPlace place,Shorty ponchik,
                 They they,MoneyKeeper kaznachey, President predsedatel) {
        exsist(neznayka.GetName());
        exsist(seeds.GetType());
        exsist(korotishka.GetName());
        exsist(ponchik.GetName());
        exsist(kaznachey.GetProfession());
        exsist(predsedatel.GetProfession());
        System.out.println("Объект " + ponchik.GetName()+ " " +ponchik.getMove()+" на локации "+ place.GetPlace());
        System.out.println(neznayka.GetName()+ " " + neznayka.getStatus() + " потому что "+ neznayka.getMove2()+
                 korotishka.GetName() + neznayka.getMove3() + ponchik.GetName());
        System.out.println(they.GetName()+" "+they.getMove1()+" и "+ they.getMove2());
        System.out.println(kassir.GetType(responsibilities.KASSIR)+": " + kassir.GetProfession());
        System.out.println(kaznachey.GetType(responsibilities.KAZNACHEY)+": "+kaznachey.GetProfession());
        System.out.println(predsedatel.GetType(responsibilities.PREDSEDATEL)+": "+predsedatel.GetProfession());
        System.out.println("Обязанности " + kassir.GetType(responsibilities.KASSIR)+": "+ kassir.getMove1()+ ", "
                + kassir.getMove2());
        System.out.println("Обязанности "+ kaznachey.GetType(responsibilities.KAZNACHEY)+": "+kaznachey.getMove());
        System.out.println("Обязанности "+ predsedatel.GetType(responsibilities.PREDSEDATEL)+": "
                + predsedatel.getMove());
    }

    public static void main(String[] args) {

        Cashier kassir =new Cashier("Незнайка", "Сидеть в конторе", "Продавать акции");
        Seeds seeds = new Seeds("Семена", 3);
        Neznayka neznayka = new Neznayka("Незнайка", "выручит",seeds);
        Shorty korotishka = new Shorty("Лунные коротышки","");
        AbstractPlace place = new AbstractPlace("Луна");
        Shorty ponchik = new Shorty("Пончик","Остался");
        They they = new They("Они", "Порешили", "Перешли к распределению обязанностей");
        MoneyKeeper kaznachey = new MoneyKeeper("Мига", "Хранить вырученные деньги");
        President predsedatel = new President("Жулио","Назначать заседания акционерного общества");
        story(neznayka,kassir, seeds,korotishka,place,ponchik,they,kaznachey,predsedatel);
    }
}
