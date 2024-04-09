import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static  void main(String[] args)  {


        Scanner sc = new Scanner(System.in);


        try {
            System.out.println(":::RESERVAR::: ");
            System.out.print("QUARTO: ");
            int room = sc.nextInt();
            System.out.print("CHECK IN (DD/MM/YYYY): ");
            Date checkIn = Reservation.sdf.parse(sc.next());
            System.out.print("CHECK OUT (DD/MM/YYYY): ");
            Date checkOut = Reservation.sdf.parse(sc.next());

            if (!checkOut.after(checkIn)){
                System.out.println("CHECKOUT NAO PODE SER ANTES DO CHECKIN");
            }

            else {
                Reservation reservation = new Reservation(room,checkIn,checkOut);
                System.out.println(reservation);

                System.out.println("ATUALIZAR RESERVA: ");
                System.out.print("NOVO CHECK IN (DD/MM/YYYY): ");
                checkIn = Reservation.sdf.parse(sc.next());
                System.out.print("NOVO CHECK OUT (DD/MM/YYYY): ");
                checkOut = Reservation.sdf.parse(sc.next());

                reservation.updateDates(checkIn,checkOut);
                System.out.println(reservation);

            }

        }catch (ParseException e){
            System.out.println("DATA INVALIDA!");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: " + e.getMessage());
        }





    }
}
