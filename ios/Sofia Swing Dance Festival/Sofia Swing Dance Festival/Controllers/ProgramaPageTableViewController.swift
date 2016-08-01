//
//  ProgramaPageTableViewController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/19/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class ProgramaPageTableViewController: UITableViewController {

    var type:String = ""
    
    let sections:[String] = ["Jeudi / 11.08", "Vendredi / 12.08", "Samedi / 13.08", "Lundi / 15.08", "Mardi / 16.08", "Jeudi / 18.08", "Vendredi / 19.08", "Samedi / 20.09"]
    
    
    // Boggie
    let boggieHoursT:[Programa] = [Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Cours Découverte Gratuit\r\nNicolas & Irene"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Boogie Competition ( en couple )\nThobjorn & Flora"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Boogie Intermediaire\nThobjorn & Flora"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Boogie Avancé\nWilliam & Maeva"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 1", t: "Boogie Intermediaire\nThobjorn & Flora"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 2", t: "Boogie Avancé\nWilliam & Maeva"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 1", t: "Boogie Débutant\nSondre & Tanya"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 2", t: "Boogie Novices\nJeff & Joelle"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 1", t: "Boogie Débutant\nSondre & Tanya"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 2", t: "Boogie Novices\nJeff & Joelle")]
    
    let boggieHoursF:[Programa] = [Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Cours Découverte Gratuit\nJeff & Joelle"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Boogie Competition ( en couple )\nSondre & Tanya"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Boogie Intermediaire\nSondre & Tanya"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Boogie Avancé\nThobjorn & Flora"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 1", t: "Boogie Intermediaire\nSondre & Tanya"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 2", t: "Boogie Avancé\nThobjorn & Flora"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 1", t: "Boogie Débutant\nWilliam & Maeva"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 2", t: "Boogie Novices\nJeff & Joelle"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 1", t: "Boogie Débutant\nWilliam & Maeva"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 2", t: "Boogie Novices\nNicolas & Irene")]
    
    let boggieHoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Cours Découverte Gratuit\nMartin & Cathy"),
                                    Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Boogie Competition ( en couple )\nPontus & Isabella"),
                                    Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Boogie Intermediaire\nSondre & Tanya"),
                                    Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Boogie Avancé\nPontus & Isabella"),
                                    Programa(h: "13:20-14:20", hl: "Chapiteau 1", t: "Boogie Intermediaire\nThobjorn & Flora"),
                                    Programa(h: "13:20-14:20", hl: "Chapiteau 2", t: "Boogie Avancé\nSondre & Tanya"),
                                    Programa(h: "14:30-15:30", hl: "Chapiteau 1", t: "Boogie Débutant\nThobjorn & Flora"),
                                    Programa(h: "14:30-15:30", hl: "Chapiteau 2", t: "Boogie Novices\nMartin & Cathy"),
                                    Programa(h: "15:40-16:40", hl: "Chapiteau 1", t: "Boogie Débutant\nSondre & Tanya"),
                                    Programa(h: "15:40-16:40", hl: "Chapiteau 2", t: "Boogie Novices\nMartin & Cathy")]
    
    // Lindy hop
    let lindyHoursM:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nMax & Audrey"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                  Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nMax & Audrey"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMiguel & Carla"),
                                  Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                  Programa(h: "14:00-15:10", hl: "Salle Polyvalente", t: "Solo JAzz Inter\nNicolas Rodriguez"),
                                  Programa(h: "14:00-15:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "14:00-15:10", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nOliv"),
                                  Programa(h: "15:20-16:20", hl: "Salle Polyvalente", t: "Solo Jazz Avancé\nCarla"),
                                  Programa(h: "15:20-16:20", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "16:20-17:20", hl: "Chapiteau 1", t: "SoloJazz Avancé +\nTatiana"),
                                  ]
    
    let lindyHoursTu:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nJb & Tatiana"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nPontus & Isabella"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThomas & Maeva"),
                                   Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nJb & Tatiana"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nPontus & Isabella"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThomas & Maeva"),
                                   Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                   Programa(h: "14:00-15:10", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nMax & Audrey"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nJb & Tatiana"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 2", t: "Lindy Hop Inter\nThomas & Maeva"),
                                   Programa(h: "15:20-16:20", hl: "Salle Polyvalente", t: "Solo Jazz\nAvancé + Max"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 1", t: "Solo Jazz Avancé\nAndy"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 2", t: "Lindy Hop Inter\nThomas & Maeva"),
                                   Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nNicolas Rodriguez"),
                                   Programa(h: "16:20-17:20", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nAudrey")]
    
    let lindyHoursTh:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nJb & Tatiana"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nMax & Audrey"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                   Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nJb & Tatiana"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nMax & Audrey"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                   Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                   Programa(h: "14:00-15:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nPontus & Isabella"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé+\nMax & Audrey"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nNicolas Rodriguez"),
                                   Programa(h: "15:20-16:20", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nJb Mino"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 1", t: "Lindy Hop Avancé+\nThomas & Maeva"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nNicolas Rodriguez"),
                                   Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Avancé\nAndy"),
                                   Programa(h: "21:00-22:00", hl: "", t: "Cour de musicalité avec\nOliv Wan"),
                                   ]
    
    let lindyHoursF:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nJb & Tatiana"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMiguel & Carla"),
                                  Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nJb & Tatiana"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMiguel & Carla"),
                                  Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                  Programa(h: "14:00-15:00", hl: "Salle Polyvalente", t: "Solo Jazz Avancé +\nAndy"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 1", t: "Solo Jazz Avancé\nOliv Wan"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 2", t: "Lindy Hop Inter\nMiguel & Carla"),
                                  Programa(h: "15:00-16:10", hl: "Salle Polyvalente", t: "Solo Jazz Avancé +\nAndy"),
                                  Programa(h: "15:00-16:10", hl: "Chapiteau 1", t: "Solo Jazz Avancé\nOliv Wan"),
                                  Programa(h: "15:00-16:10", hl: "Chapiteau 2", t: "Lindy Hop Inter\nMiguel & Carla"),
                                  Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nAndy"),
                                  Programa(h: "16:20-17:20", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nNicolas Rodriguez")]
    
    let lindyHoursS:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nPontus & Isabella"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                  Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nPontus & Isabella"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMax & Audrey"),
                                  Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                  Programa(h: "14:00-15:00", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nNicolas Rodriguez"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nJb & Tatiana"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nPontus & Isabella"),
                                  Programa(h: "15:10-16:10", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nMiguel"),
                                  Programa(h: "15:10-16:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nMax & Audrey"),
                                  Programa(h: "15:10-16:10", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nOliv Wan"),
                                  Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Avancé\nOliv Wan"),
                                  Programa(h: "16:20-17:20", hl: "Chapiteau 1", t: "Solo Jazz Avancé +\nJb Mino")]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.tableFooterView = UIView()
        
        switch type {
        case "lindy":
            title = "Lindy hop"
            break
        case "boggie":
            title = "Boggie"
            break
            
        default:
            break
        }
    }

    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        if (type == "boggie") {
            return 3
        }
        
        return 5;
    }

    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        switch type {
        case "boggie":
            if (section == 0) {return boggieHoursT.count}
            if (section == 1) {return boggieHoursF.count}
            if (section == 2) {return boggieHoursSt.count}
            break
        case "lindy":
            if (section == 0) {return lindyHoursM.count}
            if (section == 1) {return lindyHoursTu.count}
            if (section == 2) {return lindyHoursTh.count}
            if (section == 3) {return lindyHoursF.count}
            if (section == 4) {return lindyHoursS.count}
            break
        default:
            break
        }
        
        return 0
    }

    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:ProgaramaPageTableViewCell = tableView.dequeueReusableCellWithIdentifier("reuseIdentifier", forIndexPath: indexPath) as! ProgaramaPageTableViewCell

        var pg:Programa = Programa()
        switch type {
        case "boggie":
            if (indexPath.section == 0) {pg = boggieHoursT[indexPath.row]}
            if (indexPath.section == 1) {pg = boggieHoursF[indexPath.row]}
            if (indexPath.section == 2) {pg = boggieHoursSt[indexPath.row]}
            break
        case "lindy":
            if (indexPath.section == 0) {pg = lindyHoursM[indexPath.row]}
            if (indexPath.section == 1) {pg = lindyHoursTu[indexPath.row]}
            if (indexPath.section == 2) {pg = lindyHoursTh[indexPath.row]}
            if (indexPath.section == 3) {pg = lindyHoursF[indexPath.row]}
            if (indexPath.section == 4) {pg = lindyHoursS[indexPath.row]}
            break
            
        default:
            break
        }

        cell.titleLabel?.text = pg.title
        cell.hourLabel?.text = pg.hour
        cell.hallLabel?.text = pg.hall
        cell.hallLabel?.backgroundColor = UIColor.whiteColor()
        if (pg.hall == "Salle Polyvalente") {
            cell.hallLabel?.backgroundColor = UIColor(red: 102.0/255.0, green: 1, blue: 0, alpha: 1.0)
        }
        if (pg.hall == "Chapiteau 1") {
            cell.hallLabel?.backgroundColor = UIColor(red: 1, green: 0.75, blue: 0, alpha: 1.0)
        }
        if (pg.hall == "Chapiteau 2") {
            cell.hallLabel?.backgroundColor = UIColor(red: 0.57, green: 0.82, blue: 0.31, alpha: 1.0)
        }
        
        
        return cell
    }
 

    override func tableView(tableView: UITableView,
                            heightForHeaderInSection section: Int) -> CGFloat{
        return 30
    }
    
    override func tableView(tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int)
    {
        let header = view as! UITableViewHeaderFooterView
        header.textLabel?.textColor = UIColor.lightGrayColor()
        if (type == "boggie") {
            header.textLabel?.text = sections[section]
        }
        else {
            header.textLabel?.text = sections[section+3]
        }
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

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
