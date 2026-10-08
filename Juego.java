import java.util.Scanner;
public class Juego{
    static Scanner entrada=new Scanner(System.in);
    public static void main(String[] args) {
        inicioJuego();
    }
    public static void inicioJuego(){
        int decision=1,num_Dado,num_Dado2,acumulador=0;
         String arreglo[]={"Dado1","Azul","Dado2","Verde"};
    do{
        System.out.println("Se tiran los dados");
        System.out.println("Ingrese el valor del primer dado del 1-6:");
        do{
         num_Dado= entrada.nextInt();
         if(num_Dado>=1 && num_Dado<7){
            System.out.println("Numeros validos");  
         }
         else{
            System.out.println("Numero del dado no valido vuelve ingresar los valores");
         }
        }while(num_Dado>6 || num_Dado<=0);
         System.out.println("Ingrese el valor del segundo dado del 1-6");
         do{
         num_Dado2 = entrada.nextInt();
         if(num_Dado2>=1 && num_Dado2<7){
            System.out.println("Numeros validos");  
         }
         else{
            System.out.println("Numero del dado no valido vuelve ingresar los valores");
         }
         }while(num_Dado2>6 || num_Dado2<=0);
         Dados dadoA=new Dados(arreglo[0],arreglo[1],num_Dado);
         Dados dadoV =new Dados(arreglo[2],arreglo[3],num_Dado);
         System.out.println("El dado utilizado fue :"+ " "+ dadoA.getNombre()+" "+dadoA.getColor()+" "+"Salio con la cantidad de"+" "+dadoA.getPuntos());
         System.out.println("El dado utilizado fue :"+ " "+ dadoV.getNombre()+" "+dadoV.getColor()+" "+"Salio con la cantidad de"+" "+ num_Dado2);
         //acumular los puntos de los dados se llama al metodo sumaDados
         acumulador=acumulador+sumaDados(dadoA.getPuntos(),num_Dado2);
         // acumulador=acumulador+dadoA.num_Dado+dadoV.num_Dado;
         //acumulador=acumulador+dado1+dado2;
         if(acumulador==7 || acumulador==11){
            System.out.println("Usted gana con la cantidad de:"+ " "+ acumulador+" "+ "puntos"+" "+ "se le otorga el premio mayor");
            System.out.println("Fin del juego");
            break;
        }
         else if(acumulador==2 || acumulador==3 || acumulador==12){
            System.out.println("Se acumularon los puntos suficientes para que pierda");
            System.out.println("Con la cantidad de:"+" "+ acumulador+ " "+ "puntos");
            System.out.println("Fin del juego");
            System.out.println("Juego finalizado");
            break;
        }
         else if(acumulador==4 || acumulador==5 || acumulador==6 || acumulador==8 || acumulador==9 || acumulador==10){
            System.out.println("No tiene los puntos necesarios para ganar o perder pero Puede intentarlo de nuevo: ");
         }
        System.out.println("Los puntos acumulados son:" +" "+ acumulador+" "+"puntos");
        System.out.println("Desea volver a jugar 1-si 2-no");
        decision=entrada.nextInt();
        if(decision==1){
            System.out.println("Decision valida, los puntos se acumularan.");
        }
        else{
            System.out.println("Juego finalizado.");
            System.out.println("Gracias por jugar.");
            break;
        }
    }while(decision!=2);
    }
    public static int sumaDados(int no_Dado,int no_Dado2){
        int suma;
        suma=no_Dado+no_Dado2;
        return suma;
     }
}


