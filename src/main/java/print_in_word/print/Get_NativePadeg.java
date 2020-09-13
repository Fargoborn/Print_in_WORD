package print_in_word.print;

public class Get_NativePadeg {
//*
    String fio;
    String fiopp;
    String status;
    String sex;

    public Get_NativePadeg() {
    }

    public String getGet_NativePadeg(String s) {

        String[] FIO = s .split(" ");
        //System.out.println(s);

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

        //for (int i = 0; i < 6; i++){
            //ystem.out.println(pb.getResultItems().get(i).getFio());
        //}
        fio = pb.getResultItems().get(2).getFio();

        //return fio_NativePadeg;
        return fio;
    }

  public String getGet_NativePadeg_pp(String s) {

    String[] FIO = s .split(" ");
    //System.out.println(s);

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

    //for (int i = 0; i < 6; i++){
      //System.out.println(pb.getResultItems().get(i).getFio());
    //}
    fio = pb.getResultItems().get(1).getFio();

    //return fio_NativePadeg;
    return fio;
  }


  public String getGet_NativePadeg_Status(String s) {

        PadegBean pb = new PadegBean();
        pb.setAppointment(s);
        status = pb.getResultItems().get(2).getAppointment();
        //System.out.println(status);

        //return fio_NativePadeg;
        return status;
    }

  public String getGet_Sex(String s) {

    String[] FIO = s .split(" ");
    //System.out.println(s);

    //System.out.println("Печать падежей ++++++++++++++++++++++++++++++++++++++++++++++++++");

    PadegBean pb = new PadegBean();
    String MiddleName = "";

    if(FIO.length < 2) {
      pb.setMiddleName("$$");
      pb.setLastName(FIO[0]);
      pb.setFirstName("$$");
      MiddleName = "$$";
    }

    else if(FIO.length < 3) {
      pb.setLastName(FIO[0]);
      pb.setFirstName(FIO[1]);
      pb.setMiddleName("$$");
      MiddleName = "$$";
    }
    else if (FIO.length == 3 || FIO.length > 3) {
      pb.setFirstName(FIO[1]);
      pb.setMiddleName(FIO[2]);
      pb.setLastName(FIO[0]);
      MiddleName = FIO[2];
    }

    //System.out.print(pb.getLastName() + " " + pb.getFirstName() + " " + pb.getMiddleName());

    for (int i = 0; i < 1; i++){
      //System.out.println(pb.getResultItems().get(i).getSex());
      if (pb.getResultItems().get(i).getSex() == 1) {
        sex = "он";
      } else {
        sex = "она";
      }
    }
    return sex;
  }
}
