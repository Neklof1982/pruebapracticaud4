package org.iesvdm.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    private Map<String, BookingRequest> bookings;

    @BeforeEach
    public void setup() {
        bookings = new HashMap<>();
        bookingDAO = new BookingDAO(bookings);
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas (bookings) con la que
     * construyes el objeto BookingDAO bajo testeo.
     * Comprueba que cuando invocas bookingDAO.getAllBookingRequest
     * obtienes las 2 peticiones.
     */
    @Test
    void  getAllBookingRequestsTest() {


         BookingDAO bookingDAO1 = new BookingDAO(bookings);
         BookingDAO bookingDAO2 = new BookingDAO(bookings);
         bookings.get(bookingDAO1);
         bookings.get(bookingDAO2);
         bookingDAO.save(bookings.get(bookingDAO1));
         bookingDAO.save(bookings.get(bookingDAO2));
         bookingDAO1.getAllBookingRequests().forEach(System.out::println);
         bookingDAO2.getAllBookingRequests().forEach(System.out::println);

         assertThat(bookingDAO.getAllBookingRequests()).hasSize(2);
         assertThat(bookingDAO.getAllBookingRequests()).isNotEmpty();


    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.getAllUUIDs
     * obtienes las UUIDs de las 2 peticiones guardadas.
     */
    @Test
    void getAllUUIDsTest() {

        BookingDAO bookingDAO1 = new BookingDAO(bookings);
        BookingDAO bookingDAO2 = new BookingDAO(bookings);
        bookings.get(bookingDAO1);
        bookings.get(bookingDAO2);
        bookingDAO.save(bookings.get(bookingDAO1));
        bookingDAO.save(bookings.get(bookingDAO2));
        bookingDAO1.getAllUUIDs().forEach(System.out::println);


        assertThat(bookingDAO1.getAllUUIDs()).isNotEmpty();


    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.get con el UUID
     * obtienes las respectivas 2 peticiones guardadas.
     */
    @Test
    void getTest() {

        BookingDAO bookingDAO1 = new BookingDAO(bookings);
        BookingDAO bookingDAO2 = new BookingDAO(bookings);
        bookings.get(bookingDAO1);
        bookings.get(bookingDAO2);
        bookingDAO.save(bookings.get(bookingDAO1));
        bookingDAO.save(bookings.get(bookingDAO2));
        bookingDAO1.getAllUUIDs().forEach(System.out::println);

        bookingDAO1.get("test");

        assertThat(bookingDAO1.get("test")).isNull();


    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * A continuación, borra la primera y comprueba
     * que se mantiene 1 reserva, la segunda guardada.
     */
    @Test
    void deleteTest() {

        BookingDAO bookingDAO1 = new BookingDAO(bookings);
        bookings.get(bookingDAO1);
        bookingDAO1.delete("test");
        assertThat(bookingDAO1.get("test")).isNull();

    }

    /**
     * Guarda 2 veces la misma petición de reserva (BookingRequest)
     * y demuestra que en la colección de bookings están repetidas
     * pero con UUID diferente
     *
     */
    @Test
    void saveTwiceSameBookingRequestTest() {

    }

}
