//
//  ContactController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/15/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class ContactController: UIViewController {

    @IBOutlet weak var view1: UIView?
    @IBOutlet weak var view2: UIView?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.navigationItem.title = "Swing Aout"
        
//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv
        
        applyPlainShadow(view1!)
        applyPlainShadow(view2!)
    }

    func applyPlainShadow(v: UIView) {
        let layer = v.layer
        
        layer.shadowColor = UIColor.blackColor().CGColor
        layer.shadowOffset = CGSizeZero
        layer.shadowOpacity = 0.4
        layer.shadowRadius = 3
    }
    @IBAction func fbLH(sender: AnyObject) {
        if let requestUrl = NSURL(string: "https://www.facebook.com/swingaoutfestival2015/") {
            UIApplication.sharedApplication().openURL(requestUrl)
        }
    }
    @IBAction func webLH(sender: AnyObject) {
        if let requestUrl = NSURL(string: "www.swingaout.com") {
            UIApplication.sharedApplication().openURL(requestUrl)
        }
    }
    @IBAction func phone(sender: AnyObject) {
        if let url = NSURL(string: "tel://+33678834569") {
            UIApplication.sharedApplication().openURL(url)
        }
    }
    @IBAction func mailLH(sender: AnyObject) {
        let url = NSURL(string: "mailto:swingaoutcontact@gmail.com")
        UIApplication.sharedApplication().openURL(url!)
    }
    @IBAction func fbSF(sender: AnyObject) {
        if let requestUrl = NSURL(string: "https://www.facebook.com/events/845806628881838/") {
            UIApplication.sharedApplication().openURL(requestUrl)
        }
    }
    @IBAction func webSF(sender: AnyObject) {
        if let requestUrl = NSURL(string: "http://sofiaswing.com/contact/") {
            UIApplication.sharedApplication().openURL(requestUrl)
        }
    }
}
