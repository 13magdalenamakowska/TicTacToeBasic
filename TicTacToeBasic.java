package KolkoKrzyzyk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeBasic {
    public static void main(String[] args){

    Scanner scanner2 = new Scanner(System.in);
    System.out.println("Jestem pomocnikiem o imieniu Yeti. Zagrajcie w kółko i krzyżyk. Jak macie na imię?");
    System.out.println();

    System.out.println("Osoba, która podaje imię jako pierwsza otrzyma w grzę znak 'x' i będzie rozpoczynać grę.");
    System.out.println("(Wpisz swoje imie i naciśnij enter.)");
    System.out.println();

    String firstName;
    firstName = scanner2.nextLine();
    System.out.println();

    System.out.println("Osoba, która podaje imię jako druga otrzyma w grzę znak 'o'.");
    System.out.println("(Wpisz swoje imie i naciśnij enter.)");
    System.out.println();

    String secondName;
    secondName = scanner2.nextLine();
    System.out.println();
    System.out.println("Super! " + firstName + ", " + secondName + " zagrajcie w kółko i krzyżyk.");
    System.out.println();

    char[][] area = new char[3][3];

    area [0][0] = ' ';
    area [0][1] = ' ';
    area [0][2] = ' ';
    area [1][0] = ' ';
    area [1][1] = ' ';
    area [1][2] = ' ';
    area [2][0] = ' ';
    area [2][1] = ' ';
    area [2][2] = ' ';

    System.out.println("1" + area[0][0] + "|" + " 2" + area[0][1] + "|" + " 3" + area[0][2]);
    System.out.println("---------");
    System.out.println("4" + area[1][0] + "|" + " 5" + area[1][1] + "|" + " 6" + area[1][2]);
    System.out.println("---------");
    System.out.println("7" + area[2][0] + "|" + " 8" + area[2][1] + "|" + " 9" + area[2][2]);
    System.out.println();
    System.out.println("(Wybierz pole oznaczone cyfrą od 1 do 9. Wpisz wybraną cyfrę i naciśnij enter.)");
    System.out.println();

    int i = 1;
    while (i <= 9) {

        Scanner scanner = new Scanner(System.in);

        char firstUser = 'x';
        char secondUser = 'o';

        if (firstUser == 'x') {
            char sign = 'x';
            int place =0;
            System.out.println(firstName + ", w którym miejscu chcesz wpisać znak x?");
            System.out.println();
            sign = getSign(area, scanner, sign);
            showArea(area);
            firstUser = secondUser;
            if (checkResult(area, sign)) break;
        }
        if (secondUser == 'o') {
            char sign = 'o';
            int place=0;
            System.out.println(secondName + ", w którym miejscu chcesz wpisać znak - o?");
            System.out.println();
            sign = getSign(area, scanner, sign);
            showArea(area);
            secondUser = firstUser;
            if (checkResult(area, sign)) break;
        }
    }
}
    private static void showArea(char[][] area) {
        System.out.println(area[0][0] + "|" + area[0][1] + "|" + area[0][2]);
        System.out.println("------");
        System.out.println(area[1][0] + "|" + area[1][1] + "|" + area[1][2]);
        System.out.println("------");
        System.out.println(area[2][0] + "|" + area[2][1] + "|" + area[2][2]);
        System.out.println();
    }
    private static char getSign(char[][] area, Scanner scanner, char sign) {
        int x = 0;
        int y = 0;
        int place =0;
        try {
            place = scanner.nextInt();
            System.out.println();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Niepoprawne współrzędne. Wpisz cyfrę z zakresu 0-9\n");
        } catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Niepoprawne współrzędne. Wpisz cyfrę z zakresu 0-9\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sign = signPutToArea(area, sign, place);

            //area[x][y] = sign;
        }
        return sign;
    }

    private static char signPutToArea(char[][] area, char sign, int place) {
        int x = 0;
        int y = 0;
        if (place == 1) {
            x = 0;
            y = 0;
        } else if (place == 2) {
            x = 0;
            y = 1;
        } else if (place == 3) {
            x = 0;
            y = 2;
        } else if (place == 4) {
            x = 1;
            y = 0;
        } else if (place == 5) {
            x = 1;
            y = 1;
        } else if (place == 6) {
            x = 1;
            y = 2;
        } else if (place == 7) {
            x = 2;
            y = 0;
        } else if (place == 8) {
            x = 2;
            y = 1;
        } else if (place == 9) {
            x = 2;
            y = 2;
        }
        if (area[x][y] != ' ') {
            System.out.println("To pole jest już zajęte. ");
            System.out.println();
        } else {
            area[x][y] = sign;
        }
        return sign;
    }
    private static boolean checkResult(char[][] area, char sign) {
        if ((area[0][0] == area[0][1] && area[0][1] == area[0][2] && area[0][2] != ' ') ||
                (area[1][0] == area[1][1] && area[1][1] == area[1][2] && area[1][2] != ' ') ||
                (area[2][0] == area[2][1] && area[2][1] == area[2][2] && area[2][2] != ' ') ||
                (area[0][0] == area[1][0] && area[1][0] == area[2][0] && area[2][0] != ' ') ||
                (area[0][1] == area[1][1] && area[1][1] == area[2][1] && area[2][1] != ' ') ||
                (area[0][2] == area[1][2] && area[1][2] == area[2][2] && area[2][2] != ' ') ||
                (area[0][0] == area[1][1] && area[1][1] == area[2][2] && area[2][2] != ' ') ||
                (area[0][2] == area[1][1] && area[1][1] == area[2][0] && area[2][0] != ' ')) {
            System.out.println(sign + " wygrał");
            return true;
        }
        if (area[0][0] != ' ' && area[0][1] != ' ' && area[0][2] != ' ' &&
                area[1][0] != ' ' && area[1][1] != ' ' && area[1][2] != ' ' &&
                area[2][0] != ' ' && area[2][1] != ' ' && area[2][2] != ' ') {
            System.out.println("Koniec gry. Remis");
            return true;
        }
        return false;
    }
}