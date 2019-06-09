import java.util.Scanner ;
public class Restaurant {

	static Scanner scan=new Scanner (System.in);

	public static void main(String[] args) {		
		Scanner scan=new Scanner (System.in);

		System.out.println("Yoo les bgs, cb de tables pour Messieurs ?");


		// Creation de tableau de l'objet Table (avec des null dedans)
		Table [] nbrTables = new Table [ scan.nextInt() ] ;

		// Creation et insertion des tables dans le tableau de Table
		for (int i=0; i<nbrTables.length; i++)
		{
			nbrTables[i] = new Table(0,i) ;
		}

		for(int i=0; i<nbrTables.length; i++)
		{
			System.out.println("Et cb de chaises pour la table "+ ++i);			
			nbrTables[--i].setNbChaise(scan.nextInt());			
		}

		afficheTab(nbrTables);

		int reponse = 0;
		
		do{
			System.out.println(" Choisissez :");

			System.out.println("1) S'asseoir");
			System.out.println("2) partir");
			System.out.println("3) montrer");
			System.out.println("4) degager");

			reponse = scan.nextInt() ;
			switch(reponse)
			{
			case 1: 
				sasseoir(nbrTables) ;				
				break ;
				
			case 2: 
				partir(nbrTables) ;				
				break ;
			case 3: 
				afficheTab(nbrTables) ;				
				break ;
				
			}	
			}while(reponse != 4);
			





	}

	public static void partir(Table [] tab)
	{
		System.out.println("A quelle table êtes-vous assis ? :) ");

		int numtable = scan.nextInt() ;

		for(int i=0; i<tab.length; i++)
		{
			if(tab[i].getNumTable() == numtable) 
			{
				tab[i].setNbChaise(0);
				tab[i].setOccupied(false);
			}
			
		}


	}


	public static void sasseoir(Table [] tab)
	{			
		System.out.println("Cb de personnes êtes-vous ?");

		int personne = scan.nextInt() ;  //   7 personnes
		int max =0 ;

		for(int i=0; i<tab.length; i++)
		{			
			if(tab[i].getNbChaise() >= personne && tab[i].isOccupied()==false)
			{
				tab[i].setOccupied(true);				
				System.out.println("Vous pouvez vous asseoir à la table "+ tab[i].getNumTable());
				break ;
			}
			
				
		}
		System.out.println("Dsl frere on est complet");
		
	}



	public static  void afficheTab(Table [] tab)
	{
		for(int i=0; i<tab.length; i++)
		{			
			System.out.println(tab[i].toString());			
		}
	}


}
