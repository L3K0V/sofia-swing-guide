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

    func applyPlainShadow(_ v: UIView) {
        let layer = v.layer
        
        layer.shadowColor = UIColor.black.cgColor
        layer.shadowOffset = CGSize.zero
        layer.shadowOpacity = 0.4
        layer.shadowRadius = 3
    }
    @IBAction func fbLH(_ sender: AnyObject) {
        if let requestUrl = URL(string: "https://www.facebook.com/swingaoutfestival2015/") {
            UIApplication.shared.openURL(requestUrl)
        }
    }
    @IBAction func webLH(_ sender: AnyObject) {
        if let requestUrl = URL(string: "www.swingaout.com") {
            UIApplication.shared.openURL(requestUrl)
        }
    }
    @IBAction func phone(_ sender: AnyObject) {
        if let url = URL(string: "tel://+33678834569") {
            UIApplication.shared.openURL(url)
        }
    }
    @IBAction func mailLH(_ sender: AnyObject) {
        let url = URL(string: "mailto:swingaoutcontact@gmail.com")
        UIApplication.shared.openURL(url!)
    }
    @IBAction func fbSF(_ sender: AnyObject) {
        if let requestUrl = URL(string: "https://www.facebook.com/events/845806628881838/") {
            UIApplication.shared.openURL(requestUrl)
        }
    }
    @IBAction func webSF(_ sender: AnyObject) {
        if let requestUrl = URL(string: "http://sofiaswing.com/contact/") {
            UIApplication.shared.openURL(requestUrl)
        }
    }
}
