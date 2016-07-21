//
//  LocationCellTableViewCell.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/18/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class LocationCellTableViewCell: UITableViewCell {

    @IBOutlet weak var titleLabel: UILabel?
    @IBOutlet weak var descrionLabel: UILabel?
    @IBOutlet weak var button: UIButton?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
