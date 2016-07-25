//
//  Feed.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/18/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class Feed: NSObject {

    var id:Int = 0
    var title:String = ""
    var text:String = ""
    var imgURL:String = ""
    var date:String = ""
    
    override init () {
        
    }
    
    init (item:JSON) {
        id = item["id"].asInt!
        title = item["title"].asString!
        text = item["text"].asString!
        if (!item["cover"].isNull) {
            imgURL = item["cover"].asString!
        }
        let d = item["updated_at"].asString!
        date = "\(d[d.startIndex.advancedBy(11)..<d.startIndex.advancedBy(16)]), \(d[d.startIndex.advancedBy(0)..<d.startIndex.advancedBy(10)])"
    }
}
