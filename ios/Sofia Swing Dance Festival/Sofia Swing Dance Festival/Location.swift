
//
//  Location.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/18/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class Location: NSObject {
    
    var id:Int = 0
    var title:String = ""
    var text:String = ""
    var lat:Double = 0
    var lon:Double = 0
    
    override init () {
        
    }
    
    init (item:JSON) {
//        id = item["id"].asInt!
//        title = item["title"].asString!
//        text = item["text"].asString!
        if (!item["properties"].isNull) {
            if (!item["name"].isNull) {
                title = item["properties"]["name"].asString!
            }
            if (!item["description"].isNull) {
                text = item["properties"]["description"].asString!
            }
        }
        if (!item["geometry"].isNull) {
            if (!item["geometry"]["coordinates"].isNull) {
                lat = item["geometry"]["coordinates"][1].asDouble!
                lon = item["geometry"]["coordinates"][0].asDouble!
            }
        }
    }
}
