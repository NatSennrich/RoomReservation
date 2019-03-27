package roomreservation

class BookingController {

    static scaffold = Booking

    def all() {
        respond Booking.last()

        //render irgendein view
    }

}
