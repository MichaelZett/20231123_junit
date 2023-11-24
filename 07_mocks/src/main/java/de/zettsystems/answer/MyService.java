package de.zettsystems.answer;

import java.time.LocalDate;

public class MyService {
    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public Entity getDataById(String name, LocalDate date) {
        Entity newEntity = new Entity(name, date);
        return myRepository.save(newEntity, "id");
    }
}
