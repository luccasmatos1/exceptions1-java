package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public static  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }



    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime(); // calcular a diferença em millisegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converter millisegundos para dias, usando o tipo enumerado timeunit
    }


    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }


    @Override
    public String toString() {
        return
                "Room: "        + roomNumber +
                ", CheckIn: "   + sdf.format(checkIn) +
                ", CheckOut: "  + sdf.format(checkOut) +
                ", Duração: "   + (duration() > 1 ? duration() + " dias" : duration() + " dia")  ;
    }

}
