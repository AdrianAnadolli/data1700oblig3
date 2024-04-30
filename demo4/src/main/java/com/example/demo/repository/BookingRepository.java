package com.example.demo.repository;

import com.example.demo.model.Booking;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookingRepository {

    @Resource
    private JdbcTemplate db;

    public List<Booking> hentAlleBooking() {

        String sql = "SELECT * FROM Booking ORDER BY Etternavn DESC";
        List<Booking> BookList = db.query(sql, new BeanPropertyRowMapper(Booking.class));
        return BookList;
    }

    public String leggTilBooking(Booking booking) {

        String sql = "INSERT INTO Booking(film, antall, fornavn, etternavn, telefonnr, epost) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            db.update(sql, booking.getFilm(), booking.getAntall(), booking.getFornavn(), booking.getEtternavn(),
                    booking.getTelefonnr(), booking.getEpost());
        } catch (Exception e) {
            return "feil";
        }
        return "OK";
    }

public String endreBooking(Booking booking) {
    String sql = "UPDATE Booking SET film = ?, antall = ?, fornavn = ?, etternavn = ?, telefonnr = ?, epost = ? Where id = ?";
    if(booking.getAntall() <=0){
        return "Antall kan ikke ha en negativ verdi";
    }
    try {
        db.update(sql, booking.getFilm(), booking.getAntall(), booking.getFornavn(), booking.getEtternavn(),
                booking.getTelefonnr(), booking.getEpost(), booking.getId());
    } catch (Exception e) {
        return "feil";
    }
    return "OK";
}
    public String slett(String id) {
        try {
            String sql = "DELETE FROM Booking Where id = ?";
            db.update(sql, id);
        } catch (Exception e) {
            return "Feil";
        }
        return "OK";
    }
}