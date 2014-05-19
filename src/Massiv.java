import java.util.Scanner;

public class Massiv {

    private int kol = 9;
    private int[] iteration = new int[kol*kol];
    private int[][] position = new int[kol*kol][];
    private int mas[][] = new int[kol][kol];
    private int[][][] masbuf = new int[kol*kol][][];
    private int[] numbernull = {0,1,2,3,4,5,6,7,8};
    private int[] number = {1,2,3,4,5,6,7,8,9};
    private int[][] blokone = {{0,1,2},{0,1,2}};
    private int[][] bloktwo = {{0,1,2},{3,4,5}};
    private int[][] blokthree = {{0,1,2},{6,7,8}};
    private int[][] blokfour = {{3,4,5},{0,1,2}};
    private int[][] blokfive = {{3,4,5},{3,4,5}};
    private int[][] bloksix = {{3,4,5},{6,7,8}};
    private int[][] blokseven = {{6,7,8},{0,1,2}};
    private int[][] blokeight = {{6,7,8},{3,4,5}};
    private int[][] bloknine = {{6,7,8},{6,7,8}};


// Конструктор класса

    public Massiv(int kol) {
        this.kol = kol;
        this.ini();
    }

// Инициализация массивов позиции

    public void ini() {
        int n = 0;
        for (int i : numbernull)
            for (int k : numbernull) {
                this.position[n] =new int[]{0,0,0};
                this.masbuf[n] = mas;
                n++;
            }


    }



// есть ли пустая ячейка в массиве - !!!!!!!!!пока не используем функция!!!!!!!!

//    public boolean verifyMasEmpty(int iteration ){
//        for(int i: this.numbernull)
//        for (int k: this.numbernull)
//            if(this.masbuf[iteration][i][k] == 0) return true;
//        return false;
//    }
//

// запрос "Можно заполнять"  или возврат к предыдущей итерации с приращением значения

    public boolean verifyMasFill(int i, int k, int iteration){
        if(verifyCellEmpty(i,k,iteration) && getNamber(i,k,iteration) != -1  ) return true; // пустая ячейка
        return  false;
    }

// проверяем пустая ли выбранная ячейка n

    public boolean verifyCellEmpty(int i,int k, int iteration){
        if(this.masbuf[iteration][i][k] == 0) return true;
        return false;
    }

// вычислить цифру можно использовать в данной ячейке или -1 - нельзя
    public int getNamber(int ind, int kin, int iteration ){
        for (int value : this.number)
            if(this.position[iteration][3] > value || this.position[iteration][3] != 9 )
                if(verifyNamber(ind,kin,value,iteration))return num;
        return -1;
    }

//  проверяем выбранную цифру в строке столбце и блоке
    public boolean verifyNamber(int ind,int kin,int value,int iteration){
        if(verifyNamberLine(ind, value, this.iteration[iteration]))
            if(verifyNabmerColumn(kin,value, this.iteration[iteration]))
                if(verifyNabmerBlok(ind, kin, value, this.iteration[iteration])) return true;
        return false;
    }
// проверяем выбранную цифру в строке

    public boolean verifyNamberLine(int ind, int value,int iteration){
        for(int k = 0; k < kol; k++ )
                   if(this.masbuf[iteration][ind][k] == value)return false;
        return true;
    }


// проверяем выбранную цифру в столбце

    public boolean verifyNabmerColumn(int kin, int value, int iteration){

        for(int i = 0; i < kol; i++ )
                if(this.masbuf[iteration][i][kin] == value)return false;
        return true;
    }

// проверяем выбранную цифру в блоке

    private boolean verifyNabmerBlok(int ind,int kin, int value, int iteration){

        for(int blok)


        return true;

    }


// заполняем массив цифрами

    public void setMasFill(int value,int iteration){


        for(int i: this.numbernull) {
            for (int k : this.numbernull){
                if(verifyMasFill(i,k,this.iteration[iteration])) {
                    value = getNamber(i,k,iteration);
                    iteration++ ;
                    this.position[iteration] = new int[]{i,k,value};
                    this.iteration[iteration] = iteration++ ;
                    this.masbuf[iteration][i][k] = value;
                } else setMasFill();
            }
        }
    }


    public void printStroka(int ind){
        for(int i = 0 ; i <= ind ; i++) {
            for (int k : numbernull)
                System.out.print(this.mas[i][k] + " ");
            System.out.println("");
        }
    }

// заполняем массив исходными данными
    public void setMas() {

        Scanner in = new Scanner(System.in);
        for (int i: this.numbernull) {
            for (int k : this.numbernull) {
                this.mas[i][k] = in.nextInt();
            }
        this.printStroka(i);
            System.out.println("");
        }
    this.mas = this.masbuf[0];
    }

}
