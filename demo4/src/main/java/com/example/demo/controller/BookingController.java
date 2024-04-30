package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


@RestController
public class BookingController {

    @Autowired
    BookingRepository repository;

    @GetMapping("/bookings")
    public List<Booking> hentAlle() {
        List<Booking> booking = repository.hentAlleBooking();
        return booking;
    }

    @PostMapping("/registrer")
    public String registrerBooking(Booking booking) {
        return repository.leggTilBooking(booking);
    }

    @PostMapping("/endre")
    public String endre(Booking booking) {
        return repository.endreBooking(booking);
    }

    @GetMapping("/slett")
    public String slett(String id) {
        try {
            return repository.slett(id);
        } catch (Exception e) {
            return "feil";
        }
    }
}


