//
//  Programa.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/19/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class Programa: NSObject {

    var hour:String = ""
    var hall:String = ""
    var title:String = ""
    
    override init () {
        
    }
    
    init (h:String, hl:String, t:String) {
        hour = h
        hall = hl
        title = t
    }
}
