package com.SG_G1.BootcampDH.service;

import com.SG_G1.BootcampDH.dto.BookingModelDTO;
import com.SG_G1.BootcampDH.dto.responsive.MessageDTO;
import com.SG_G1.BootcampDH.exception.ValidationParams;
import com.SG_G1.BootcampDH.model.BookingModel;
import com.SG_G1.BootcampDH.repository.IHotelBookingRepository;
import com.SG_G1.BootcampDH.repository.IHotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelBookingService {

    @Autowired
    IHotelBookingRepository bookingRepository;

    @Autowired
    IHotelRepository hotelRepository;
    ModelMapper mapper = new ModelMapper();

    @Transactional
    public MessageDTO saveEntity(BookingModelDTO DTO) {
        BookingModel booking = mapper.map(DTO, BookingModel.class);



        // Comprobar si existe una reserva con idénticas características
        Optional<BookingModel> existingBooking = bookingRepository.findByDateFromAndDateToAndDestinationAndHotelCodeAndPeopleAmountAndRoomType(
                booking.getDateFrom(), booking.getDateTo(), booking.getDestination(), booking.getHotelCode(),
                booking.getPeopleAmount(), booking.getRoomType());

        if (existingBooking.isPresent()) {
            // Comprobar si existe una reserva con idénticas características
            throw new ValidationParams("Ya existe una reserva con características idénticas.");
        } else {
            //Si no existe una reserva de idénticas características, graba la nueva reserva
            bookingRepository.save(booking);
            return new MessageDTO("La reserva se creó correctamente.");
        }
    }
    // el método findByDateFromAndDateToAndDestinationAndHotelCodeAndPeopleAmountAndRoomType()
    // para buscar una reserva existente con las mismas características que la reserva que se va a guardar. Si se encuentra
    // una reserva existente, se devuelve un mensaje de error. De lo contrario, se guarda la nueva reserva y se devuelve un mensaje de éxito.

    public MessageDTO updateEntity(Integer id, BookingModelDTO DTO) {
        BookingModel booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ValidationParams("La reserva con el " + id + "no existe"));
        mapper.map(DTO, booking);
        bookingRepository.save(booking);
        return new MessageDTO("La reserva se modifico correctamente.");
    }
    public List<BookingModelDTO> getAllEntities() {
        List<BookingModel> list = bookingRepository.findAll();
        if (list.isEmpty()) {
            throw new ValidationParams("No hay reservas de hoteles");
        }
        return list.stream()
                .map(bookingModel -> mapper.map(bookingModel, BookingModelDTO.class))
                .collect(Collectors.toList());
    }

    public MessageDTO deleteEntity(Integer id) {
        BookingModel booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ValidationParams("La reserva con el id " + id + " no existe"));
        bookingRepository.delete(booking);
        return new MessageDTO("La reserva se eliminó correctamente.");
    }

    public BookingModelDTO findByPeopleDni(Integer dni) {

        try{
            BookingModelDTO booking = mapper.map(bookingRepository.findByPeopleDni(dni), BookingModelDTO.class);
            return booking;
        }catch(IllegalArgumentException ex){
            throw  new ValidationParams("La persona no se encuentra en niguna reserva");
        }

    }


    public BookingModelDTO findByPeopleMail(String  mail) {



        try{
            BookingModelDTO booking = mapper.map(bookingRepository.findByPeopleMail(mail), BookingModelDTO.class);
            return booking;
        }catch(IllegalArgumentException ex){
            throw  new ValidationParams("La persona no se encuentra en niguna reserva");
        }
    }

}
