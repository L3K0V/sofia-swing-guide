//
//  TeachersController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/14/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class TeachersController: UIViewController {
    
    @IBOutlet weak var scroll: UIScrollView?
    var topButtonView: UIView?
    var topButtonImage: UIImageView?
    var topButton: UIButton?
    
    let padding:Float = 5
    
    let instrNames:[String] = ["Thomas",
                               "Maeva",
                               "Pontus",
                               "Isabella",
                               "Jb",
                               "Tatiana",
                               "Max",
                               "Audrey",
                               "Thorbjon",
                               "Flora",
                               "Miguel",
                               "Carla",
                               "Sondre",
                               "Tanya",
                               "William",
                               "Maeva",
                               "Oliv Wan",
                               "Nicolas Rodriguez",
                               "Andy Spitz"]
    let instrDescr:[String] = ["Inédit !! Présent pour la deuxième édition de SwingAout Festival c’est avec Maéva que Thomas fera son retour. Deux professeurs très expérimentés qui vous transmettrons tout leur savoir et leurs expertise acquise depuis de nombreuses années partout dans le monde.",
                               "Inédit !! Présent pour la deuxième édition de SwingAout Festival c’est avec Maéva que Thomas fera son retour. Deux professeurs très expérimentés qui vous transmettrons tout leur savoir et leurs expertise acquise depuis de nombreuses années partout dans le monde.",
                               
   "Pour la segonde fois à SwingAout, Isabella et Pontus; des personnages hors normes!! Compétiteurs, showman, ce couple très expérimenté dans toutes les danses swing partagera avec vous sa vision du Lindy Hop et du Boogie Woogie. Avec un brin d’humour et beaucoup de complicité, ces deux danseurs professionnels sauront vous amener dans leur univers de danse, de délire et de bonne humeur.",
    "Pour la segonde fois à SwingAout, Isabella et Pontus; des personnages hors normes!! Compétiteurs, showman, ce couple très expérimenté dans toutes les danses swing partagera avec vous sa vision du Lindy Hop et du Boogie Woogie. Avec un brin d’humour et beaucoup de complicité, ces deux danseurs professionnels sauront vous amener dans leur univers de danse, de délire et de bonne humeur.",
    
    "Travailleurs acharnés avant tout, Jean Batiste et Tatiana ne lésinent pas sur les heures d’entraînement et d’enseignement. Toujours à la recherche de la perfection, ils s’activent depuis plusieurs années à développer la scène swing Montpelliéraine. Avec la bonne humeur de JB et le charme de Tatiana, leurs cours deviennent très vite un endroit privilégié dans lequel on ne veut plus sortir.",
    "Travailleurs acharnés avant tout, Jean Batiste et Tatiana ne lésinent pas sur les heures d’entraînement et d’enseignement. Toujours à la recherche de la perfection, ils s’activent depuis plusieurs années à développer la scène swing Montpelliéraine. Avec la bonne humeur de JB et le charme de Tatiana, leurs cours deviennent très vite un endroit privilégié dans lequel on ne veut plus sortir.",
    
    "On ne présente plus Max Pittruzella, son charisme, son talent influence depuis de nombreuses années bon nombre de danseurs dans le monde entier.\n Très présente dans les soirées et événements internationaux de Swing, Audrey à pour particularité d’être pleine d’énergie et de bonne humeur. Audrey est également compétitrice : elle s’est faite remarquer à plusieurs reprises en atteignant le podium ou même la 1ère place, dans des compétitions européennes de Lindy Hop ou de solo Charleston.",
    "On ne présente plus Max Pittruzella, son charisme, son talent influence depuis de nombreuses années bon nombre de danseurs dans le monde entier.\n Très présente dans les soirées et événements internationaux de Swing, Audrey à pour particularité d’être pleine d’énergie et de bonne humeur. Audrey est également compétitrice : elle s’est faite remarquer à plusieurs reprises en atteignant le podium ou même la 1ère place, dans des compétitions européennes de Lindy Hop ou de solo Charleston.",
    
    "Nos champions de Boogie Woogie!! Dernièrement sacré champion du monde de Boogie ce couple ne cesse de progresser et de relever les challenges.\n Des compétiteurs exceptionnels, des  professeurs expérimentés, c’est avec beaucoup de gentillesse et d’humilité que Torbjorn et Flora combleront toutes vos attentes.",
    "Nos champions de Boogie Woogie!! Dernièrement sacré champion du monde de Boogie ce couple ne cesse de progresser et de relever les challenges.\n Des compétiteurs exceptionnels, des  professeurs expérimentés, c’est avec beaucoup de gentillesse et d’humilité que Torbjorn et Flora combleront toutes vos attentes.",
    
    "Très bon danseur social, il a déjà remporté en cette année 2015, plusieurs Jack et Jill comme Barswingona, Gastroswing et Small Paradise. Au cours des 6 dernières années, il a participé à plus de 30 ateliers dans le monde entier comme ILHC, Herrang, Swing Août etc… afin qu’il puisse apprendre des meilleurs danseurs du monde. Il est professeur de Lindy Hop, Jazz, Routines et Acrobaties.\n Carla Saz, une passionnée de la danse est non seulement une enseignante de Lindy Hop, mais aussi une professeur de musique.\n Être presents dans leurs classes, vous donnera la possibilité d’absorber leur style unique et leur technique raffinée.",
    "Très bon danseur social, il a déjà remporté en cette année 2015, plusieurs Jack et Jill comme Barswingona, Gastroswing et Small Paradise. Au cours des 6 dernières années, il a participé à plus de 30 ateliers dans le monde entier comme ILHC, Herrang, Swing Août etc… afin qu’il puisse apprendre des meilleurs danseurs du monde. Il est professeur de Lindy Hop, Jazz, Routines et Acrobaties.\n Carla Saz, une passionnée de la danse est non seulement une enseignante de Lindy Hop, mais aussi une professeur de musique.\n Être presents dans leurs classes, vous donnera la possibilité d’absorber leur style unique et leur technique raffinée.",
    
    "Tanya started dancing at the age of 4 with classing choreography, later switching to acrobatic rock-n-roll. School years added more boogie-woogie, ballet jazz and contemporary to her life. She started cometing internationaly in 2011 and in 2013 won 4 World Cups in boogie-woogie. Now she is teachign boogie-woogie internationally.  Sondre has been dancing swing since he was 6. After winning World Championship in boogie-woogie juniors in 2011 he started also teaching. At the moment he enriches his dancing experience with lindy-hop and charleston.",
    "Tanya started dancing at the age of 4 with classing choreography, later switching to acrobatic rock-n-roll. School years added more boogie-woogie, ballet jazz and contemporary to her life. She started cometing internationaly in 2011 and in 2013 won 4 World Cups in boogie-woogie. Now she is teachign boogie-woogie internationally.  Sondre has been dancing swing since he was 6. After winning World Championship in boogie-woogie juniors in 2011 he started also teaching. At the moment he enriches his dancing experience with lindy-hop and charleston.",
    
    "William et Maéva sont tous deux originaires du sud de la France.  Ils se sont rencontrés à l’âge de 14 ans sur les planchers de compétitions.  Après plusieurs années consacrées au Boogie Woogie où ils ont été sacrés champions du monde WRRC à 4 reprises (2005, 2008, 2009 et 2010)\n Ils enseignent désormais dans les plus grands événements swing mondiaux.  Ils ont la particularité de rester eux-mêmes en toutes circonstances et d’assumer leur identité.\n Ces petits danseurs par la taille seront vous transporter dans leur univers plein de talents, d’humour, de génie et de générosité qu’ils s’empressent de partager avec le plus grand nombre de personnes.",
    "William et Maéva sont tous deux originaires du sud de la France.  Ils se sont rencontrés à l’âge de 14 ans sur les planchers de compétitions.  Après plusieurs années consacrées au Boogie Woogie où ils ont été sacrés champions du monde WRRC à 4 reprises (2005, 2008, 2009 et 2010)\n Ils enseignent désormais dans les plus grands événements swing mondiaux.  Ils ont la particularité de rester eux-mêmes en toutes circonstances et d’assumer leur identité.\n Ces petits danseurs par la taille seront vous transporter dans leur univers plein de talents, d’humour, de génie et de générosité qu’ils s’empressent de partager avec le plus grand nombre de personnes.",
    
    "Oliv Wan a appris à danser à Montpellier en 2006 avec Tommy Blacharz chez les Swingjammerz dont il fait toujours parti à ce jour.\n En 2009 il lance au Japon le projet I Charleston the World sur Utube qui a connu un essor considérable par la suite.\n De très nombreuses villes sont aujourd’hui représentées comme New York, Paris, Berlin…\n Admirateur des danseurs anciens, son inspiration provient d’artistes comme Frankie Manning, Al Minns, John Bubbles et les Nicholas Brothers.Son enseignement s’articule autour de fondamentaux solides de rythme et de fluidité tout en en accordant une part importante à la musicalité.",
    
    "Amoureux du jazz swing des années 30 et 40 et DJ à l’occasion, tout cela le mène naturellement à la découverte du Lindy Hop, puis du Balboa en 2002 à Herrang (Suède) où il rencontrera Frankie Manning. Dès sa première année de compétition, en Lindy Hop, il se classe sur les podiums avec un titre de vice-champion de France en 2003 et une place de demi-finaliste des championnats du monde en 2004.",
    
    "Sa vision de la danse swing est largement basé sur les réactions naturelles du corps, visant à optimiser son utilisation dans le mouvement ainsi que l’énergie créée au sein du couple.\n Son style unique et distinctif provient de l’inspiration de diverses sources telles que les danses de rue, danse traditionnelle, et de danseurs comme Gene Kelly, Fred Astaire …Son enseignement se concentre sur le développement de la connexion, la légèreté du mouvement dans la danse, la connaissance et la maîtrise du corps, afin de créer un style de danse unique à chacun."]
    
    
    let instrImages:[String] = ["thomas", "maeva", "pontus", "isabella", "JB", "Tat", "Max", "audrey", "Thorbjorn", "Flora", "Miguel", "carla", "sondre", "tanya", "william", "maeva", "oliv", "nico", "andy"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv

        self.navigationItem.title = "Swing Aout"
        
//        topButtonView = UIView(frame: CGRectMake(CGFloat(padding)+5, CGFloat(padding), view.frame.width-CGFloat(2*padding), 204))
//        topButtonView?.backgroundColor = UIColor.whiteColor()
//        scroll!.addSubview(topButtonView!)
//        
//        let imgContainer:UIView = UIView (frame: CGRectMake(2, 2, (topButtonView?.frame.width)!-4, 200))
//        imgContainer.clipsToBounds = true
//        topButtonView?.addSubview(imgContainer)
//        
//        let topImg:UIImage = UIImage (named: "WM")!
//        topButtonImage = UIImageView (image: topImg)
//        var f = topButtonImage?.frame
//        let r = (view.frame.width-CGFloat(2*padding) - 4)/(f?.size.width)!
//        f?.size.width = view.frame.width-CGFloat(2*padding) - 4
//        f?.size.height = r*(f?.size.height)!
//        f?.origin.x = 0
//        f?.origin.y = 0
//        topButtonImage?.frame = f!
//        imgContainer.addSubview(topButtonImage!)
//        
//        topButton = UIButton (frame: topButtonView!.frame)
//        topButton?.addTarget(self, action: #selector(gotoInstructorPage), forControlEvents: .TouchUpInside)
//        topButton?.tag = 6
//        scroll?.addSubview(topButton!)
        
//        applyPlainShadow(topButtonView!)
        
        var i:Int = 0
        while i < instrNames.count {
            addView(i)
            
            i += 1
        }
    }

    func addView (_ i:Int) {
        let w = (Float(view.frame.size.width) - padding*3)/2
        let x = padding + Float(i%2) * (w+padding) + 5
        var y = (padding)//Float((topButtonView?.frame.maxY)!)
        y = y + padding + floor (Float(i/2)) * (w+padding)
        let v:UIView = UIView (frame: CGRect(x: CGFloat(x), y: CGFloat(y), width: CGFloat(w), height: CGFloat(w)))
        
        let iv:UIImageView  = UIImageView (image: UIImage (named: instrImages[i]))
        iv.frame = CGRect (x: 2, y: 2, width: CGFloat(w-4), height: CGFloat(w-4))
        iv.contentMode = .scaleAspectFill
        iv.clipsToBounds = true
        v.addSubview (iv)
        
        applyPlainShadow(v)
        v.backgroundColor = UIColor.white
        
        let b:UIButton = UIButton (frame: CGRect(x: CGFloat(0), y: CGFloat(0), width: CGFloat(w), height: CGFloat(w)))
        b.tag = i
        b.addTarget(self, action: #selector(gotoInstructorPage), for: .touchUpInside)
        v.addSubview(b)
        
        scroll!.addSubview(v)
        
        scroll!.contentSize = CGSize (width: view.frame.size.width, height: v.frame.maxY + CGFloat(padding))
    }

    func applyPlainShadow(_ v: UIView) {
        let layer = v.layer
        
        layer.shadowColor = UIColor.black.cgColor
        layer.shadowOffset = CGSize.zero
        layer.shadowOpacity = 0.4
        layer.shadowRadius = 3
    }
    
    func gotoInstructorPage (_ sender: UIButton!) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc:InstructorPageViewController = storyboard.instantiateViewController(withIdentifier: "InstructorPage") as! InstructorPageViewController
        vc.titleText = instrNames[sender.tag]
        vc.descriptionText = instrDescr[sender.tag]
        vc.imageName = instrImages[sender.tag]
        self.navigationController?.pushViewController(vc, animated: true)
    }
}
