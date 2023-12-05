import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class codesqad_step01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dex[] = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8};
        int a[] = new int[18];
        int b[][] = new int[3][6];
        int temp[][] = new int[3][6];
        int count_1 = 0; int count_2 = 0; int count_3 = 0; int count_4 = 0;int count_5 = 0;int count_6 = 0; int count_7 = 0; int count_8 = 0;
        Random r = new Random();

        for(int j=0 ; j<18 ; j++){
            a[j] = r.nextInt(24); //0~23
            for(int k=0 ; k<j ; k++){
                if(a[j] == a[k]){
                    j--;
                }
            }
        } //0~23을 랜덤으로 뽑아 a에 대입
        int count=0;
            for(int p=0 ; p<3 ; p++){
                for(int q=0 ; q<6 ; q++){
                    b[p][q]=dex[a[count]];
                    count++;
                }
            } //dex값을 2차원 배열 b[][]에 대입

        for(int p=0 ; p<3 ; p++){
            for(int q=0 ; q<6 ; q++){
                temp[p][q]=b[p][q];
                count++;
            } //b와 똑같은 temp배열을 생성
        }

        int try_num = 0;
        int remaining_card_num = 18;

    String[][] Unbox = {{"X", " ", "X", " ", "X", " ", "X", " ", "X", " ", "X"},
            {"X", " ", "X", " ", "X", " ", "X", " ", "X", " ", "X"},
            {"X", " ", "X", " ", "X", " ", "X", " ", "X", " ", "X"}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(Unbox[i][j]);
            }
            System.out.println();
        }
    while (true) {System.out.println();
    System.out.println("<시도" + try_num + "," + "남은 카드:" + remaining_card_num +">");
    System.out.println("입력1?");
    int input_1 = sc.nextInt();
    int input_2 = sc.nextInt();
    System.out.println("입력2?");
    int input_3 = sc.nextInt();
    int input_4 = sc.nextInt();

    temp[input_1][input_2] = 0;
    temp[input_3][input_4] = 0;
        for(int i=0 ; i<3 ; i++) {
            for (int j = 0; j < 6; j++) {
                if (temp[i][j] == 1) {
                    count_1++;
                } else if (temp[i][j] == 2) {
                    count_2++;
                } else if (temp[i][j] == 3) {
                    count_3++;
                } else if (temp[i][j] == 4) {
                    count_4++;
                } else if (temp[i][j] == 5) {
                    count_5++;
                } else if (temp[i][j] == 6) {
                    count_6++;
                } else if (temp[i][j] == 7) {
                    count_7++;
                } else if (temp[i][j] == 8) {
                    count_8++;
                }
            }
        }

    Unbox[input_1][input_2 * 2] = String.valueOf(b[input_1][input_2]);
    Unbox[input_3][input_4 * 2] = String.valueOf(b[input_3][input_4]);

    for (int p = 0; p < 11; p++) {
        System.out.print(Unbox[0][p]);
    }
    System.out.println();
    for (int q = 0; q < 11; q++) {
        System.out.print(Unbox[1][q]);
    }
    System.out.println();
    for (int e = 0; e < 11; e++) {
        System.out.print(Unbox[2][e]);
    }
    System.out.println();
    System.out.println();

    if (b[input_1][input_2] == b[input_3][input_4]) {
        Unbox[input_1][input_2 * 2] = " ";
        Unbox[input_3][input_4 * 2] = " ";

        for (int p = 0; p < 11; p++) {
            System.out.print(Unbox[0][p]);
        }
        System.out.println();
        for (int q = 0; q < 11; q++) {
            System.out.print(Unbox[1][q]);
        }
        System.out.println();
        for (int e = 0; e < 11; e++) {
            System.out.print(Unbox[2][e]);
        }
    } else if(b[input_1][input_2] != b[input_3][input_4]){
        Unbox[input_1][input_2 * 2] = "X";
        Unbox[input_3][input_4 * 2] = "X";

        for (int p = 0; p < 11; p++) {
            System.out.print(Unbox[0][p]);
        }
        System.out.println();
        for (int q = 0; q < 11; q++) {
            System.out.print(Unbox[1][q]);
        }
        System.out.println();
        for (int e = 0; e < 11; e++) {
            System.out.print(Unbox[2][e]);
        }
    }
    else if(Unbox == new String[][]{{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}}){
        System.out.println("축하합니다!");
        break;
    }
    else if(
         ((count_1==0)||(count_1==1))&&
                ((count_2==0)||(count_2==1))&&
                ((count_3==0)||(count_3==1))&&
                ((count_4==0)||(count_4==1))&&
                ((count_5==0)||(count_5==1))&&
                ((count_6==0)||(count_6==1))&&
                ((count_7==0)||(count_7==1))&&
                ((count_8==0)||(count_1==8))
    ){
        System.out.println("축하합니다!");
    }


        int cnt=0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 11; j++) {
            if(Unbox[i][j] == "X"){
                cnt++;
            }
        }
    }
    try_num++;
    remaining_card_num = cnt;
}

    }
}
