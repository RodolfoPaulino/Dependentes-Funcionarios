package funcionarionumdep;

import java.util.Scanner;

public class FuncionarioNumDep {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        String nome[] = {"Rui", "Ivo", "Iumi", "Nei", "Susi", "Alan", "Ian", "Bia", "Gil"};
        double salarioBase[] = {3000.00, 2000.00, 1000.00, 800.00, 1800.00, 1100.00, 1500.00, 1000.00, 800.00};
        int numDep[] = {4, 2, 2, 2, 0, 1, 3, 3, 0};

        //item1
        for (int i = 0; i < 9; i++) {
            System.out.printf("%12s %12.2f %12d\n", nome[i], salarioBase[i], numDep[i]);
        }

        //item2
        System.out.println("\nSalários líquidos");
        double inss, salFamilia;
        double salarioLiquido;

        for (int i = 0; i < 9; i++) {
            inss = salarioBase[i] * 0.08;

            if (salarioBase[i] < 811) {
                salFamilia = 40 * numDep[i];
            } else if (salarioBase[i] <= 1200) {
                salFamilia = 30 * numDep[i];
            } else {
                salFamilia = 0;
            }

            salarioLiquido = salarioBase[i] - inss + salFamilia;
            System.out.printf("%12s %12.2f\n", nome[i], salarioLiquido);
        }

        //item3
        System.out.println("\nMédias");
        double somaSal = 0;
        double somaDep = 0;
        double mediaSal, mediaDep;

        for (int i = 0; i < 9; i++) {
            somaSal = somaSal + salarioBase[i];
            somaDep = somaDep + numDep[i];
        }
        mediaSal = somaSal / 9;
        mediaDep = somaDep / 9.0;
        System.out.printf("Média sal: %.2f\n", mediaSal);
        System.out.printf("Soma dep: %.2f\n", somaDep);
        System.out.printf("Média dep: %.2f\n", mediaDep);

        //item4
        System.out.println("\nPorcentagem");
        int cont = 0;
        double perc;
        for (int i = 0; i < 9; i++) {
            if (numDep[i] == 0) {
                cont = cont + 1;
            }
        }
        perc = cont / 9.0 * 100;
        System.out.printf("Perc: %.2f\n" , perc);

        //item5
        System.out.println("\nMaior salario");
        double maior = salarioBase[0];
        String nomeMaior = nome[0];
        int numDepMaior = numDep[0];

        for (int i = 0; i < 9; i++) {
            if (maior < salarioBase[i]) {
                maior = salarioBase[i];
                nomeMaior = nome[i];
                numDepMaior = numDep[i];
            }
        }
        System.out.println("Nome: " + nomeMaior);
        System.out.println("Num dep: " + numDepMaior);
        System.out.printf("Maior salario: %.2f\n" , maior);

        //item6
        System.out.println("\nResultado");
        int num;
        boolean achou = false;//sinalizador
        System.out.println("Digite a quantidade de dependentes: ");
        num = leia.nextInt();
        for (int i = 0; i < 9; i++) {
            if (numDep[i] > num) {
                achou = true;
                System.out.println(nome[i] + "   " + salarioBase[i]);
            }
        }
        if (!achou) {
            System.out.println("não encontrado");
        }
    }

}
