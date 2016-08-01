package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.TeachersAdapter;

/**
 * Created by mmironov on 1/4/16.
 */
public class TeachersFragment extends Fragment {

    public static final String TAG = "TeachersFragment";

    public TeachersFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_teachers, container, false);
        final RecyclerView teachersView = (RecyclerView) view.findViewById(R.id.teachers);
        teachersView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if (position == 0) {
                    return 2;
                }

                return 1;
            }
        });

        teachersView.setLayoutManager(layoutManager);

        List<Teacher> teachers = new ArrayList<>();

        Teacher thomas = new Teacher();
        thomas.setName("Thomas");
        thomas.setDescription("Inédit !! Présent pour la deuxième édition de SwingAout Festival c’est avec Maéva que Thomas fera son retour. Deux professeurs très expérimentés qui vous transmettrons tout leur savoir et leurs expertise acquise depuis de nombreuses années partout dans le monde.");
        thomas.setResDrawable(R.drawable.unnamed);

        Teacher maeva = new Teacher();
        maeva.setName("Maéva");
        maeva.setDescription("Inédit !! Présent pour la deuxième édition de SwingAout Festival c’est avec Maéva que Thomas fera son retour. Deux professeurs très expérimentés qui vous transmettrons tout leur savoir et leurs expertise acquise depuis de nombreuses années partout dans le monde.");
        maeva.setResDrawable(R.drawable.maeva);

        Teacher pontus = new Teacher();
        pontus.setName("Pontus");
        pontus.setDescription("Pour la segonde fois à SwingAout, Isabella et Pontus; des personnages hors normes!! Compétiteurs, showman, ce couple très expérimenté dans toutes les danses swing partagera avec vous sa vision du Lindy Hop et du Boogie Woogie. Avec un brin d’humour et beaucoup de complicité, ces deux danseurs professionnels sauront vous amener dans leur univers de danse, de délire et de bonne humeur.");
        pontus.setResDrawable(R.drawable.pontus);


        Teacher isabella = new Teacher();
        isabella.setName("Isabella");
        isabella.setDescription("Pour la segonde fois à SwingAout, Isabella et Pontus; des personnages hors normes!! Compétiteurs, showman, ce couple très expérimenté dans toutes les danses swing partagera avec vous sa vision du Lindy Hop et du Boogie Woogie. Avec un brin d’humour et beaucoup de complicité, ces deux danseurs professionnels sauront vous amener dans leur univers de danse, de délire et de bonne humeur.");
        isabella.setResDrawable(R.drawable.isabella);

        Teacher jb = new Teacher();
        jb.setName("JB");
        jb.setDescription("Travailleurs acharnés avant tout, Jean Batiste et Tatiana ne lésinent pas sur les heures d’entraînement et d’enseignement. Toujours à la recherche de la perfection, ils s’activent depuis plusieurs années à développer la scène swing Montpelliéraine. Avec la bonne humeur de JB et le charme de Tatiana, leurs cours deviennent très vite un endroit privilégié dans lequel on ne veut plus sortir.");
        jb.setResDrawable(R.drawable.jb);

        Teacher tatiana = new Teacher();
        tatiana.setName("Tatiana");
        tatiana.setDescription("Travailleurs acharnés avant tout, Jean Batiste et Tatiana ne lésinent pas sur les heures d’entraînement et d’enseignement. Toujours à la recherche de la perfection, ils s’activent depuis plusieurs années à développer la scène swing Montpelliéraine. Avec la bonne humeur de JB et le charme de Tatiana, leurs cours deviennent très vite un endroit privilégié dans lequel on ne veut plus sortir.");
        tatiana.setResDrawable(R.drawable.tat);

        Teacher max = new Teacher();
        max.setName("Max");
        max.setDescription("On ne présente plus Max Pittruzella, son charisme, son talent influence depuis de nombreuses années bon nombre de danseurs dans le monde entier.\u2028Très présente dans les soirées et événements internationaux de Swing, Audrey à pour particularité d’être pleine d’énergie et de bonne humeur. Audrey est également compétitrice : elle s’est faite remarquer à plusieurs reprises en atteignant le podium ou même la 1ère place, dans des compétitions européennes de Lindy Hop ou de solo Charleston.\n");
        max.setResDrawable(R.drawable.max);

        Teacher audrey = new Teacher();
        audrey.setName("Audrey");
        audrey.setDescription("On ne présente plus Max Pittruzella, son charisme, son talent influence depuis de nombreuses années bon nombre de danseurs dans le monde entier.\u2028Très présente dans les soirées et événements internationaux de Swing, Audrey à pour particularité d’être pleine d’énergie et de bonne humeur. Audrey est également compétitrice : elle s’est faite remarquer à plusieurs reprises en atteignant le podium ou même la 1ère place, dans des compétitions européennes de Lindy Hop ou de solo Charleston.");
        audrey.setResDrawable(R.drawable.audrey);

        Teacher thorbjon = new Teacher();
        thorbjon.setName("Thorbjon");
        thorbjon.setDescription("Nos champions de Boogie Woogie!! Dernièrement sacré champion du monde de Boogie ce couple ne cesse de progresser et de relever les challenges.\u2028Des compétiteurs exceptionnels, des  professeurs expérimentés, c’est avec beaucoup de gentillesse et d’humilité que Torbjorn et Flora combleront toutes vos attentes.\n");
        thorbjon.setResDrawable(R.drawable.thorbjorn);

        Teacher flora = new Teacher();
        flora.setName("Flora");
        flora.setDescription("Nos champions de Boogie Woogie!! Dernièrement sacré champion du monde de Boogie ce couple ne cesse de progresser et de relever les challenges.\u2028Des compétiteurs exceptionnels, des  professeurs expérimentés, c’est avec beaucoup de gentillesse et d’humilité que Torbjorn et Flora combleront toutes vos attentes.\n");
        flora.setResDrawable(R.drawable.flora);

        Teacher miguel = new Teacher();
        miguel.setName("Miguel");
        miguel.setDescription("Très bon danseur social, il a déjà remporté en cette année 2015, plusieurs Jack et Jill comme Barswingona, Gastroswing et Small Paradise. Au cours des 6 dernières années, il a participé à plus de 30 ateliers dans le monde entier comme ILHC, Herrang, Swing Août etc… afin qu’il puisse apprendre des meilleurs danseurs du monde. Il est professeur de Lindy Hop, Jazz, Routines et Acrobaties.\u2028Carla Saz, une passionnée de la danse est non seulement une enseignante de Lindy Hop, mais aussi une professeur de musique.\u2028Être presents dans leurs classes, vous donnera la possibilité d’absorber leur style unique et leur technique raffinée.");
        miguel.setResDrawable(R.drawable.miguel);

        Teacher carla = new Teacher();
        carla.setName("Carla");
        carla.setDescription("Très bon danseur social, il a déjà remporté en cette année 2015, plusieurs Jack et Jill comme Barswingona, Gastroswing et Small Paradise. Au cours des 6 dernières années, il a participé à plus de 30 ateliers dans le monde entier comme ILHC, Herrang, Swing Août etc… afin qu’il puisse apprendre des meilleurs danseurs du monde. Il est professeur de Lindy Hop, Jazz, Routines et Acrobaties.\u2028Carla Saz, une passionnée de la danse est non seulement une enseignante de Lindy Hop, mais aussi une professeur de musique.\u2028Être presents dans leurs classes, vous donnera la possibilité d’absorber leur style unique et leur technique raffinée.");
        carla.setResDrawable(R.drawable.carla);

        Teacher sondre = new Teacher();
        sondre.setName("Sondre");
        sondre.setDescription("Sondre has been dancing swing since he was 6. After winning World Championship in boogie-woogie juniors in 2011 he started also teaching. At the moment he enriches his dancing experience with lindy-hop and charleston.");
        sondre.setResDrawable(R.drawable.sondre);

        Teacher tanya = new Teacher();
        tanya.setName("Tanya");
        tanya.setDescription("Tanya started dancing at the age of 4 with classing choreography, later switching to acrobatic rock-n-roll. School years added more boogie-woogie, ballet jazz and contemporary to her life. She started cometing internationaly in 2011 and in 2013 won 4 World Cups in boogie-woogie. Now she is teachign boogie-woogie internationally.");
        tanya.setResDrawable(R.drawable.tanya);

        Teacher william = new Teacher();
        william.setName("Tanya");
        william.setDescription("William et Maéva sont tous deux originaires du sud de la France.  Ils se sont rencontrés à l’âge de 14 ans sur les planchers de compétitions.  Après plusieurs années consacrées au Boogie Woogie où ils ont été sacrés champions du monde WRRC à 4 reprises (2005, 2008, 2009 et 2010)\u2028Ils enseignent désormais dans les plus grands événements swing mondiaux.  Ils ont la particularité de rester eux-mêmes en toutes circonstances et d’assumer leur identité.\u2028Ces petits danseurs par la taille seront vous transporter dans leur univers plein de talents, d’humour, de génie et de générosité qu’ils s’empressent de partager avec le plus grand nombre de personnes.");
        william.setResDrawable(R.drawable.william);

        Teacher oliv = new Teacher();
        oliv.setName("Oliv Wan");
        oliv.setDescription("Oliv Wan a appris à danser à Montpellier en 2006 avec Tommy Blacharz chez les Swingjammerz dont il fait toujours parti à ce jour.\u2028En 2009 il lance au Japon le projet I Charleston the World sur Utube qui a connu un essor considérable par la suite.\u2028De très nombreuses villes sont aujourd’hui représentées comme New York, Paris, Berlin…\u2028Admirateur des danseurs anciens, son inspiration provient d’artistes comme Frankie Manning, Al Minns, John Bubbles et les Nicholas Brothers.Son enseignement s’articule autour de fondamentaux solides de rythme et de fluidité tout en en accordant une part importante à la musicalité.");
        oliv.setResDrawable(R.drawable.oliv);

        Teacher nicolas = new Teacher();
        nicolas.setName("Nicolas RodrigueZ");
        nicolas.setDescription("Amoureux du jazz swing des années 30 et 40 et DJ à l’occasion, tout cela le mène naturellement à la découverte du Lindy Hop, puis du Balboa en 2002 à Herrang (Suède) où il rencontrera Frankie Manning. Dès sa première année de compétition, en Lindy Hop, il se classe sur les podiums avec un titre de vice-champion de France en 2003 et une place de demi-finaliste des championnats du monde en 2004.");
        nicolas.setResDrawable(R.drawable.nico);

        Teacher andy = new Teacher();
        andy.setName("Andy Spitz");
        andy.setDescription("Sa vision de la danse swing est largement basé sur les réactions naturelles du corps, visant à optimiser son utilisation dans le mouvement ainsi que l’énergie créée au sein du couple.\n" +
                "Son style unique et distinctif provient de l’inspiration de diverses sources telles que les danses de rue, danse traditionnelle, et de danseurs comme Gene Kelly, Fred Astaire …Son enseignement se concentre sur le développement de la connexion, la légèreté du mouvement dans la danse, la connaissance et la maîtrise du corps, afin de créer un style de danse unique à chacun.\n");
        andy.setResDrawable(R.drawable.andy);

        teachers.add(thomas);
        teachers.add(maeva);
        teachers.add(pontus);
        teachers.add(isabella);
        teachers.add(jb);
        teachers.add(tatiana);
        teachers.add(max);
        teachers.add(audrey);
        teachers.add(thorbjon);
        teachers.add(flora);
        teachers.add(miguel);
        teachers.add(carla);
        teachers.add(sondre);
        teachers.add(tanya);
        teachers.add(william);
        teachers.add(oliv);
        teachers.add(nicolas);


        Collections.shuffle(teachers);

        teachers.get(0).setIsFeatured(true);

        TeachersAdapter adapter = new TeachersAdapter(teachers);

        teachersView.setAdapter(adapter);

        return view;
    }
}
