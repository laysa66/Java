import java.util.ArrayList;
import java.util.Optional;

import notices.Contributeur;
import notices.NatureContribution;
import notices.NoticeBibliographique;

public class ManipulationBibli {
public static void main(String[] args){
	Contributeur dp=new Contributeur("Pennac", "Daniel");
	Contributeur am=new Contributeur("Mizubayashi", "Akira");
	Contributeur eg=new Contributeur("Gravett", "Emily");
	
	NoticeBibliographique feeCarabine=new NoticeBibliographique("la féé carabine", "1234-5");
	feeCarabine.ajoutContribution(dp, NatureContribution.redaction);
	System.out.println(feeCarabine);
	
	NoticeBibliographique ulvda=new NoticeBibliographique("une langue venue d'ailleurs","2345-6");
	ulvda.ajoutContribution(am, NatureContribution.redaction);
	ulvda.ajoutContribution(dp, NatureContribution.redactionPreface);
	System.out.println(ulvda);
	
	NoticeBibliographique encore=new NoticeBibliographique("Encore", "3456-7");
	ArrayList<NatureContribution> nat=new ArrayList<NatureContribution>();
	nat.add(NatureContribution.redaction);
	nat.add(NatureContribution.illustration);
	encore.ajoutContribution(eg,  nat);
	System.out.println(encore);

	Livre lencore=new Livre(42, encore);
	Livre lencorebis=new Livre(43, encore);

	Bibliotheque bibli=new Bibliotheque();
	bibli.ajoutLivre(lencore);
	bibli.ajoutLivre(lencorebis);

	System.out.println(bibli.getLivreByCode(42));
	Optional<Livre> livre=bibli.getLivreByCodeVersionAvecOptional(44);
	if (livre.isPresent()){
		System.out.println(livre.get());
	}else{
		System.out.println("pas de livre de code 44");
	}


	
}
}
