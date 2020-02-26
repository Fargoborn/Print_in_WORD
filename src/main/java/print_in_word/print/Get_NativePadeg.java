package print_in_word.print;

import java.util.ArrayList;

public class Get_NativePadeg {
//*
    String s;
    String fio;
    String status;

    public Get_NativePadeg() {
    }

    public String getGet_NativePadeg(String s) {

        String[] FIO = s .split(" ");
        System.out.println(s);

        //System.out.println("Печать падежей ++++++++++++++++++++++++++++++++++++++++++++++++++");

        PadegBean pb = new PadegBean();

        if(FIO.length < 2) {
            pb.setMiddleName("$$");
            pb.setLastName(FIO[0]);
            pb.setFirstName("$$");
        }

        else if(FIO.length < 3) {
            pb.setLastName(FIO[0]);
            pb.setFirstName(FIO[1]);
            pb.setMiddleName("$$");
        }
        else if (FIO.length == 3 || FIO.length > 3) {
            pb.setFirstName(FIO[1]);
            pb.setMiddleName(FIO[2]);
            pb.setLastName(FIO[0]);
        }
        pb.setSexStr("auto");

        //System.out.print(pb.getLastName() + " " + pb.getFirstName() + " " + pb.getMiddleName());

        for (int i = 0; i < 6; i++){
            System.out.println(pb.getResultItems().get(i).getFio());
        }
        fio = pb.getResultItems().get(2).getFio();

        //return fio_NativePadeg;
        return fio;
    }

    public String getGet_NativePadeg_Status(String s) {

        PadegBean pb = new PadegBean();
        pb.setAppointment(s);
        status = pb.getResultItems().get(2).getAppointment();
        System.out.println(status);

        //return fio_NativePadeg;
        return status;
    }
}
