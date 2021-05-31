package my.uum;

import java.util.Date;
import java.util.Scanner;

public class Test {
    Scanner scan = new Scanner(System.in);
    public void CRUD(){
        int opt=0;
        do {
            System.out.println("1.Hole\n2.Golfer\n3.Tournament");
            opt = scan.nextInt();
            if (opt==1){ Hole(); }
            else if (opt==2){Golfer();}
            else if (opt==3){Tournament();}
        }while(opt != 0);
    }

    private void Tournament() {
        System.out.println("Tournament ID");
        int tournament_id = scan.nextInt();
        System.out.println("Tournament Date");
        String tournament_date = scan.next();
        System.out.println("Mode Of Play");
        String mode_of_play = scan.next();
        System.out.println(tournament_id+tournament_date+mode_of_play);
    }

    private void Golfer() {
        System.out.println("Golfer ID");
        int golfer_id = scan.nextInt();
        System.out.println("Golfer Name");
        String golfer_name = scan.next();
        System.out.println("Golfer handicap");
        String golfer_handicap = scan.next();
        System.out.println("Telegram ID");
        int telegram_id = scan.nextInt();
        System.out.println(golfer_id+golfer_name+golfer_handicap+telegram_id);
    }

    private void Hole(){
        System.out.println("Hole Number:");
        int hole_num=scan.nextInt();
        System.out.println("Hole Index");
        int hole_index = scan.nextInt();
        System.out.println("Hole Par");
        int hole_par = scan.nextInt();
        System.out.println(hole_num+" "+hole_index+" "+hole_par);
    }

}
