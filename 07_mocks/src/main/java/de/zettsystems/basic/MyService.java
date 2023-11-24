package de.zettsystems.basic;

public class MyService {
    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public String getProcessedData() {
        String data = myRepository.getData();
        // Hier würde eine Verarbeitung der Daten durchgeführt werden
        return "Processed " + data;
    }
}
