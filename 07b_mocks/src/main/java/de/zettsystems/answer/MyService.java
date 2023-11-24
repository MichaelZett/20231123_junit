package de.zettsystems.answer;

public class MyService {
    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public String getDataById(String id) {
        return myRepository.findDataById(id);
    }
}
