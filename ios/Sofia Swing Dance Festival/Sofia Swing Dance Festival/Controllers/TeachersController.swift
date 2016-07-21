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
    
    let instrNames:[String] = ["Felipe Braga", "Alice Meï", "Max Pitruzzella", "Audrey Dа Sois", "Ryan Francois", "Evgenia Salakhutdinova", "William & Maeva"]
    let instrDescr:[String] = ["Do you feel some kind of a Brazilian breeze passing by? Quite unusual occurrence for the Balkans, isn’t it? Oh, but yes – it is Felipe Braga! He was born in Brazil and maybe that is part of the reason he is such a passionate dancer. At some point, he was amazed by the dancing movements that Jazz music can create and ever since, he is unstoppable.\n\nHis whole life path is like a recipe for reaching that current moment. Theatrical acting, playing drums, party-animator for a live music club in Brazil – these activities, quite different from each other, actually helped him a lot! He is very enthusiastic for social dancing and even if you are just watching him, you can feel how much fun it is! Felipe loves to exchange energy in the jam circles, as well as in the competitions or professional performances. Now, he lives in Munich, Germany so he can teach Lindy Hop and Authentic Jazz at Vintage Club. Also, this year you can see his name in the Herrang Dance Camp schedule. We can’t wait to meet him at our dance floor!",
   "We have all read/watched or at least heard of “Alice in Wonderland”. There is something really special about this heroine with her specific charm and fascinating personality. Alice Meï is probably this girl come true in the real world… but with dancing shoes.\n\nAlice started dancing at the age of 4. By the time she turned 14 she had the honor of interpreting almost every single Disney character from “Dopey” to “Tinker-Bell”. She eventually joined a national dance school for another 4 years where she practiced ballet, contemporary and jazz dance daily. Slowly burning out with these dance styles, she began to look for something new. After a few unsuccessful attempts at African dancing, flamenco, and kick boxing she eventually met her true love – Lindy Hop!\n\nAlice is definitely at her happiest when she is swingin’ it on the dance floor.You will most likely hear her giggling from the other side of the room when she is social dancing. Alice enjoys keeping her dancing simple and natural. It seems like her silliness has reached enough people since she won the “dancers choice award” at ULHS in 2006. In class, she teaches the same principals that she cherishes as a dancer and she mainly focuses on keeping things simple and in a nice rhythm.",
    "Well… you know how no matter what the occasion is, there is always that one guy that everyone has noticed and in the end you are all watching with your mouth open. Yeap, this shall be Max Pitruzzella. The amazing Max!\n\nHe is originally from Montpellier (France), but now he is teaching every weekend in a different city worldwide. He is passionate about sharing his understanding of all the details that create a good connection between partners and give the most energy to the Lindy Hop. He is dedicated to spread the passion of swing all over the world, pursuing Frankie Manning’s vision. Max Pitruzzella has been a strong influence in international swing dancing in the past decade. One of the world’s top competitors, Max holds countless competition titles to his name. With a powerful and distinct style, Max is known for his innovation, precision and sharpness.",
    "Who would say that dancing wasn’t her one and only path? Audrey has actually studied Fashion and Environment in Duperré School of Applied Arts. For her and our happiness, though, dancing seems to be what also truly moves her. With a joyful smile and dynamic movements, she is always ready to amaze!\nAfter dancing Street Jazz, Rock’n’roll and Salsa for years, she found out  Swing dance for herself in 2007. Today, Audrey is doing what she loves: teaching  Lindy Hop, Charleston and  Authentic Jazz in Paris,  she dances, performs, competes and also – coaches and makes choreographies for her solo jazz girls’ team “The Shimmy Army”. They actually won first place in their very first competition!",
    "Ladies, you might as well get a pen and a piece of paper so that you can have an autograph – we got a real star in here! Gentlemen, you can learn really a lot from that British one. Ryan Francois is such an exciting dancer, that it is hard to decide where to start from. He has devoted more than 30 years to all dances related to the Jazz & Swing era, including Lindy Hop, Jitterbug, Jive, Charleston, Tap, Be Bop and Blues.\n\nWith such a stable experience and with many occurrences and contributions to TV shows, movies and music videos, Ryan is a great professional and always puts his soul in his work. He is popularly known for his choreography for “Strictly Come dancing” and “So You Think You Can Dance”, also  a two time winner of the U.S. Open and American Swing Dance Championships and if that is not enough –some of his best works to date are for the Broadway show “Swing”, nominated for 7 Tony Awards – including best choreography. As you can figure out, the list of other credits is long-long, so the best thing we can do is just experience his genius.",
    "Did you know that St. Petersburg in Russia has more bridges than any city in Europe? About 800 bridges! No, this is not just a random fact. Actually one of our main teachers is from that astonishing place and she is as special as the town itself. Evgenia Salakhutdinova is such an energetic and charming lady, she is like the perfect detail for every dance floor.\n\nThrough the years, she has been dancing Boogie Woogie, Charleston, Authentic jazz, West Coast Swing and Salsa. In 2002 Lindy Hop strikes again and makes another dancer fall in love with it. This is how it all started for her – enjoying social dancing. Further on she joined a performance group, taking part of different competitions, both in Russia and Europe. With the years of experience, Evgenia started to compete internationally as a part of Finnish National team in 2014 and is currently a Finnish champion in Lindy Hop and Boogie Woogie. Teaches Lindy Hop and Boogie Woogie regularly in several schools in St. Petersburg.",
    "Alright. Okay. We’re in love with them! Yes, seriously. If you say ‘William’ and not continue with “and Maeva” or vise-a-versa, it is like the sentence is not complete and something is wrong. When you look at them, you see this complex of both their energies and it is working as one finished perfection. True, their story started long ago with Boogie Woogie, but they have proven that Lindy Hop suits them very well, too!\n\nA bit more than a decade ago, at the age of 14 years old, there in France, the dance floor appeared to be the magic glue that gathered them together. While putting their efforts in the Boogie Woogie, they did a great job by winning the WRRC Boogie-Woogie World Championship four times. In 2011 Lindy Hop took their attention and with their talent and creativity they successfully won quite a good number of competitions during their first year in this dance style. Of course, they haven’t forgotten their original passion. Nowadays, you can see William and Maeva at the biggest international swing festivals. They teach, they dance and spread the joy!"]
    let instrImages:[String] = ["Felipe", "Alice", "Max", "Audrey", "Ryan", "Evgenia", "WM"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
        iv.frame.size.width = 40
        iv.frame.size.height = 40
        iv.contentMode = .ScaleAspectFit
        self.navigationItem.titleView = iv
        
        topButtonView = UIView(frame: CGRectMake(CGFloat(padding)+5, CGFloat(padding), view.frame.width-CGFloat(2*padding), 204))
        topButtonView?.backgroundColor = UIColor.whiteColor()
        scroll!.addSubview(topButtonView!)
        
        let imgContainer:UIView = UIView (frame: CGRectMake(2, 2, (topButtonView?.frame.width)!-4, 200))
        imgContainer.clipsToBounds = true
        topButtonView?.addSubview(imgContainer)
        
        let topImg:UIImage = UIImage (named: "WM")!
        topButtonImage = UIImageView (image: topImg)
        var f = topButtonImage?.frame
        let r = (view.frame.width-CGFloat(2*padding) - 4)/(f?.size.width)!
        f?.size.width = view.frame.width-CGFloat(2*padding) - 4
        f?.size.height = r*(f?.size.height)!
        f?.origin.x = 0
        f?.origin.y = 0
        topButtonImage?.frame = f!
        imgContainer.addSubview(topButtonImage!)
        
        topButton = UIButton (frame: topButtonView!.frame)
        topButton?.addTarget(self, action: #selector(gotoInstructorPage), forControlEvents: .TouchUpInside)
        topButton?.tag = 6
        scroll?.addSubview(topButton!)
        
        applyPlainShadow(topButtonView!)
        
        let tc:Int = 6
        var i:Int = 0
        while i < tc {
            addView(i)
            
            i += 1
        }
    }

    func addView (i:Int) {
        let w = (Float(view.frame.size.width) - padding*3)/2
        let x = padding + Float(i%2) * (w+padding) + 5
        var y = Float((topButtonView?.frame.maxY)!)
        y = y + padding + floor (Float(i/2)) * (w+padding)
        let v:UIView = UIView (frame: CGRectMake(CGFloat(x), CGFloat(y), CGFloat(w), CGFloat(w)))
        
        let iv:UIImageView  = UIImageView (image: UIImage (named: instrImages[i]))
        iv.frame = CGRectMake (2, 2, CGFloat(w-4), CGFloat(w-4))
        iv.contentMode = .ScaleAspectFill
        iv.clipsToBounds = true
        v.addSubview (iv)
        
        applyPlainShadow(v)
        v.backgroundColor = UIColor.whiteColor ()
        
        let b:UIButton = UIButton (frame: CGRectMake(CGFloat(0), CGFloat(0), CGFloat(w), CGFloat(w)))
        b.tag = i
        b.addTarget(self, action: #selector(gotoInstructorPage), forControlEvents: .TouchUpInside)
        v.addSubview(b)
        
        scroll!.addSubview(v)
        
        scroll!.contentSize = CGSize (width: view.frame.size.width, height: v.frame.maxY + CGFloat(padding))
    }

    func applyPlainShadow(v: UIView) {
        let layer = v.layer
        
        layer.shadowColor = UIColor.blackColor().CGColor
        layer.shadowOffset = CGSizeZero
        layer.shadowOpacity = 0.4
        layer.shadowRadius = 3
    }
    
    func gotoInstructorPage (sender: UIButton!) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc:InstructorPageViewController = storyboard.instantiateViewControllerWithIdentifier("InstructorPage") as! InstructorPageViewController
        vc.titleText = instrNames[sender.tag]
        vc.descriptionText = instrDescr[sender.tag]
        vc.imageName = instrImages[sender.tag]
        self.navigationController?.pushViewController(vc, animated: true)
    }
}
