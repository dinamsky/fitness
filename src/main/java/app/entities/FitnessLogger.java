package app.entities;



import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FitnessLogger {
    public static void PrintTofile(User User, FitnessServiceEnumeration type) throws IOException {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


//        File file = new File("src/Fitness/clients.txt");
//        try(FileOutputStream fileOutputStream = new FileOutputStream(file, true);
//            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
//
//            sb.append(User.getSurname() + " " + User.getName() + " " + type + " " + LocalDate.now() +
//                    " " + formatter.format(LocalTime.now()) + "\n");
//            byte[] bytes = sb.toString().getBytes();
//            bos.write(bytes, 0 , bytes.length);
//        }

    }
}