import java.util.Scanner;

public class Massiv {

    private int kol = 9;
    private int iteration = 0;
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
            if(this.position[iteration][2] < value )//|| this.position[iteration][2] != 9 )

                if(verifyNamber(ind,kin,value,iteration))return value;
        return -1;
    }

//  проверяем выбранную цифру в строке столбце и блоке
    public boolean verifyNamber(int ind,int kin,int value,int iteration){
        if(verifyNamberLine(ind, value, iteration) == true && verifyNabmerColumn(kin, value, iteration)== true && verifyNabmerBlok(ind, kin, value, iteration)== true )
            return true;
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

// Устанавливаем номер блока
    public int getNamberBlok(int i,int k){
        if (i >=0 && i < 3 && k >=0 && k < 3) return 1;
        if (i >=0 && i < 3 && k >2 && k < 6) return 2;
        if (i >=0 && i < 3 && k >5 && k < 9) return 3;
        if (i >2 && i < 6 && k >=0 && k < 3) return 4;
        if (i >2 && i < 6 && k >2 && k < 6) return 5;
        if (i >2 && i < 6 && k >5 && k < 9) return 6;
        if (i >5 && i < 9 && k >=0 && k < 3) return 7;
        if (i >5 && i < 9 && k >2 && k < 6) return 8;
        if (i >5 && i < 9 && k >5 && k < 9) return 9;
        return -1;
    }

// проверяем выбранную цифру в блоке 3x3

    private boolean verifyNabmerBlok(int ind,int kin, int value, int iteration){


        switch (getNamberBlok(ind, kin)) {
            case 1:
                for (int i = this.blokone[0][0] ; i <= this.blokone[0][2]; i++)
                    for (int k = this.blokone[0][0]; k <= this.blokone[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 2:
                for (int i = this.bloktwo[0][0] ; i <= this.bloktwo[0][2]; i++)
                    for (int k = this.bloktwo[0][0]; k <= this.bloktwo[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 3:
                for (int i = this.blokthree[0][0] ; i <= this.blokthree[0][2]; i++)
                    for (int k = this.blokthree[0][0]; k <= this.blokthree[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 4:
                for (int i = this.blokfour[0][0] ; i <= this.blokfour[0][2]; i++)
                    for (int k = this.blokfour[0][0]; k <= this.blokfour[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 5:
                for (int i = this.blokfive[0][0] ; i <= this.blokfive[0][2]; i++)
                    for (int k = this.blokfive[0][0]; k <= this.blokfour[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 6:
                for (int i = this.bloksix[0][0] ; i <= this.bloksix[0][2]; i++)
                    for (int k = this.bloksix[0][0]; k <= this.bloksix[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 7:
                for (int i = this.blokseven[0][0] ; i <= this.blokseven[0][2]; i++)
                    for (int k = this.blokseven[0][0]; k <= this.blokseven[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 8:
                for (int i = this.blokeight[0][0] ; i <= this.blokeight[0][2]; i++)
                    for (int k = this.blokeight[0][0]; k <= this.blokeight[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
            case 9:
                for (int i = this.bloknine[0][0] ; i <= this.bloknine[0][2]; i++)
                    for (int k = this.bloknine[0][0]; k <= this.bloknine[1][2] ; k++)
                        if (this.masbuf[iteration][i][k] == value) return false;
        }
        return true;

    }


// заполняем массив цифрами

    public void setMasFill(int iteration){
        int value =0;

        for(int i: this.numbernull) {
            for (int k : this.numbernull){
               // if(verifyMasFill(i,k,iteration)) {
                  if(this.verifyCellEmpty(i,k,iteration)){
                    if(getNamber(i,k,iteration)>0) { value = getNamber(i,k,iteration); this.position[iteration][2] = value;}
                    else if(iteration > 0) setMasFill(iteration-1);
                      iteration++ ;
                    this.masbuf[iteration] = this.masbuf[iteration-1];
                    this.position[iteration] = new int[]{i,k,value};
                    this.masbuf[iteration][i][k] = value;
                    this.printMassiv(iteration);
                    setMasFill(iteration);
                }  //else if(iteration > 0) setMasFill(iteration-1);
            }
        }
    }


    public void printStroka(int ind){
        for(int i = 0 ; i <= ind ; i++) {
            for (int k : numbernull)
                System.out.print(this.mas[i][k] + "\t");
            System.out.println("");
        }
    }
// печать массива
    public void printMassiv(int iteration){
        for (int i : this.numbernull) {
            for (int k : this.numbernull)
                System.out.print(this.masbuf[iteration][i][k] + "\t" );
            System.out.println("");
        }
        System.out.println("");
    }

// заполняем массив исходными данными
    public void setMas() {

        Scanner in = new Scanner(System.in);
        for (int i: this.numbernull) {
            for (int k : this.numbernull) {
                this.mas[i][k] = in.nextInt();
            }
        this.printStroka(i);
            System.out.println("\n");
        }
    this.masbuf[0] = this.mas;
    }

}
