import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

 
public class canon
{
    static double Angle_player ;
    static double Poudre_player ;
    static int Stock_player ;
    static int Stock_player2 ;
    private static final BufferedReader lecteurClavier = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException
    {
        jouerParties();

    }
   
    
    private static void jouerParties() throws IOException
    {
        boolean continuerDeJouer = true;
        while (continuerDeJouer)
        {
            jouerPartie();
 
            System.out.println("Voulez-vous rejouer (O : Oui, N : Non) ?");
            String input = lecteurClavier.readLine();
            if ("N".equals(input) || "n".equals(input) )
            {
                continuerDeJouer = false;
            }
        }
    }
    private static void changerstock() throws IOException{
        Scanner scan1= new Scanner(System.in);
        boolean changerstock = true;
            while (changerstock)
            {
                System.out.println("Voulez-vous replacer votre stock ? (O : Oui, N : Non)");
                String input = lecteurClavier.readLine();
                if ("N".equals(input) || "n".equals(input))
                {
                    changerstock = false;
                    System.out.println("Votre stock est positionné à " + Stock_player + "m.");
                }
                else if("O".equals(input) || "o".equals(input)){
                    System.out.println("Choisissez l'emplacement du stock entre  0 et -1000m : ");
                    Stock_player2 = scan1.nextInt();
                    if(Stock_player2<0 && Stock_player2>-1000){
                        Stock_player = Stock_player2;
                        System.out.println("Votre stock est positionné à " + Stock_player + "m.");
                    }
                    
                }
            }
    }
    private static void changerpuissance() throws IOException{
        Scanner scan1= new Scanner(System.in);
        boolean changerpuissance = true;
                while (changerpuissance)
                {
                    System.out.println("Voulez-vous changer de puissance ? (O : Oui, N : Non)");
                    String input = lecteurClavier.readLine();
                    if ("N".equals(input) || "n".equals(input))
                    {
                        changerpuissance = false;
                        System.out.println("Votre puissance est : " + Poudre_player + "%.");
                    }
                    else if("O".equals(input) || "o".equals(input)){
                        System.out.println("Veuillez choisir la puissance de tir entre 50 et 100 % :");
                        double Poudre_player2 = scan1.nextInt();
                        if(Poudre_player2<100 && Poudre_player2 > 50){
                            Poudre_player = Poudre_player2;
                            System.out.println("Votre puissance est : " + Poudre_player + "%.");
                        }
                        
                    }
                }
    }
    private static void changerangle() throws IOException{
        Scanner scan1= new Scanner(System.in);
        boolean changerangle = true;
                while (changerangle)
                {
                    System.out.println("Voulez-vous changer d'Angle ? (O : Oui, N : Non)");
                    String input = lecteurClavier.readLine();
                    if ("N".equals(input) || "n".equals(input))
                    {
                        changerangle = false;
                        System.out.println("Votre angle est : " + Angle_player + "°.");
                    }
                    else if("O".equals(input) || "o".equals(input)){
                        System.out.println("Veuillez choisir l'angle de tir entre 25 et 75° : ");
                        double Angle_player2 = scan1.nextInt();
                        if(Angle_player2<75 && Angle_player2 > 25){
                            Angle_player = Angle_player2;
                            System.out.println("Votre angle est : " + Angle_player + "°.");
                        }
                        
                    }
                }
    }
    private static void jouerPartie() throws IOException
    {
        
        Random rnd = new Random();
        int Stock_IA = rnd.nextInt(1000) + 500;
        Scanner scan1= new Scanner(System.in);
        System.out.println("Bienvenue dans notre jeu de tir au canon."+"\n"+"Le principe est simple, chaque camps place son stock d'obus dans sa zone de stockage derrière lui en sachant que votre adversersaire se trouve 500m devant vous."+"\n"+"Le but étant de détruire le stock ennemi avant qu'il ne détruise le votre."+"\n"+"A savoir aussi, le stock de votre ennemi ne peut être placé qu'entre 500 et 1500m devant vous, alors attention à ne pas dépasser pour rien !"+"\n"+"Pour le déroulement de la partie, chaque camps tir chacun son tour et le premier à toucher l'autre gagnera."+"\n"+"Alors que le meilleur l'emporte !"+"\n");
        System.out.println("Choisissez l'emplacement du stock entre  0 et -1000 m : ");
        Stock_player = scan1.nextInt();
        
        while(Stock_player < -1000){
            Stock_player = -1000;
            System.out.println("Vous avez dépassé la borne inférieur donc votre stock est positionné par défaut à : " + Stock_player + "m.");
            changerstock();
        }
        while(Stock_player>0){
            Stock_player = 0;
            System.out.println("Vous avez dépassé la borne supérieur donc votre stock est positionné par défaut à : " + Stock_player + "m.");
            changerstock();
        }
        
        
        double d_player = 250;
        double d_IA = 250;
        int compteur = 0;

        while((Stock_IA + 10 < d_player || d_player < Stock_IA - 10) && (Stock_player + 10 < d_IA || d_IA < Stock_player - 10)){
            compteur = compteur + 1;
            System.out.println("Veuillez choisir la puissance de tir entre 50 et 100 % : ");
            Poudre_player = scan1.nextInt();
            while(Poudre_player>100){
                Poudre_player = 100;
                System.out.println("Vous avez dépassé la borne supérieur donc votre puissance est positionné par défaut à : " + Poudre_player + "%.");
                changerpuissance();
            }
            while(Poudre_player<50){
                Poudre_player = 50;
                System.out.println("Vous avez dépassé la borne inférieur donc votre puissance est positionné par défaut à : " + Poudre_player + "%.");
                changerpuissance();
            }
            
            System.out.println("Veuillez choisir l'angle de tir entre 25 et 75° : ");
            Angle_player = scan1.nextInt();
            while(Angle_player>75){
                Angle_player = 75;
                System.out.println("Vous avez dépassé la borne supérieur donc votre angle est positionné par défaut à : " + Angle_player + "°.");
                changerangle();
            }
            while(Angle_player<25){
                Angle_player = 25;
                System.out.println("Vous avez dépassé la borne inférieur donc votre angle est positionné par défaut à : " + Angle_player + "°.");
                changerangle();
            }
            double calcangle_player = Math.sin(2*(Angle_player/(180/Math.PI))) ;
            d_player = ((Math.pow(150*(Poudre_player/100), 2)* calcangle_player)/10);
            System.out.println("Vous avez tiré à :" + d_player + " m.");

            if(Stock_IA + 10 < d_player){
                System.out.println("Votre tir est Trop LONG.");
            }
            else if(d_player < Stock_IA - 10){
                System.out.println("Votre tir est Trop COURT.");
            }
            
            /*COTE IA*/
            double Poudre_IA = rnd.nextInt(50) + 50;
            double Angle_IA =  rnd.nextInt(50) + 25;
            double calcangle_IA = Math.sin(2*(Angle_IA/(180/Math.PI))) ;
            d_IA = -((Math.pow(150*(Poudre_IA/100), 2)* calcangle_IA) /10);
            double d_IA_M = -d_IA +500;
            System.out.println("Votre adversaire a tiré avec une puissance de " + Poudre_IA +" % et un angle de " + Angle_IA+"°.");
            System.out.println("Votre adversaire a donc tiré en : " + d_IA + " soit à :" + d_IA_M + " m de lui.");
                    
        }
        
        if(d_player < Stock_IA + 10 && d_player > Stock_IA - 10){
            System.out.println("Vous avez GAGNER la cible était à " + Stock_IA + "m");
            System.out.println("Votre nombre d'essais est de : " + compteur);
        }
        else if(Stock_player + 10 > d_IA && d_IA > Stock_player - 10){
            System.out.println("Vous avez PERDU la cible était à " + Stock_IA + "m.");
            System.out.println("Votre nombre d'essais est de : " + compteur + ".");
        }
    }
}