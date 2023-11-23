package de.zettsystems.netzfilm.rent.adapter;

import de.zettsystems.netzfilm.rent.application.RentService;
import de.zettsystems.netzfilm.rent.values.RentRequest;
import de.zettsystems.netzfilm.rent.values.ResponseRent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentAdapter {
    private final RentService rentService;

    public RentAdapter(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping(path = "/rents/")
    public ResponseEntity<String> createRent(@RequestBody RentRequest rent) {
        ResponseRent newRent = rentService.createRent(rent.getMovieId(), rent.getCustomerId());
        return new ResponseEntity<>(newRent.getRentId(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/rents/")
    public List<ResponseRent> listRents() {
        return rentService.receiveAllRents();
    }
}
