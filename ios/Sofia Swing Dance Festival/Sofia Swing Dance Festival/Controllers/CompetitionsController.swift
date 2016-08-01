//
//  CompetitionsController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/15/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class CompetitionsController: UIViewController {

    @IBOutlet weak var view1: UIView?
    @IBOutlet weak var view2: UIView?
    @IBOutlet weak var view3: UIView?
    @IBOutlet weak var view4: UIView?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv

        self.navigationItem.title = "Swing Aout"
        
        applyPlainShadow(view1!)
        applyPlainShadow(view2!)
        applyPlainShadow(view3!)
        applyPlainShadow(view4!)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func applyPlainShadow(v: UIView) {
        let layer = v.layer
        
        layer.shadowColor = UIColor.blackColor().CGColor
        layer.shadowOffset = CGSizeZero
        layer.shadowOpacity = 0.4
        layer.shadowRadius = 3
    }

}
