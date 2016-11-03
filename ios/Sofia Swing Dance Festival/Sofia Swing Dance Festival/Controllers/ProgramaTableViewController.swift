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
        
//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv
        
        self.navigationItem.title = "Swing Aout"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    
    let types:[String] = ["boggie", "lindy", "boogieParty", "lindyParty", "boogieOff", "lindyOff"]
    
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 6
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)

        switch (indexPath as NSIndexPath).row {
        case 0:
            cell.textLabel!.text = "Boogie Woogie"
            break
        case 1:
            cell.textLabel!.text = "Lindy"
            break
        case 2:
            cell.textLabel!.text = "PARTY SCHEDULE ( BOOGIE WOOGIE )"
            break
        case 3:
            cell.textLabel!.text = "PARTY SCHEDULE ( LINDY WEEK )"
            break
        case 4:
            cell.textLabel!.text = "Boogie Woogie \\ OFF"
            break
        case 5:
            cell.textLabel!.text = "LINDYHOP/SOLOJAZZ \\ OFF"
            break
        default: break
            
        }
        

        return cell
    }
 
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        
        (segue.destination as! ProgramaPageTableViewController).type = types[(self.tableView.indexPathForSelectedRow! as NSIndexPath).row]
        
    }
 

}
