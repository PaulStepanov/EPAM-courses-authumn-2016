package controller.facades;

import controller.services.FlightService;
//Сделать Сервисы в одном варианте на сервер при каждом запросе открывать конекшен,
// после выполнения закрывать(возвращать в пул)
//или просто имеющиейся конекшены собрать в один класс и оттуда вызывать
//добавить route builder 


public class FlightServiceDecorator {
    private static FlightServiceDecorator flightServiceDecorator=new FlightServiceDecorator();
    private FlightService flightService;

    public FlightServiceDecorator() {

    }
}
