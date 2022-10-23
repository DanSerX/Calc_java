import java.util.Scanner;
public class Main {
    static String getRomanNumber(int number) {
        return "I".repeat(number)
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }
    public static void main(String[] args) throws Exception {
        Scanner calcul = new Scanner(System.in);
        String cal = calcul.nextLine();
        int xd; int xr; int yd; int yr;
        int[] des = {0,1,2,3,4,5,6,7,8,9};
        String[] num = {"1","2","3","4","5","6","7","8","9","10"};
        String[] rim = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        while (true){
            xd = xr = yd = yr = 0;
            String[] elems = cal.split(" ");
            if (elems.length != 3){
                throw new Exception();
            }
            for (int x: des) {
                if (num[x].equals(elems[0])){
                    xd = x + 1;
                }
                if (num[x].equals(elems[2])){
                    yd = x + 1;
                }
                if (rim[x].equals(elems[0])){
                    xr = x + 1;
                }
                if (rim[x].equals(elems[2])){
                    yr = x + 1;
                }
            }
            if (xd * yd > 0 && xr * yr == 0){
                if (elems[1].equals("+")){
                    System.out.println(xd+yd);
                }
                if (elems[1].equals("-")){
                    System.out.println(xd-yd);
                }
                if (elems[1].equals("*")){
                    System.out.println(xd*yd);
                }
                if (elems[1].equals("/")){
                    System.out.println(xd/yd);
                }
            } else if (xd * yd == 0 && xr * yr > 0){
                if (elems[1].equals("+")){
                    System.out.println(getRomanNumber(xr+yr));
                }
                if (elems[1].equals("-")){
                    if (xr > yr){
                        System.out.println(getRomanNumber(xr-yr));
                    }else{
                        throw new Exception();
                    }
                }
                if (elems[1].equals("*")){
                    System.out.println(getRomanNumber(xr*yr));
                }
                if (elems[1].equals("/")){
                    if (xr >= yr){
                        System.out.println(getRomanNumber(xr/yr));
                    }else{
                        throw new Exception();
                    }
                }
            } else {
                throw new Exception();
            }
            cal = calcul.nextLine();
        }
    }
}