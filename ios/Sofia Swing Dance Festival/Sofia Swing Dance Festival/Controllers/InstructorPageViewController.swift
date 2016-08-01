//
//  InstructorPageViewController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/14/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class InstructorPageViewController: UIViewController {

    @IBOutlet weak var scroll: UIScrollView?
    @IBOutlet weak var image: UIImageView?
    @IBOutlet weak var titleLabel: UILabel?
    @IBOutlet weak var descrionLabel: UILabel?
    
    var titleText:String = ""
    var descriptionText: String = ""
    var imageName:String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv

        self.navigationItem.title = "Swing Aout"
        
        self.titleLabel?.text = titleText
        self.descrionLabel?.text = descriptionText
        self.image?.image = UIImage (named: imageName)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

}
