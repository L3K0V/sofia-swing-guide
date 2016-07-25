//
//  NewsPageController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/15/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit
import SDWebImage

class NewsPageController: UIViewController {

    @IBOutlet weak var scroll: UIScrollView?
    @IBOutlet weak var image: UIImageView?
    @IBOutlet weak var titleLabel: UILabel?
    @IBOutlet weak var descrionLabel: UITextView?
    @IBOutlet weak var contentHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var descriptionHeightConstraint: NSLayoutConstraint!
    
    var feed:Feed = Feed()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
        iv.frame.size.width = 40
        iv.frame.size.height = 40
        iv.contentMode = .ScaleAspectFit
        self.navigationItem.titleView = iv
        
        self.titleLabel?.text = feed.title
        self.descrionLabel?.text = feed.text
        
        self.descrionLabel!.sizeToFit()
        self.descrionLabel!.layoutIfNeeded()
        let height = self.descrionLabel!.sizeThatFits(CGSizeMake(self.descrionLabel!.frame.size.width, CGFloat.max)).height
        descriptionHeightConstraint.constant = height
        self.descrionLabel!.layoutIfNeeded()
        contentHeightConstraint.constant = self.descrionLabel!.frame.maxY + 20
        self.descrionLabel?.superview!.layoutIfNeeded ()
        
        if (feed.imgURL == "") {
            self.image?.image = UIImage(named: "Logo")
            self.image?.contentMode = .ScaleAspectFit
            self.image?.backgroundColor = UIColor(red: 21/255, green: 117/255, blue: 191/255, alpha: 1.0)
        }
        else {
            self.image!.sd_setImageWithURL(NSURL(string: feed.imgURL))
        }
    }
    
    
}
