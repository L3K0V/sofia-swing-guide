//
//  NewsController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/14/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit
import AFOAuth2Manager

class NewsController: UITableViewController {

    let baseURL = NSURL(string: "http://ssdf.tempest.bg")
    var credentianls:AFOAuthCredential = AFOAuthCredential()
    var alert:UIAlertController = UIAlertController()
    
    var feed:[Feed] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem()
        
        tableView.tableFooterView = UIView()
        
        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
        iv.frame.size.width = 40
        iv.frame.size.height = 40
        iv.contentMode = .ScaleAspectFit
        self.navigationItem.titleView = iv
        
        alert = UIAlertController(title: nil, message: "Loading...", preferredStyle: .Alert)
        presentViewController(alert, animated: true, completion: nil)
        
        let manager:AFOAuth2Manager = AFOAuth2Manager(baseURL: baseURL!,
                                      clientID: "RUjQF9EH2wnDjcVFGEQ2AiWpKjELGyvChvUCA7Xc",
                                      secret: "JyS5oZecZYJEQOHJjboEJjsdoxNK1ORzA883kLYQyWO8EQycMByStASmKEPXjhujMsj4wPLjyruKhrZQxrdVSU25b7dHECp41ro5uIlzSeUqY9zNAAQvSbHfNbOJz1E2")
        
        let parameters:[String:String] = ["grant_type": "client_credentials"]
        manager.authenticateUsingOAuthWithURLString("/oauth2/token/",
                                                    parameters: parameters,
                                                    success: { (cr) in
                                                        AFOAuthCredential.storeCredential(cr, withIdentifier: "credential")
                                                        self.credentianls = cr
                                                        self.loadNews()
            }) { (error) in
                self.dismissViewControllerAnimated(false, completion: {
                    
                })
                print (error)
        }
        
    }

    func loadNews () {
        let manager:AFHTTPSessionManager = AFHTTPSessionManager(baseURL: baseURL)
        manager.requestSerializer.setAuthorizationHeaderFieldWithCredential(credentianls)
        
        manager.GET("/feed/",
                   parameters: nil,
                   progress: { (pro) in
                    
            }, success: { (task, res) in
                let json = JSON(res!)
//                print("daaa \(json["results"])")
                for (_, item) in json["results"] {
                    self.feed.append(Feed(item: item))
                }
                self.dismissViewControllerAnimated(false, completion: {
                    
                })
                self.tableView.reloadData()
        }) { (task, error) in
            self.dismissViewControllerAnimated(false, completion: {
                
            })
            print ("neee \(error)")
        }
    }

    // MARK: - Table view data source

    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return feed.count
    }

    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 1
    }

    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("newsIdentifier", forIndexPath: indexPath)

        let f = feed[feed.count - indexPath.section - 1]
        cell.imageView!.image = UIImage (named: "Logo")
        cell.textLabel!.text = f.title
        cell.detailTextLabel!.text = f.date
        
        
        return cell
    }
    
    override func tableView(tableView: UITableView,
                              heightForHeaderInSection section: Int) -> CGFloat{
        return 6
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

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        
//        let path = self.tableView.indexPathForSelectedRow!
        let sect:Int = (tableView.indexPathForSelectedRow?.section)!
        (segue.destinationViewController as! NewsPageController).feed = feed[feed.count - sect - 1]
    }
}
