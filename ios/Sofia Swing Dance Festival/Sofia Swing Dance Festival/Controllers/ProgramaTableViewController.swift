//
//  ProgramaTableViewController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/19/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class ProgramaTableViewController: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.tableFooterView = UIView()
        
        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
        iv.frame.size.width = 40
        iv.frame.size.height = 40
        iv.contentMode = .ScaleAspectFit
        self.navigationItem.titleView = iv
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 8
    }

    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("reuseIdentifier", forIndexPath: indexPath)

        switch indexPath.row {
        case 0:
            cell.textLabel!.text = "Parties and Collective activities"
            break
        case 1:
            cell.textLabel!.text = "Tasters"
            break
        case 2:
            cell.textLabel!.text = "Intermediate"
            break
        case 3:
            cell.textLabel!.text = "Intermediate-Advance 1"
            break
        case 4:
            cell.textLabel!.text = "Intermediate-Advance 2"
            break
        case 5:
            cell.textLabel!.text = "Advance"
            break
        case 6:
            cell.textLabel!.text = "Advance+"
            break
        case 7:
            cell.textLabel!.text = "Invitation"
            break
        default: break
            
        }
        

        return cell
    }
 

    /*
    // Override to support conditional editing of the table view.
    override func tableView(tableView: UITableView, canEditRowAtIndexPath indexPath: NSIndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(tableView: UITableView, commitEditingStyle editingStyle: UITableViewCellEditingStyle, forRowAtIndexPath indexPath: NSIndexPath) {
        if editingStyle == .Delete {
            // Delete the row from the data source
            tableView.deleteRowsAtIndexPaths([indexPath], withRowAnimation: .Fade)
        } else if editingStyle == .Insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(tableView: UITableView, moveRowAtIndexPath fromIndexPath: NSIndexPath, toIndexPath: NSIndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(tableView: UITableView, canMoveRowAtIndexPath indexPath: NSIndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    // MARK: - Navigation

    let types:[String] = ["others", "tasters", "int", "int-adv1", "int-adv2", "adv", "adv+", "inv"]
    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        
        (segue.destinationViewController as! ProgramaPageTableViewController).type = types[self.tableView.indexPathForSelectedRow!.row]
        
    }
 

}
