package com.example.quote_api.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.quote_api.model.Quote;
import com.example.quote_api.repository.QuoteRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private QuoteRepository quoteRepository;

	public DataLoader(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Vérifier si la base contient déjà des citations
		if (quoteRepository.count() == 0) {
			// Si aucune citation, insérer les 95 citations par exemple
			quoteRepository.save(
					new Quote("La vie, c’est comme une bicyclette, il faut avancer pour ne pas perdre l’équilibre.",
							"Albert Einstein"));
			quoteRepository
					.save(new Quote("Le succès, c’est tomber sept fois et se relever huit.", "Proverbe japonais"));
			quoteRepository
					.save(new Quote("La seule limite à notre épanouissement de demain sera nos doutes d’aujourd’hui.",
							"Franklin D. Roosevelt"));
			quoteRepository
					.save(new Quote("Soyez le changement que vous voulez voir dans le monde.", "Mahatma Gandhi"));
			quoteRepository
					.save(new Quote("Il n’y a pas de chemin vers le bonheur, le bonheur est le chemin.", "Bouddha"));
			quoteRepository.save(new Quote("Tout ce que vous pouvez imaginer est réel.", "Pablo Picasso"));
			quoteRepository
					.save(new Quote("Le seul véritable échec est celui dont on ne tire aucune leçon.", "John Powell"));
			quoteRepository.save(new Quote(
					"Votre temps est limité, ne le gâchez pas en menant une existence qui n’est pas la vôtre.",
					"Steve Jobs"));
			quoteRepository.save(new Quote(
					"La vie n’est pas d’attendre que l’orage passe, c’est d’apprendre à danser sous la pluie.",
					"Sénèque"));
			quoteRepository
					.save(new Quote("La meilleure façon de prédire l’avenir, c’est de le créer.", "Peter Drucker"));
			quoteRepository.save(new Quote("On ne voit bien qu’avec le cœur, l’essentiel est invisible pour les yeux.",
					"Antoine de Saint-Exupéry"));
			quoteRepository.save(
					new Quote("Ne jugez pas chaque jour à la récolte que vous faites, mais aux graines que vous semez.",
							"Robert Louis Stevenson"));
			quoteRepository.save(new Quote("Le succès n’est pas la clé du bonheur. Le bonheur est la clé du succès.",
					"Albert Schweitzer"));
			quoteRepository.save(new Quote("Croyez en vous et tout sera possible.", "Anonyme"));
			quoteRepository
					.save(new Quote("Ne craignez pas la perfection, vous ne l’atteindrez jamais.", "Salvador Dalí"));
			quoteRepository.save(new Quote("Le courage, c’est de comprendre sa propre vie.", "Jean Jaurès"));
			quoteRepository.save(
					new Quote("La seule façon de faire du bon travail est d’aimer ce que vous faites.", "Steve Jobs"));
			quoteRepository.save(new Quote("L’imagination est plus importante que le savoir.", "Albert Einstein"));
			quoteRepository.save(
					new Quote("La seule chose que l’on puisse décider est quoi faire du temps qui nous est imparti.",
							"J.R.R. Tolkien"));
			quoteRepository.save(new Quote("Le plus grand risque est de ne jamais en prendre.", "Mark Zuckerberg"));
			quoteRepository.save(new Quote("Faites ce que vous pouvez, avec ce que vous avez, là où vous êtes.",
					"Theodore Roosevelt"));
			quoteRepository.save(new Quote("Le bonheur ne dépend pas de ce que vous avez, mais de ce que vous pensez.",
					"Dale Carnegie"));
			quoteRepository
					.save(new Quote("Un voyage de mille lieues commence toujours par un premier pas.", "Lao Tseu"));
			quoteRepository.save(new Quote("La créativité, c’est l’intelligence qui s’amuse.", "Albert Einstein"));
			quoteRepository.save(new Quote("L’avenir appartient à ceux qui croient en la beauté de leurs rêves.",
					"Eleanor Roosevelt"));
			quoteRepository.save(new Quote("La vie est faite de choix.", "Anonyme"));
			quoteRepository.save(new Quote("On ne devient pas grand en restant petit.", "Anonyme"));
			quoteRepository.save(new Quote("Le plus grand échec est de ne pas avoir essayé.", "George Clooney"));
			quoteRepository.save(new Quote("La patience est amère, mais son fruit est doux.", "Jean-Jacques Rousseau"));
			quoteRepository.save(new Quote("Chaque jour est une nouvelle chance de faire mieux.", "Anonyme"));
			quoteRepository.save(new Quote("Les rêves donnent du travail.", "Paulo Coelho"));
			quoteRepository.save(new Quote("Ce n’est pas la force, mais la persévérance qui fait les grandes œuvres.",
					"Samuel Johnson"));
			quoteRepository.save(new Quote("Soyez vous-même, tous les autres sont déjà pris.", "Oscar Wilde"));
			quoteRepository.save(new Quote("Ne laissez jamais le doute vous empêcher d’avancer.", "Anonyme"));
			quoteRepository.save(
					new Quote("La connaissance s’acquiert par l’expérience, tout le reste n’est que de l’information.",
							"Albert Einstein"));
			quoteRepository
					.save(new Quote("Ne regarde pas en arrière, tu ne vas pas dans cette direction.", "Anonyme"));
			quoteRepository.save(
					new Quote("Rien n’est impossible, le mot lui-même dit : 'Je suis possible' !", "Audrey Hepburn"));
			quoteRepository.save(
					new Quote("Le succès est la somme de petits efforts répétés jour après jour.", "Robert Collier"));
			quoteRepository
					.save(new Quote("La vie commence là où finit votre zone de confort.", "Neale Donald Walsch"));
			quoteRepository.save(new Quote("N’abandonnez jamais un rêve pour le temps qu’il faut pour le réaliser.",
					"Earl Nightingale"));
			quoteRepository.save(
					new Quote("Ce que vous faites aujourd’hui peut améliorer tous vos lendemains.", "Ralph Marston"));
			quoteRepository.save(new Quote("Les opportunités ne se produisent pas, vous les créez.", "Chris Grosser"));
			quoteRepository
					.save(new Quote("Ne vous souciez pas d’être meilleur que les autres. Soyez meilleur que vous-même.",
							"William Faulkner"));
			quoteRepository.save(new Quote("L’échec n’est qu’un tremplin vers la réussite.", "Oprah Winfrey"));
			quoteRepository.save(new Quote("Votre avenir est créé par ce que vous faites aujourd’hui, pas demain.",
					"Robert Kiyosaki"));
			quoteRepository.save(new Quote("Chaque difficulté rencontrée doit être l’occasion d’un nouveau progrès.",
					"Pierre de Coubertin"));
			quoteRepository.save(
					new Quote("Celui qui déplace une montagne commence par déplacer de petites pierres.", "Confucius"));
			quoteRepository.save(new Quote("Ne comptez pas les jours, faites que les jours comptent.", "Muhammad Ali"));
			quoteRepository.save(new Quote("Seul, on va plus vite. Ensemble, on va plus loin.", "Proverbe africain"));
			quoteRepository.save(new Quote("Croyez que vous pouvez et vous êtes à mi-chemin.", "Theodore Roosevelt"));
			quoteRepository.save(new Quote("Chaque grand voyage commence par un premier pas.", "Lao Tseu"));
			quoteRepository.save(new Quote(
					"Apprenez des erreurs des autres. Vous ne vivrez pas assez longtemps pour toutes les faire vous-même.",
					"Eleanor Roosevelt"));
			quoteRepository
					.save(new Quote("La seule limite à notre épanouissement de demain sera nos doutes d’aujourd’hui.",
							"Franklin D. Roosevelt"));
			quoteRepository
					.save(new Quote("Le plus grand échec est de ne jamais avoir essayé.", "George Bernard Shaw"));
			quoteRepository.save(
					new Quote("Ne laissez pas le bruit des opinions des autres étouffer votre propre voix intérieure.",
							"Steve Jobs"));
			quoteRepository
					.save(new Quote("La meilleure préparation pour demain est de faire de votre mieux aujourd’hui.",
							"H. Jackson Brown, Jr."));
			quoteRepository.save(new Quote("Soyez réaliste : demandez l’impossible.", "Che Guevara"));
			quoteRepository.save(
					new Quote("Tout ce que l’esprit peut concevoir et croire, il peut le réaliser.", "Napoleon Hill"));
			quoteRepository.save(new Quote("Là où se trouve une volonté, il existe un chemin.", "Winston Churchill"));
			quoteRepository.save(new Quote(
					"La vie est trop courte pour la passer à regretter tout ce qu’on n’a pas eu le courage de faire.",
					"Anonyme"));
			quoteRepository
					.save(new Quote("Le meilleur moyen de prévoir le futur, c’est de le créer.", "Peter Drucker"));
			quoteRepository.save(new Quote("Chaque jour est une nouvelle chance de changer votre vie.", "Anonyme"));
			quoteRepository
					.save(new Quote("N’ayez pas peur d’échouer, ayez peur de ne pas essayer.", "Michael Jordan"));
			quoteRepository.save(new Quote("Le succès, c’est d’aller d’échec en échec sans perdre son enthousiasme.",
					"Winston Churchill"));
			quoteRepository.save(new Quote(
					"Ce n’est pas parce que les choses sont difficiles que nous n’osons pas. C’est parce que nous n’osons pas qu’elles sont difficiles.",
					"Sénèque"));
			quoteRepository.save(new Quote("Votre vie est la somme de vos choix.", "Albert Camus"));
			quoteRepository.save(new Quote(
					"Tout le monde est un génie. Mais si vous jugez un poisson sur sa capacité à grimper à un arbre, il passera sa vie à croire qu’il est stupide.",
					"Albert Einstein"));
			quoteRepository.save(new Quote("Le futur appartient à ceux qui se lèvent tôt.", "Proverbe français"));
			quoteRepository.save(new Quote(
					"La seule chose qui se dresse entre vous et votre objectif, c’est l’histoire que vous continuez de vous raconter pour expliquer pourquoi vous ne pouvez pas l’atteindre.",
					"Jordan Belfort"));
			quoteRepository
					.save(new Quote("N’abandonnez pas. Souffrez maintenant et vivez le reste de votre vie en champion.",
							"Muhammad Ali"));
			quoteRepository.save(
					new Quote("L’art de la réussite consiste à savoir s’entourer des meilleurs.", "John F. Kennedy"));
			quoteRepository.save(new Quote("Votre avenir dépend de ce que vous faites aujourd’hui.", "Mahatma Gandhi"));
			quoteRepository.save(new Quote(
					"Le succès ne consiste pas à ne jamais faire d’erreur mais à ne jamais faire la même deux fois.",
					"George Bernard Shaw"));
			quoteRepository
					.save(new Quote("La motivation vous sert de départ. L’habitude vous fait continuer.", "Jim Ryun"));
			quoteRepository.save(new Quote(
					"Pour réussir, il ne suffit pas de prévoir. Il faut aussi savoir improviser.", "Isaac Asimov"));
			quoteRepository.save(new Quote(
					"L’échec est seulement l’opportunité de recommencer d’une façon plus intelligente.", "Henry Ford"));
			quoteRepository
					.save(new Quote("La vie est courte. Faites en sorte qu’elle soit douce.", "Proverbe persan"));
			quoteRepository.save(
					new Quote("Le plus grand secret du bonheur, c’est d’être bien avec soi.", "Bernard Fontenelle"));
			quoteRepository.save(new Quote("Rêvez grand et osez échouer.", "Norman Vaughan"));
			quoteRepository.save(
					new Quote("Ne vous arrêtez pas lorsque vous êtes fatigué, arrêtez-vous lorsque vous avez terminé.",
							"Anonyme"));
			quoteRepository.save(new Quote("Apprenez à aimer le processus et les résultats suivront.", "Anonyme"));
			quoteRepository.save(new Quote("Ne laissez pas hier prendre trop de place aujourd’hui.", "Will Rogers"));
			quoteRepository.save(new Quote(
					"La réussite appartient à tout le monde. C’est le travail d’équipe qui en décide.", "Anonyme"));
			quoteRepository.save(
					new Quote("Vous ne pouvez traverser la mer simplement en restant debout et en regardant l’eau.",
							"Rabindranath Tagore"));
			quoteRepository.save(new Quote(
					"La seule façon d’accomplir l’impossible, c’est de croire que c’est possible.", "Lewis Carroll"));
			quoteRepository.save(new Quote(
					"Le secret du changement, c’est de concentrer toute votre énergie non pas à combattre le passé, mais à construire l’avenir.",
					"Socrate"));
			quoteRepository.save(new Quote("N’ayez pas peur d’avancer lentement, ayez peur de rester immobile.",
					"Proverbe chinois"));
			quoteRepository.save(new Quote(
					"Le véritable voyage de découverte ne consiste pas à chercher de nouveaux paysages, mais à avoir de nouveaux yeux.",
					"Marcel Proust"));
			quoteRepository.save(new Quote(
					"Ce que vous pensez, vous le devenez. Ce que vous ressentez, vous l’attirez. Ce que vous imaginez, vous le créez.",
					"Bouddha"));
			quoteRepository.save(
					new Quote("Celui qui veut réussir trouve un moyen. Celui qui ne veut rien faire trouve une excuse.",
							"Proverbe arabe"));
			quoteRepository.save(new Quote("Ne laissez personne éteindre votre lumière.", "Anonyme"));
			quoteRepository.save(new Quote("Le courage n’est pas l’absence de peur, mais la capacité de la vaincre.",
					"Nelson Mandela"));
			quoteRepository.save(new Quote(
					"Faites ce que vous aimez et vous ne travaillerez plus un seul jour de votre vie.", "Confucius"));
			quoteRepository.save(new Quote("La seule chose que vous pouvez contrôler, c’est votre attitude.",
					"Charles R. Swindoll"));
			quoteRepository.save(new Quote("Un objectif sans plan n’est qu’un souhait.", "Antoine de Saint-Exupéry"));
		}
	}
}
